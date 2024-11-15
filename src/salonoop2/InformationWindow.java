package salonoop2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

//Majd Alshehri    2111632
//Nihal Kutbi      2115006
//D9S

public class InformationWindow extends JFrame{


    private JLabel maintext = new JLabel("Information");

    private JLabel phonelabel = new JLabel("Enter phone nunmber");
    private JTextField phonetextFiled = new JTextField(20);


    private JLabel emaillabel = new JLabel("Enter Email address");
    private JTextField emailtextFiled = new JTextField(20);

    private JButton buttonNext = new JButton("Finish");


    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,200,25));

    private JPanel panelInfo = new JPanel(new GridLayout(2,2,25,25));

    double total;

    public InformationWindow(double total){

        this.total = total;
        setTitle("Salon");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        maintext.setFont(new Font("Serif",Font.BOLD,35));
        maintext.setForeground(Color.white);
        panel.setBackground(Color.DARK_GRAY);

        panelInfo.setBackground(Color.darkGray);
        emaillabel.setForeground(Color.white);
        phonelabel.setForeground(Color.white);

        panel.add(maintext);
        panelInfo.add(emaillabel);
        panelInfo.add(emailtextFiled);
        panelInfo.add(phonelabel);
        panelInfo.add(phonetextFiled);
        panel.add(panelInfo);
        panel.add(buttonNext);
        add(panel);

        setVisible(true);

        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                                String receipt = "- Total: "+total;
                receipt += "\n\n- Tax:  "+total*0.15;
                receipt += "\n\n- total with tax:  "+ ((total*0.15) + total);
                JOptionPane.showMessageDialog(null,receipt);

                try {
                    FileWriter file = new FileWriter("receipt.txt");

                    file.write(phonetextFiled.getText()+"\n");
                    file.write(total +"\n");
                    file.close();

                    setVisible(false);

                    new MainWindow();


                } catch (IOException e) {

                }

            }
        });


    }


}
