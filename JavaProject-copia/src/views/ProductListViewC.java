package views;

import controladores.producto.ControladorProductos;
import controladores.views.ClienteViewController;
import controladores.views.ProductListViewCController;
import controladores.views.ProductViewCController;
import modelo.producto.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductListViewC extends JFrame {


    private JPanel ProductListMain;
    private JPanel Title;
    private JPanel ProductSelector;
    private JPanel Button;
    private JLabel TitleL;
    private JTable productTable;
    private JTextField cantidadTextField;
    private JButton agregarAlCarritoButton;
    private JButton volverButton;
    private JButton miCarritoButton;
    private JComboBox comboProduct;
    private JButton verDatosProductoButton;
    private JScrollPane ProductPanel;


    public ProductListViewC(){

        setContentPane(ProductListMain);


        setTitle("ProductListClient");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);




        DefaultTableModel modeloTabla = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        productTable.setModel(modeloTabla);

        List<Producto> productos = ControladorProductos.getProductos();


        List<String> productNames = ProductListViewCController.getProductNames(productos);



        String[] titulos = {"Producto", "Descripcion", "Precio", "Descuento"};


        modeloTabla.setColumnIdentifiers(titulos);


        for(Producto producto : productos){

            Object[] fila = new Object[3];
            fila[0] = producto.getNombre();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getDescuento();

            modeloTabla.addRow(fila);
        }

        comboProduct.addItem("-Seleccionar-");

        for(String name : productNames){
            comboProduct.addItem(name);
        }





        verDatosProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String strSelectedProduct = (String) comboProduct.getSelectedItem();
                Producto selectedProduct = null;

                for(Producto product : productos){
                    if(product.getNombre()== strSelectedProduct){
                        selectedProduct = product;
                    }
                }
                ProductViewCController.createView(selectedProduct);
                ProductListViewCController.productListView.setVisible(false);
                ProductViewCController.productViewC.setVisible(true);
            }
        });


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductListViewCController.productListView.setVisible(false);
                ClienteViewController.clienteView.setVisible(true);
            }
        });
    }






    public static void main(String[] args) {

        new ProductListViewC();


    }


}
