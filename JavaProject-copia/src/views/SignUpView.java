package views;

import controladores.usuario.ControladorUsuario;
import controladores.usuario.ControladorUsuarioBD;
import controladores.views.LogInViewController;
import controladores.views.SignUpViewController;
import modelo.usuario.Cliente;
import modelo.usuario.Credenciales;
import modelo.usuario.Direccion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame{
    private JPanel SignInMain;
    private JPanel Title;
    private JPanel Values;
    private JPanel Button;
    private JButton registrarButton;
    private JButton volverButton;
    private JPanel Name;
    private JPanel Surname;
    private JPanel Document;
    private JPanel UserName;
    private JPanel Password;
    private JPanel PassConfirm;
    private JLabel NameL;
    private JTextField NameF;
    private JLabel SurNameL;
    private JTextField SurNameF;
    private JTextField DocumentF;
    private JLabel DocumentL;
    private JTextField UserNameF;
    private JPasswordField CPasswordF;
    private JPasswordField PasswordF;
    private JLabel UserNameL;
    private JLabel PasswordL;
    private JLabel CPasswordL;
    private JLabel TitleL;
    private JPanel Dirección;
    private JTextField CalleF;
    private JTextField NumF;
    private JTextField CodPostalF;
    private JLabel CalleL;
    private JLabel NumL;
    private JLabel CodPostalL;


    public SignUpView(){

        setContentPane(SignInMain);


        setTitle("SignUpView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,250);
        setLocationRelativeTo(null);









        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInViewController.createView();
                SignUpViewController.signUpView.setVisible(false);
                LogInViewController.logView.setVisible(true);
            }
        });
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(PasswordF == CPasswordF){

                    Credenciales creds = new Credenciales(UserNameF.getText(), PasswordF.getText());
                    Direccion direc = new Direccion(CalleF.getText(), Integer.parseInt(NumF.getText()), Integer.parseInt(CodPostalF.getText()));

                    Cliente cliente = new Cliente(NameF.getText(), SurNameF.getText(), Integer.parseInt(DocumentF.getText()), 0, direc, creds);

                    ControladorUsuarioBD.signUp(cliente);

                    LogInViewController.createView();
                    SignUpViewController.signUpView.setVisible(false);
                    LogInViewController.logView.setVisible(true);

                } else{
                    JOptionPane.showMessageDialog(SignUpView.this, "Las contraseñas no son iguales.");
                }
            }
        });
    }


    public static void main(String[] args) {

        new SignUpView();





    }



}
