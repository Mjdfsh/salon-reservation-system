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

public class ServicesWindow extends JFrame{



    private JLabel maintext = new JLabel("Show Bill");

    private JCheckBox checkBox1 = new JCheckBox("Blow Dry  100SAR");
private JCheckBox checkBox2 = new JCheckBox("Hair cut with Blow Dry  150SAR");
    private JCheckBox checkBox3 = new JCheckBox("Eyebrow  50SAR");
    private JCheckBox checkBox4 = new JCheckBox("Eyebrow & Lip  75SAR");
    private JCheckBox checkBox5= new JCheckBox("Conditioning Treatment  150SAR");
    private JCheckBox checkBox6 = new JCheckBox("Olaplex treatment  150SAR" );


    private JButton buttonShow = new JButton("Next");


    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,200,25));



    private JPanel panelInfo = new JPanel(new GridLayout(4,2,25,25));


    public ServicesWindow(){

        setTitle("Salon");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        maintext.setFont(new Font("Serif",Font.BOLD,35));
        maintext.setForeground(Color.white);
        panel.setBackground(Color.DARK_GRAY);

        panelInfo.setBackground(Color.darkGray);

        panelInfo.add(checkBox1);
        panelInfo.add(checkBox2);
        panelInfo.add(checkBox3);
        panelInfo.add(checkBox4);
        panelInfo.add(checkBox5);
        panelInfo.add(checkBox6);

        panel.add(maintext);
        panel.add(panelInfo);
        panel.add(buttonShow);
        add(panel);

        setVisible(true);


        buttonShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double total = 0;

                if (checkBox1.isSelected()){

                    total+=100;

                }if (checkBox2.isSelected()){

                    total+=50;

                }if (checkBox3.isSelected()){

                    total+=150;

                }if (checkBox4.isSelected()){

                    total+=150;

                }if (checkBox5.isSelected()){

                    total+=75;

                }if (checkBox6.isSelected()){

                    total+=150;

                }
//                String receipt = "- Total: "+total;
//                receipt += "\n\n- Tax:  "+total*0.15;
//                receipt += "\n\n- total with tax:  "+(total*0.15) + total;
//                JOptionPane.showMessageDialog(null,receipt);

                setVisible(false);


                new InformationWindow(total);



            }
        });


    }

}
