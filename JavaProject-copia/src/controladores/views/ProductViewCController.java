package controladores.views;

import modelo.producto.Producto;
import views.ProductViewC;

public class ProductViewCController {

    public static ProductViewC productViewC;



    public static void createView(Producto producto){
        productViewC = new ProductViewC(producto);
    }


}
