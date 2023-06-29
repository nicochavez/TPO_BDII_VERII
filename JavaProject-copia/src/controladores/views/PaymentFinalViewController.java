package controladores.views;

import modelo.facturacion.Pago;
import views.PaymentFinalView;

public class PaymentFinalViewController {

    public static PaymentFinalView paymentFinalView;


    public static void createView(Pago pago){
        paymentFinalView = new PaymentFinalView(pago);
    }



}
