package views;

import javax.swing.*;

public class ClientDataView extends JFrame{
    private JPanel ClientDataMain;
    private JPanel Title;
    private JPanel UserName;
    private JPanel NameSurName;
    private JPanel Doc;
    private JPanel Direc;
    private JPanel Categ;
    private JPanel Button;
    private JLabel TitleL;
    private JTextField userNameF;
    private JLabel userNameLabel;
    private JTextField NombreF;
    private JTextField DocF;
    private JTextField CalleF;
    private JTextField CategF;
    private JButton volverButton;
    private JButton verPagosButton;
    private JTextField ApellidoF;
    private JLabel NombreL;
    private JLabel ApellidoL;
    private JLabel DocL;
    private JTextField NumF;
    private JTextField CodPostalF;
    private JLabel CalleL;
    private JLabel NumL;
    private JLabel CodPostalL;
    private JLabel CategL;


    public ClientDataView(){

        setContentPane(ClientDataMain);


        setTitle("Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);




    }







}
