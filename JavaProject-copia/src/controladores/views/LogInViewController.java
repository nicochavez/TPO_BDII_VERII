package controladores.views;

import controladores.usuario.ControladorUsuario;
import controladores.usuario.ControladorUsuarioBD;
import modelo.usuario.Cliente;
import modelo.usuario.Credenciales;
import modelo.usuario.Usuario;
import views.ClienteView;
import views.LogInView;
import views.OperadorView;
import views.SignUpView;

import javax.swing.*;

public class LogInViewController {

    public static LogInView logView;




    public static void createView(){
        logView = new LogInView();
    }

    public static Usuario logIn(Credenciales credenciales){
        Usuario usuario = ControladorUsuarioBD.logIn(credenciales);

        return usuario;
    }







}
