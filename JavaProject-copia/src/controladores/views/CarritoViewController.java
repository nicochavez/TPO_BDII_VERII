package controladores.views;

import modelo.pedidos.Carrito;
import modelo.pedidos.Item;
import modelo.producto.Producto;
import modelo.usuario.Usuario;
import views.CarritoView;

import java.util.ArrayList;
import java.util.List;

public class CarritoViewController {

    public static CarritoView carritoView;




    public static void createView(Usuario cliente){
        carritoView = new CarritoView(cliente);
    }



    public static Carrito getCarrito(){

        Carrito carrito = null;




        return carrito;
    }



}
