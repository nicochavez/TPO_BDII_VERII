package views;

import controladores.views.ClienteViewController;
import controladores.views.PaymentFinalViewController;
import modelo.facturacion.Pago;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentFinalView extends JFrame{
    private JPanel PaymentFinalMain;
    private JPanel Title;
    private JPanel Values;
    private JPanel Button;
    private JLabel TitleL;
    private JButton finalizarButton;
    private JTextField importeF;
    private JTextField pagoF;
    private JTextField facturaF;
    private JPanel ImporteFinal;
    private JPanel MedioDePago;
    private JPanel NroFactura;
    private JLabel importeL;
    private JLabel pagoL;
    private JLabel facturaL;

    public PaymentFinalView(Pago pago) {



        setContentPane(PaymentFinalMain);



        setTitle("PaymentFinalView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);



        int nroFactura = pago.getFactura().getNumeroFactura();
        double importe = pago.getImporte();
        String metodo = pago.getMedioPago().name();


        importeF.setText(Double.toString(importe));
        facturaF.setText(Integer.toString(nroFactura));
        pagoF.setText(metodo);






        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PaymentFinalViewController.paymentFinalView.setVisible(false);
                ClienteViewController.clienteView.setVisible(true);

            }
        });
    }


}
