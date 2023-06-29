package controladores.views;

import modelo.usuario.Cliente;
import views.ClientDataView;

public class ClientDataViewController {

    public static ClientDataView clientDataView;


    public static void createView(Cliente cliente){
        clientDataView = new ClientDataView(cliente);
    }








}
