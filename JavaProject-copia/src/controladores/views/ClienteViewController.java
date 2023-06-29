package controladores.views;

import modelo.usuario.Cliente;
import modelo.usuario.Usuario;
import views.ClienteView;

public class ClienteViewController {

    private static Usuario cliente;

    public static ClienteView clienteView = new ClienteView();


    public static Usuario getCliente() {
        return cliente;
    }

    public static void setCliente(Usuario cliente) {
        ClienteViewController.cliente = cliente;
    }



    public static void startClientView(){
        LogInViewController.logView.setVisible(false);
        clienteView.setVisible(true);
    }



}
