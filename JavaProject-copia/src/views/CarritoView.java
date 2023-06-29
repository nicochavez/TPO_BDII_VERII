package views;

import controladores.pedidos.ControladorCarritoBD;
import controladores.producto.ControladorProductosBD;
import controladores.views.CarritoViewController;
import controladores.views.ClienteViewController;
import controladores.views.PagoVistaController;
import modelo.pedidos.Item;
import modelo.pedidos.Pedido;
import modelo.producto.Producto;
import modelo.usuario.Cliente;
import modelo.usuario.Usuario;
import modelo.pedidos.Carrito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JPanel removerCarrito;
    private JComboBox comboRemove;
    private JButton removerDelCarritoButton;


    public CarritoView(Usuario cliente){

        setContentPane(CarritoMain);


        setTitle("CarritoView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);


        DefaultTableModel modeloTabla = new DefaultTableModel();

        carritoT.setModel(modeloTabla);



        Carrito carrito = ControladorCarritoBD.getCarrito(ClienteViewController.getCliente());


        List<Item> items = carrito.getProductos();




        String[] titulos = {"Producto", "Cantidad", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);


        List<String> nombresProd = new ArrayList<>();

        for (Item i : items){

            nombresProd.add(i.getProducto().getNombre());
        }

        comboRemove.addItem("-Seleccionar-");

        for(String name : nombresProd){
            comboRemove.addItem(name);
        }




        for(Item i: items){
            Object[] fila = new Object[3];

            fila[0] = i.getProducto().getNombre();
            fila[1] = i.getCantidad();

            double precio = i.getProducto().getPrecio();

            double descuento = i.getProducto().getDescuento();

            double precioFinal = (precio-descuento);

            fila[2] = precioFinal;

            modeloTabla.addRow(fila);

        }

        double precioF = 0;

        for(Item i: items){
            double precio = ((i.getProducto().getPrecio())-(i.getProducto().getDescuento()));
            precioF = precioF + precio;
        }

        String pf = Double.toString(precioF);


        precioTotalF.setText(pf);



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

                ControladorCarritoBD.removeCarrito();

                for(int i = 1; i< modeloTabla.getRowCount(); i++){
                    Producto producto = ControladorProductosBD.getProductByName((String) modeloTabla.getValueAt(i, 0));
                    int cantidad = (int)modeloTabla.getValueAt(i, 1);

                    Item item = new Item(producto, cantidad);
                    ControladorCarritoBD.addToCarrito(ClienteViewController.getCliente(), item);
                }

            }
        });

        pedirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente1 = (Cliente) ClienteViewController.getCliente();
                Carrito carr = ControladorCarritoBD.getCarrito(cliente1);
                List<Item> prods = carr.getProductos();

                double precioF = 0;

                for(Item i: items){
                    double precio = ((i.getProducto().getPrecio())-(i.getProducto().getDescuento()));
                    precioF = precioF + precio;
                }

                double impuestos = precioF * 0.21;

                Pedido pedido = new Pedido(prods, cliente1, precioF, impuestos, cliente1.getDni());

                PagoVistaController.createView(pedido);
                CarritoViewController.carritoView.setVisible(false);
                PagoVistaController.pagoVista.setVisible(true);
            }
        });
        removerDelCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String strSelectedProduct = (String) comboRemove.getSelectedItem();

                ControladorCarritoBD.removeItemCarrito(strSelectedProduct);

            }
        });
    }



}



