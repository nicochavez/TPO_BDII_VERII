package controladores.views;

import modelo.pedidos.Pedido;
import views.PagoVista;

public class PagoVistaController {


    public static PagoVista pagoVista;



    public static void createView(Pedido pedido){
        pagoVista = new PagoVista(pedido);
    }


}
