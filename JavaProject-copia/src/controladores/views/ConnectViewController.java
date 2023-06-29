package controladores.views;

import views.ConnectView;

public class ConnectViewController {

    public static ConnectView connectView = new ConnectView();



    public static void startProgram(){

        connectView.setVisible(true);


    }


    public static boolean conectar(){
        //Se conecta a las BD
         boolean status = true;
        return status;
    }


    public static boolean desconectar(){
        //Se desconecta de las BD

        boolean status = true;



        return  status;
    }














}
