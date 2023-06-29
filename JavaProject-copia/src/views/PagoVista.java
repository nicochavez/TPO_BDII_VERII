package views;

import controladores.facturacion.ControladorFacturaBD;
import controladores.facturacion.ControladorFacturacion;
import controladores.facturacion.ControladorPagosBD;
import controladores.views.ClienteViewController;
import controladores.views.PagoVistaController;
import controladores.views.PaymentFinalViewController;
import modelo.facturacion.Factura;
import modelo.facturacion.MedioPago;
import modelo.facturacion.Pago;
import modelo.pedidos.Pedido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagoVista extends JFrame{
    private JPanel PagoMain;
    private JPanel Title;
    private JPanel Valores;
    private JPanel Button;
    private JLabel TitleL;
    private JButton volverButton;
    private JButton pagarButton;
    private JTextField ImporteF;
    private JTextField ImpuestosF;
    private JPanel Importe;
    private JPanel Impuestos;
    private JPanel medioPago;
    private JComboBox comboMedioPago;
    private JLabel ImporteL;
    private JLabel ImpuestosL;
    private JLabel medioPagoL;



    public PagoVista(Pedido pedido){

        setContentPane(PagoMain);


        setTitle("PagosView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);



        ImporteF.setText(Double.toString(pedido.getImporte()));
        ImpuestosF.setText(Double.toString(pedido.getImpuestos()));


        comboMedioPago.addItem("-Seleccionar-");
        comboMedioPago.addItem("-Efectivo-");
        comboMedioPago.addItem("-Debito-");
        comboMedioPago.addItem("-Credito-");

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PagoVistaController.pagoVista.setVisible(false);
                ClienteViewController.clienteView.setVisible(true);
            }
        });

        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Factura factura = ControladorFacturacion.facturar(pedido);
                ControladorFacturaBD.subirFactura(factura);

                Pago pago = new Pago(factura);


                int index = comboMedioPago.getSelectedIndex();


                if(index == 1){
                    pago.setMedioPago(MedioPago.EFECTIVO);
                } else if (index == 2) {
                    pago.setMedioPago(MedioPago.DEBITO);
                } else if (index == 2) {
                    pago.setMedioPago(MedioPago.CREDITO);
                }
                ControladorPagosBD.subirPago(pago);
                PaymentFinalViewController.createView(pago);
                PagoVistaController.pagoVista.setVisible(false);
                PaymentFinalViewController.paymentFinalView.setVisible(true);
            }
        });
    }



}
