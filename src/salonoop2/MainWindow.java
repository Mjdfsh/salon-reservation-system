package salonoop2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Majd Alshehri    2111632
//Nihal Kutbi      2115006
//D9S

public class MainWindow extends JFrame{

    private JLabel maintext = new JLabel("Main");
    private JButton buttonFisrt = new JButton("Book Service");
    private JButton buttonSecond = new JButton("Show My Bill");

    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,200,25));

    private ImageIcon icon = new ImageIcon("logo.jpg");
    private JLabel image = new JLabel(icon);

    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu about = new JMenu("About");
    private JMenuItem item1 = new JMenuItem("Close");
    private JMenuItem item2 = new JMenuItem("Contact us");


    public MainWindow(){

        setTitle("Salon");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        maintext.setFont(new Font("Serif",Font.BOLD,35));
        maintext.setForeground(Color.white);
        panel.setBackground(Color.DARK_GRAY);

        file.add(item1);
        about.add(item2);
        menu.add(file);
        menu.add(about);

        setJMenuBar(menu);


        panel.add(image);
        panel.add(maintext);
        panel.add(buttonFisrt);
        panel.add(buttonSecond);

        add(panel);

        setVisible(true);


        buttonFisrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                new ServicesWindow();
            }
        });

        buttonSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                new showBillWindow();
            }
        });

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"You can Visit us, out location near of King Abdullah Road");
            }
        });


    }

}
