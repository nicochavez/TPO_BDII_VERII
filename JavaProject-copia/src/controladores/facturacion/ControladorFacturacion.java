package controladores.facturacion;

import controladores.views.ClienteViewController;
import modelo.facturacion.Factura;

import modelo.pedidos.Pedido;

import java.time.LocalDateTime;
import java.util.Random;

public class ControladorFacturacion {

    private static final Random rand = new Random();


    public static Factura facturar(Pedido pedido){

        double importe = pedido.getImporte() + pedido.getImpuestos();

        int nroFactura = (rand.nextInt() * rand.nextInt()) + pedido.getId();

        String userID = Integer.toString(pedido.getId());

    return new Factura(pedido, nroFactura, LocalDateTime.now(), importe, userID);
    }




}
