package views;

import controladores.views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteView extends JFrame {


    private JPanel ClienteMain;
    private JPanel Title;
    private JPanel Options;
    private JPanel Back;
    private JLabel TitleL;
    private JButton ProductList;
    private JButton Carrito;
    private JButton Payments;
    private JButton logOutButton;

   public ClienteView(){


        setContentPane(ClienteMain);

        setTitle("ClienteView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,250);
        setLocationRelativeTo(null);


       ProductList.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               ProductListViewCController.createView();
               ClienteViewController.clienteView.setVisible(false);
               ProductListViewCController.productListView.setVisible(true);
           }
       });


       Carrito.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               CarritoViewController.createView(ClienteViewController.getCliente());
               ClienteViewController.clienteView.setVisible(false);
               CarritoViewController.carritoView.setVisible(true);
           }
       });


       Payments.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               PagosViewController.createView(ClienteViewController.getCliente());
               ClienteViewController.clienteView.setVisible(false);
               PagosViewController.pagosView.setVisible(true);
           }
       });


       logOutButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               ClienteViewController.clienteView.setVisible(false);
               LogInViewController.logView.setVisible(true);
           }
       });
   }

    public static void main(String[] args) {

        new ClienteView();



    }









}
