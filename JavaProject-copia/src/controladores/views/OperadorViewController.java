package controladores.views;

import modelo.usuario.Operador;
import modelo.usuario.Usuario;
import views.OperadorView;

public class OperadorViewController {

    private static Usuario operador;

    public static OperadorView operadorView;


    public static Usuario getOperador() {
        return operador;
    }

    public static void setOperador(Usuario operador) {
        OperadorViewController.operador = operador;
    }

    public static void createView(){
        operadorView = new OperadorView();
    }







}
