package views;

import controladores.usuario.ControladorUsuarioBD;
import controladores.views.ClientDataViewController;
import controladores.views.ClientListViewController;
import controladores.views.ClienteViewController;
import controladores.views.OperadorViewController;
import modelo.producto.Producto;
import modelo.usuario.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientListView extends JFrame{
    private JPanel ClientListMain;
    private JLabel TitleL;
    private JPanel Title;
    private JScrollPane ClientList;
    private JPanel Button;
    private JButton volverButton;
    private JTextField DocF;
    private JButton verDatosClienteButton;
    private JTable tableClientes;




    public ClientListView(){


        setContentPane(ClientListMain);


        setTitle("ClientListView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);


        DefaultTableModel modeloTabla = new DefaultTableModel();


        tableClientes.setModel(modeloTabla);


        String[] titulos = {"Nombre", "Apellido", "DNI"};

        modeloTabla.setColumnIdentifiers(titulos);


        List<Cliente> clientes = ControladorUsuarioBD.getAllClients();


        for(Cliente cliente : clientes){
            Object[] fila = new Object[3];
            fila[0] = cliente.getName();
            fila[1] = cliente.getSurname();
            fila[2] = cliente.getDni();
            modeloTabla.addRow(fila);
        }


        verDatosClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDNI = DocF.getText();

                int DNI = Integer.parseInt(selectedDNI);
                Cliente cliente = ControladorUsuarioBD.getClientByDNI(DNI);

                ClientDataViewController.createView(cliente);
                ClientListViewController.clientListView.setVisible(false);
                ClientDataViewController.clientDataView.setVisible(true);
            }

        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientListViewController.clientListView.setVisible(false);
                OperadorViewController.operadorView.setVisible(true);
            }
        });
    }







}
