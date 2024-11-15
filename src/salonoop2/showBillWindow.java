package salonoop2;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Majd Alshehri    2111632
//Nihal Kutbi      2115006
//D9S

public class showBillWindow extends JFrame{



    private JLabel maintext = new JLabel("Show Bill");

    private JLabel phonelabel = new JLabel("Enter phone nunmber");
    private JTextField phonetextFiled = new JTextField(20);


    private JButton buttonBook = new JButton("Book");


    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,200,25));

    private JPanel panelInfo = new JPanel(new GridLayout(1,2,25,25));


    public showBillWindow(){

        setTitle("Salon");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        maintext.setFont(new Font("Serif",Font.BOLD,35));
        maintext.setForeground(Color.white);
        panel.setBackground(Color.DARK_GRAY);

        panelInfo.setBackground(Color.darkGray);
        phonelabel.setForeground(Color.white);

        panel.add(maintext);
        panelInfo.add(phonelabel);
        panelInfo.add(phonetextFiled);
        panel.add(panelInfo);
        panel.add(buttonBook);
        add(panel);

        setVisible(true);


        buttonBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                File file = new File("receipt.txt");
                Scanner fileRead = null;
                try {
                    fileRead = new Scanner(file);



                    while (fileRead.hasNextLine()){

                        String phone = fileRead.nextLine();
                        double total = Double.parseDouble(fileRead.nextLine());

                        if (phone.equals(phonetextFiled.getText())){

                            String receipt = "- Total: "+total;
                            receipt += "\n\n- Tax:  "+total*0.15;
                            receipt += "\n\n- total with tax:  "+((total*0.15) + total);
                            JOptionPane.showMessageDialog(null,receipt);

                            setVisible(false);

                            new MainWindow();

                        }

                    }
                } catch (FileNotFoundException e) {

                }


            }
        });


    }


}
