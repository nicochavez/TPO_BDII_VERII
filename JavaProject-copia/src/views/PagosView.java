package views;

import controladores.facturacion.ControladorPagosBD;
import controladores.views.ClienteViewController;
import controladores.views.PagosViewController;
import modelo.facturacion.Pago;
import modelo.usuario.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PagosView extends JFrame {
    private JPanel PagosMain;
    private JPanel Title;
    private JScrollPane Pagos;
    private JPanel Button;
    private JLabel TitleL;
    private JTable PagosT;
    private JButton volverButton;


    public PagosView(Usuario cliente){

        setContentPane(PagosMain);


        setTitle("PagosView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);

        DefaultTableModel modeloTabla = new DefaultTableModel();

        PagosT.setModel(modeloTabla);

        List<Pago> pagos = ControladorPagosBD.getPagosByDNI(ClienteViewController.getCliente().getDni());



        String[] titulos = {"nroFactura", "Fecha", "MedioDePago", "Importe"};

        modeloTabla.setColumnIdentifiers(titulos);

        for (Pago pago : pagos){
            Object[] fila = new Object[4];
            fila[0] = pago.getNroFactura();
            fila[1] = pago.getFechaS();
            fila[2] = pago.getMedioPagoS();
            fila[3] = pago.getImporte();
            modeloTabla.addRow(fila);
        }




        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PagosViewController.pagosView.setVisible(false);
                ClienteViewController.clienteView.setVisible(true);
            }
        });


    }


}
