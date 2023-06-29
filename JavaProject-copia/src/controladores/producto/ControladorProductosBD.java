package controladores.producto;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modelo.producto.Producto;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class ControladorProductosBD {



    public static List<Producto> getAllProducts(){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> productCollection = dataBase.getCollection("Productos");
            System.out.println("Se agarró la colec");


            List<Document> productList = productCollection.find().into(new ArrayList<>());
            List<Producto> listProducto = new ArrayList<>();
            for (Document prod : productList){
                listProducto.add(docToProduct(prod));
            }
            return listProducto;
        } catch (Exception e){
            System.out.println("Error al acceder a los productos");
            return null;
        }

    }


    public static Producto docToProduct(Document doc){

        double product_id = doc.getDouble("product_id");
        String nombre = doc.getString("nombre");
        String descripcion = doc.getString("descripcion");
        double precio = doc.getDouble("precio");
        double descuento = doc.getDouble("descuento");

        return new Producto(nombre, descripcion, precio, product_id, descuento);
    }


    public static Producto getProductByName(String name){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> productCollection = dataBase.getCollection("Productos");
            System.out.println("Se agarró la colec");

            Document prod = productCollection.find(new Document("nombre", name)).first();

            Producto producto = docToProduct(prod);

        return producto;
        } catch (Exception e){
            System.out.println("Error al acceder a los productos");
            return null;
        }

    }

    public static void main(String[] args) {

        /*
        double product_id = 1;
        String nombre = "RTX 2080";
        String descripcion = "Una placa gráfica de gama alta";
        double precio = 850;
        double descuento = 120;

        Document producto = new Document("_id", new ObjectId()).append("product_id", product_id)
                .append("nombre", nombre)
                .append("descripcion", descripcion)
                .append("precio", precio)
                .append("descuento", descuento);



        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")) {

            MongoDatabase prueba = mongoClient.getDatabase("TPOBD2");
            MongoCollection<Document> productosCollection = prueba.getCollection("Productos");

            productosCollection.insertOne(producto);


            //Document product1 = productosCollection.find(new Document("product_id",2)).first();
            //System.out.println("Producto 1: " + product1.get("descripcion"));


        } */

        List<Producto> allProducts= getAllProducts();

        for (Producto p : allProducts){
            System.out.println(p.getNombre());
        }



    }


}
