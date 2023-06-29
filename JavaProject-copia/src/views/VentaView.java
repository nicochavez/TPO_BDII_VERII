package views;

import javax.swing.*;

public class VentaView extends JFrame{
    private JPanel VentaMain;
    private JPanel Title;
    private JPanel UserData;
    private JScrollPane ProductList;
    private JPanel AddProduct;
    private JPanel Button;
    private JLabel TitleL;
    private JComboBox ProductCombo;
    private JTextField CantidadF;
    private JButton agregarProductoButton;
    private JButton atrásButton;
    private JButton confirmarButton;
    private JTable ProductT;
    private JTextField NombreF;
    private JTextField ApellidoF;
    private JLabel ApellidoL;
    private JLabel NombreL;


    public VentaView(){

        setContentPane(VentaMain);


        setTitle("VentaView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);



    }








}
