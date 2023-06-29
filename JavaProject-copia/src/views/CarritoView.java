package views;

import controladores.views.CarritoViewController;
import controladores.views.ClienteViewController;
import modelo.pedidos.Item;
import modelo.producto.Producto;
import modelo.usuario.Usuario;
import modelo.pedidos.Carrito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarritoView extends JFrame{
    private JPanel CarritoMain;
    private JPanel Title;
    private JPanel Button;
    private JScrollPane Carrito;
    private JButton volverButton;
    private JButton actualizarCarritoButton;
    private JButton pedirButton;
    private JTable carritoT;
    private JLabel TitleL;
    private JPanel precioTotal;
    private JTextField precioTotalF;
    private JLabel precioTotalL;


    public CarritoView(Usuario cliente){

        setContentPane(CarritoMain);


        setTitle("CarritoView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);


        DefaultTableModel modeloTabla = new DefaultTableModel();

        carritoT.setModel(modeloTabla);



        Carrito carrito = CarritoViewController.getCarrito();


        List<Item> items = carrito.getProductos();




        String[] titulos = {"Producto", "Cantidad", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);



        for(Item i: items){
            Object[] fila = new Object[2];

            fila[0] = i.getProducto();
            fila[1] = i.getCantidad();

            double precio = i.getProducto().getPrecio();

            double descuento = i.getProducto().getDescuento();

            double precioFinal = (precio-descuento);

            fila[2] = precioFinal;

            modeloTabla.addRow(fila);

        }



        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarritoViewController.carritoView.setVisible(false);
                ClienteViewController.clienteView.setVisible(true);
            }
        });

        actualizarCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        pedirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}



