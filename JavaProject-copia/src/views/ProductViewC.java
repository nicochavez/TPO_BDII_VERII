package views;

import controladores.pedidos.ControladorCarritoBD;
import controladores.views.ClienteViewController;
import controladores.views.ProductListViewCController;
import controladores.views.ProductViewCController;
import modelo.pedidos.Item;
import modelo.producto.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductViewC extends JFrame{
    private JPanel ProductMain;
    private JPanel NombreP;
    private JPanel DescripciónP;
    private JPanel PrecioP;
    private JPanel DescuentoP;
    private JPanel Title;
    private JPanel ImageP;
    private JLabel ImageL;
    private JLabel TitleL;
    private JButton volverButton;
    private JButton agregarAlCarritoButton;
    private JPanel Button;
    private JTextField NombreF;
    private JTextField DescripcionF;
    private JTextField PrecioF;
    private JTextField DescuentoF;
    private JLabel NombreL;
    private JLabel DescripcionL;
    private JLabel PrecioL;
    private JLabel DescuentoL;


    public ProductViewC(Producto producto){

        setContentPane(ProductMain);


        setTitle("ProductViewC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);


        NombreF.setText(producto.getNombre());
        DescripcionF.setText(producto.getDescripcion());
        PrecioF.setText(Double.toString(producto.getPrecio()));
        DescuentoF.setText(Double.toString(producto.getDescuento()));


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductListViewCController.createView();
                ProductViewCController.productViewC.setVisible(false);
                ProductListViewCController.productListView.setVisible(true);
            }
        });

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item = new Item(producto, 1);
                ControladorCarritoBD.addToCarrito(ClienteViewController.getCliente(), item);
            }
        });
    }


    public static void main(String[] args) {

        String nombre = "Placa";
        String desc = "Es una placa";
        double precio = 750;
        double descuento = 5;

        Producto product = new Producto(nombre, desc, precio, 101, descuento);

        new ProductViewC(product).setVisible(true);


    }


}
