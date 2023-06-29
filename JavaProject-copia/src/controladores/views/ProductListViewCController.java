package controladores.views;

import modelo.producto.Producto;
import views.ProductListViewC;

import java.util.ArrayList;
import java.util.List;

public class ProductListViewCController {


    public static ProductListViewC productListView;

    public static void createView(){
        productListView = new ProductListViewC();
    }







    public static List<String> getProductNames(List<Producto> productos){
        List<String> nombres = new ArrayList<String>();

        for(Producto p : productos){
            nombres.add(p.getNombre());
        }

        return nombres;
    }



}
