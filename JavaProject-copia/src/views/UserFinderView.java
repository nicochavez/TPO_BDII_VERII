package views;

import javax.swing.*;

public class UserFinderView extends JFrame{
    private JPanel UserFinderMain;
    private JPanel Title;
    private JPanel UserFinder;
    private JPanel Button;
    private JLabel TitleL;
    private JTextField UserFinderF;
    private JButton volverButton;
    private JButton confirmarUsuarioButton;




    public UserFinderView(){

        setContentPane(UserFinderMain);


        setTitle("Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);



    }






}
