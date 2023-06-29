package controladores.facturacion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modelo.facturacion.Factura;
import modelo.facturacion.MedioPago;
import modelo.facturacion.Pago;
import modelo.pedidos.Item;
import modelo.producto.Producto;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControladorPagosBD {


    public static void subirPago(Pago pago){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> pagosCollection = dataBase.getCollection("Pagos");
            System.out.println("Se agarró la colec");
            pagosCollection.insertOne((Document) generateDocument(pago));
            System.out.println("Se incertó el usuario");

        } catch (Exception e){
            System.out.println("We can't add this payment to database");
        }

    }

    private static Document generateDocument(Pago pago){


        int nroFactura = pago.getFactura().getNumeroFactura();
        String fecha = pago.getFactura().getFechaS();
        double importe = pago.getFactura().getImporte();
        int userID = pago.getId();
        String medio = pago.getMedioPago().name();




        return new Document("_id", new ObjectId()).append("nroFactura", nroFactura)
                .append("fecha", fecha)
                .append("importe", importe)
                .append("medioDePago", medio)
                .append("user_id", userID);
    }

    public static Pago getPagoByNroFactura(int nro){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> pagosCollection = dataBase.getCollection("Pagos");
            System.out.println("Se agarró la colec");

            Document pagoDoc = pagosCollection.find(new Document("nroFactura", nro)).first();
            System.out.println("Se encontró");


            Pago pago = docToPago(pagoDoc);

            return pago;
        } catch (Exception e){
            System.out.println("Error al acceder a las facturas");
            return null;
        }
    }

    public static Pago docToPago(Document pagoDoc){

        int nroFactura = pagoDoc.getInteger("nroFactura");
        System.out.println(nroFactura);
        String fecha = pagoDoc.getString("fecha");
        System.out.println(fecha);
        double importe = pagoDoc.getDouble("importe");
        System.out.println(importe);
        String medio = pagoDoc.getString("medioDePago");
        System.out.println(medio);
        int id = pagoDoc.getInteger("user_id");
        System.out.println("Hasta acá");


        return new Pago(nroFactura, fecha, importe, medio, id);
    }

    public static List<Pago> getPagosByDNI(int DNI){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> pagosCollection = dataBase.getCollection("Pagos");
            System.out.println("Se agarró la colec");

            List<Document> pagosList = pagosCollection.find(new Document("user_id", DNI)).into(new ArrayList<>());
            List<Pago> listPago = new ArrayList<>();
            for (Document pago : pagosList){
                listPago.add(docToPago(pago));
            }
            return listPago;
        } catch (Exception e){
            System.out.println("Error al acceder a los productos");
            return null;
        }

    }


    public static void main(String[] args) {

        /*
        Factura factura = ControladorFacturaBD.getFacturaByNro(1556042700);

        Pago pago = new Pago(factura);
        pago.setMedioPago(MedioPago.CREDITO);

        subirPago(pago);

        */

        Pago pago = getPagoByNroFactura(1556042700);

        System.out.println(pago.getImporte());


    }



}
