package views;

import javax.swing.*;

public class ClientListView extends JFrame{
    private JPanel ClientListMain;
    private JLabel TitleL;
    private JPanel Title;
    private JScrollPane ClientList;
    private JPanel Button;
    private JButton volverButton;
    private JTextField DocF;
    private JButton verDatosClienteButton;
    private JTable table1;




    public ClientListView(){


        setContentPane(ClientListMain);


        setTitle("Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);





    }







}
