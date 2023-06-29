package views;

import modelo.usuario.Usuario;

import javax.swing.*;

public class PagosView extends JFrame {
    private JPanel PagosMain;
    private JPanel Title;
    private JScrollPane Pagos;
    private JPanel Button;
    private JLabel TitleL;
    private JTable PagosT;
    private JButton volverButton;








    public PagosView(Usuario cliente){

        setContentPane(PagosMain);


        setTitle("PagosView");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);



    }


}
