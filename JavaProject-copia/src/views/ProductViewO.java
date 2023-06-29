package views;

import javax.swing.*;

public class ProductViewO extends JFrame{
    private JPanel ProductMain;
    private JPanel TitleP;
    private JPanel NombreP;
    private JPanel DescripcionP;
    private JPanel PrecioP;
    private JPanel DescuentoP;
    private JPanel ImageP;
    private JPanel Button;
    private JButton volverButton;
    private JButton confirmarCambiosButton;
    private JTextField NombreF;
    private JTextField DescripcionF;
    private JTextField PrecioF;
    private JTextField DescuentoF;
    private JLabel NombreL;
    private JLabel DescripcionL;
    private JLabel PrecioL;
    private JLabel DescuentoL;
    private JLabel ImageL;
    private JLabel TitleL;


    public ProductViewO(){

        setContentPane(ProductMain);


        setTitle("Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);



    }







}
