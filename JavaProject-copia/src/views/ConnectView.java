package views;

import controladores.views.ClienteViewController;
import controladores.views.ConnectViewController;
import controladores.views.LogInViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectView extends JFrame{
    private JButton connectButton;
    private JPanel ConnectMain;



    public ConnectView(){

        setContentPane(ConnectMain);

        setTitle("ConnectView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,250);
        setLocationRelativeTo(null);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(ConnectViewController.conectar()){
                    LogInViewController.createView();
                    ConnectViewController.connectView.setVisible(false);
                    LogInViewController.logView.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(ConnectView.this, "Error al conectar con la Base de Datos");
                }


            }
        });
    }



}
