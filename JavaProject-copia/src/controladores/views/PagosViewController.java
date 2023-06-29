package controladores.views;

import modelo.usuario.Usuario;
import views.PagosView;

public class PagosViewController {

    public static PagosView pagosView;




    public static void createView(Usuario cliente){
        pagosView = new PagosView(cliente);
    }


}
