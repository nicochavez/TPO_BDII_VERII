package views;

import controladores.views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperadorView extends JFrame{
    private JPanel OperadorMain;
    private JPanel Title;
    private JPanel Options;
    private JPanel Back;
    private JLabel TitleL;
    private JButton listarClientesButton;
    private JButton listarProductosButton;
    private JButton ventaButton;
    private JButton logOutButton;


    public OperadorView(){


        setContentPane(OperadorMain);

        setTitle("OperadaroView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,250);
        setLocationRelativeTo(null);


        listarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientListViewController.createView();
                OperadorViewController.operadorView.setVisible(false);
                ClientListViewController.clientListView.setVisible(true);
            }
        });
        listarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductListViewOController.createView();
                OperadorViewController.operadorView.setVisible(false);
                ProductListViewOController.productListViewO.setVisible(true);
            }
        });
        ventaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentaViewController.createView();
                OperadorViewController.operadorView.setVisible(false);
                VentaViewController.ventaView.setVisible(true);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperadorViewController.operadorView.setVisible(false);
                LogInViewController.logView.setVisible(true);
            }
        });
    }







}
