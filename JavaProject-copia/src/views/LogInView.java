package views;

import controladores.views.*;
import modelo.usuario.Credenciales;
import modelo.usuario.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInView extends JFrame {


    private JPanel LogInMain;
    private JPanel Title;
    private JPanel LogIn;
    private JPanel Button;
    private JTextField UserF;
    private JPasswordField PasswordF;
    private JLabel UserL;
    private JButton SignUpB;
    private JButton LogInB;
    private JPanel PasswordP;
    private JPanel UserP;
    private JLabel TitleL;
    private JLabel PasswordL;
    private JButton disconnectButton;

    public LogInView(){

        setContentPane(LogInMain);

        setTitle("LogInView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,250);
        setLocationRelativeTo(null);





        SignUpB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpViewController.createView();
                LogInViewController.logView.setVisible(false);
                SignUpViewController.signUpView.setVisible(true);
            }
        });

        LogInB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Credenciales cred = new Credenciales(UserF.getText(), PasswordF.getText());

                Usuario usuario = LogInViewController.logIn(cred);

                if(usuario == null) {
                    JOptionPane.showMessageDialog(LogInView.this,"Credenciales incorrectas");
                } else if (usuario.getId()==0) {
                    ClienteViewController.setCliente(usuario);
                    ClienteViewController.startClientView();
                } else if (usuario.getId()==1) {
                    OperadorViewController.setOperador(usuario);
                    OperadorViewController.startOperadorView();
                }
            }
        });

        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(ConnectViewController.desconectar()){
                    LogInViewController.logView.setVisible(false);
                    ConnectViewController.connectView.setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(LogInView.this, "Error al desconectarse de las Base de Datos");
                }
            }
        });
    }


    public static void main(String[] args) {


        new LogInView();


    }












}
