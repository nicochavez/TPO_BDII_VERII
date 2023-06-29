package controladores.facturacion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import controladores.producto.ControladorProductosBD;
import controladores.usuario.ControladorUsuarioBD;
import modelo.facturacion.Factura;
import modelo.pedidos.Item;
import modelo.pedidos.Pedido;
import modelo.producto.Producto;
import modelo.usuario.Cliente;
import modelo.usuario.Credenciales;
import modelo.usuario.Direccion;
import modelo.usuario.Usuario;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ControladorFacturaBD {


    public static void subirFactura(Factura factura){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> facturasCollection = dataBase.getCollection("Facturas");
            System.out.println("Se agarró la colec");
            facturasCollection.insertOne((Document) generateDocument(factura));
            System.out.println("Se incertó el usuario");

        } catch (Exception e){
            System.out.println("We can't add this receipt to database");
        }

    }

    private static Document generateDocument(Factura factura){

        int nroFactura = factura.getNumeroFactura();
        LocalDateTime fecha = factura.getFecha();
        String fechaS = fecha.toString();
        double importe = factura.getImporte();
        String userID = factura.getUser_id();

        List<Item> prods = factura.getPedido().getProductos();

        List<Document> pedido = new ArrayList<>();

        for (Item i : prods){
            String nombre = i.getProducto().getNombre();
            int cantidad = i.getCantidad();
            Document doc = new Document("producto", nombre).append("cantidad", cantidad);
            pedido.add(doc);
        }



        return new Document("_id", new ObjectId()).append("nroFactura", nroFactura)
                .append("fecha", fechaS)
                .append("importe", importe)
                .append("user_id", userID)
                .append("pedido", pedido);
    }

    public static Factura getFacturaByNro(int nro){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> facturasCollection = dataBase.getCollection("Facturas");
            System.out.println("Se agarró la colec");

            Document fact = facturasCollection.find(new Document("nroFactura", nro)).first();

            Factura factura = docToFactura(fact);

            return factura;
        } catch (Exception e){
            System.out.println("Error al acceder a las facturas");
            return null;
        }
    }

    public static Factura docToFactura(Document factura){

        int nroFactura = factura.getInteger("nroFactura");
        String fecha = factura.getString("fecha");
        double importe = factura.getDouble("importe");
        String user_id = factura.getString("user_id");

        return new Factura(nroFactura, fecha, importe, user_id);
    }


    public static void main(String[] args) {

/*
        List<Producto> productos = ControladorProductosBD.getAllProducts();

        Credenciales creds = new Credenciales("kra495", "ramiro1234");

        Cliente cliente = (Cliente) ControladorUsuarioBD.logIn(creds);

        Producto producto = productos.get(0);

        Item item = new Item(producto, 1);

        List<Item> items = new ArrayList<>();
        items.add(item);

        Pedido pedido = new Pedido(items, cliente, 1000, 210, cliente.getDni());

        Factura factura = ControladorFacturacion.facturar(pedido);

        subirFactura(factura);

        */


        Factura factura = getFacturaByNro(1556042700);

        System.out.println(factura.getImporte());



    }


}
