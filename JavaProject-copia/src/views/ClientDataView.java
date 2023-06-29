package views;

import controladores.views.ClientDataViewController;
import controladores.views.ClientListViewController;
import controladores.views.OperadorViewController;
import modelo.usuario.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientDataView extends JFrame{
    private JPanel ClientDataMain;
    private JPanel Title;
    private JPanel UserName;
    private JPanel NameSurName;
    private JPanel Doc;
    private JPanel Direc;
    private JPanel Categ;
    private JPanel Button;
    private JLabel TitleL;
    private JTextField userNameF;
    private JLabel userNameLabel;
    private JTextField NombreF;
    private JTextField DocF;
    private JTextField CalleF;
    private JTextField CategF;
    private JButton volverButton;
    private JButton verPagosButton;
    private JTextField ApellidoF;
    private JLabel NombreL;
    private JLabel ApellidoL;
    private JLabel DocL;
    private JTextField NumF;
    private JTextField CodPostalF;
    private JLabel CalleL;
    private JLabel NumL;
    private JLabel CodPostalL;
    private JLabel CategL;


    public ClientDataView(Cliente cliente){

        setContentPane(ClientDataMain);


        setTitle("ClientDataView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);



        userNameF.setText(cliente.getCredentials().getUsername());
        CodPostalF.setText(Integer.toString(cliente.getDireccion().getCodPostal()));
        NumF.setText(Integer.toString(cliente.getDireccion().getNumero()));
        CalleF.setText(cliente.getDireccion().getCalle());
        ApellidoF.setText(cliente.getSurname());
        NombreF.setText(cliente.getName());
        DocF.setText(Integer.toString(cliente.getDni()));


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientDataViewController.clientDataView.setVisible(false);
                ClientListViewController.clientListView.setVisible(true);
            }
        });
    }







}
