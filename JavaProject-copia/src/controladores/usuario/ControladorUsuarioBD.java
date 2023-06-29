package controladores.usuario;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import controladores.Connect;
import modelo.producto.Producto;
import modelo.usuario.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;


public class ControladorUsuarioBD {


    public static void signUp(Cliente usuario){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> usersCollection = dataBase.getCollection("Usuarios");
            System.out.println("Se agarró la colec");
            usersCollection.insertOne((Document) generateDocument(usuario));
            System.out.println("Se incertó el usuario");

        } catch (Exception e){
            System.out.println("We can't add this user to database");
        }

    }

    private static Document generateDocument(Cliente usuario){

        String nombre = usuario.getName();
        String apellido = usuario.getSurname();
        int dni = usuario.getDni();
        int id = usuario.getId();
        Credenciales credenciales = usuario.getCredentials();
        Direccion direccion = usuario.getDireccion();
        String userName = credenciales.getUsername();
        String pass = credenciales.getPassword();
        String calle = direccion.getCalle();
        int num = direccion.getNumero();
        int codP = direccion.getCodPostal();

        Document creds = new Document("userName", userName).append("password", pass);
        Document direc = new Document("calle", calle).append("numero", num)
                .append("CodPostal", codP);

       return new Document("_id", new ObjectId()).append("nombre", nombre)
               .append("apellido", apellido)
               .append("dni", dni)
               .append("id", id)
               .append("credenciales", creds)
               .append("direccion", direc);
    }

    public static Usuario logIn(Credenciales creds){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            MongoCollection<Document> usersCollection = dataBase.getCollection("Usuarios");
            Document cred = new Document("userName", creds.getUsername()).append("password", creds.getPassword());
            Document userFound = usersCollection.find(new Document("credenciales",cred)).first();

            Usuario user = null;

            if(!(userFound==null)) {
                int id = userFound.getInteger("id");
                if(id == 0) {
                    System.out.println("usuario encontrado");
                    user = docToClient(userFound);
                } else if (id == 1){
                    System.out.println("operador encontrado");
                    user = docToOperator(userFound);
                }
            }

            return user;
        } catch (Exception e){
            System.out.println("Error en el login");
            return null;
        }

    }

    private static Cliente docToClient(Document user){
        Document credencialesDoc = (Document) user.get("credenciales");
        Credenciales credenciales = new Credenciales(credencialesDoc.getString("userName"),
                credencialesDoc.getString("password"));

        Document direccionDoc = (Document) user.get("direccion");

        Direccion direccion = new Direccion(direccionDoc.getString("calle"), direccionDoc.getInteger("numero"),
                direccionDoc.getInteger("CodPostal"));

        Cliente cliente = new Cliente(user.getString("nombre"),
                user.getString("apellido"),
                user.getInteger("dni"),
                user.getInteger("id"),
                direccion,
                credenciales);
        return cliente;
    }

    private static Operador docToOperator(Document user){
        Document credencialesDoc = (Document) user.get("credenciales");
        Credenciales credenciales = new Credenciales(credencialesDoc.getString("userName"),
                credencialesDoc.getString("password"));

        Operador operador = new Operador(user.getString("nombre"),
                user.getString("apellido"),
                user.getInteger("dni"),
                user.getInteger("id"),
                credenciales);
        return operador;
    }


    public static List<Cliente> getAllClients(){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> userCollection = dataBase.getCollection("Usuarios");
            System.out.println("Se agarró la colec");


            List<Document> clientList = userCollection.find(new Document("id", 0)).into(new ArrayList<>());
            List<Cliente> listCliente = new ArrayList<>();
            for (Document prod : clientList){
                listCliente.add(docToClient(prod));
            }
            return listCliente;
        } catch (Exception e){
            System.out.println("Error al acceder a los productos");
            return null;
        }

    }


    public static Cliente getClientByDNI(int DNI){
        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> userCollection = dataBase.getCollection("Usuarios");
            System.out.println("Se agarró la colec");


            Document userFound = userCollection.find(new Document("dni",DNI)).first();

            Cliente cliente = docToClient(userFound);

            return cliente;
        } catch (Exception e){
            System.out.println("Error al acceder a los productos");
            return null;
        }


    }


    public static void main(String[] args) {

        int id = 1;
        String nombre = "Marcos";
        String apellido = "Hernandez";
        int dni = 22111333;

        Credenciales creds = new Credenciales("ma123", "ma1234");
        Direccion direc = new Direccion("Independencia", 1214, 124);



        Usuario usuario = new Operador(nombre,apellido, dni, id, creds);

        System.out.println(usuario.getName());

        Document cred = new Document("userName", "ma123").append("password", "ma1234");


        Document operador = new Document("_id", new ObjectId()).append("nombre", nombre)
                .append("apellido", apellido)
                .append("dni", dni)
                .append("id", id)
                .append("credenciales", cred);



        try (MongoClient session = MongoClients.create("mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/?retryWrites=true&w=majority")){
            MongoDatabase dataBase = session.getDatabase("TPOBD2");
            System.out.println("Se entro a la BD");
            MongoCollection<Document> usersCollection = dataBase.getCollection("Usuarios");
            System.out.println("Se agarró la colec");
            usersCollection.insertOne(operador);
            System.out.println("Se incertó el usuario");

        }





        //logIn(creds);






        }

}


