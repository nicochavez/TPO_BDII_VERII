package controladores.usuario;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import controladores.Connect;
import modelo.usuario.Cliente;
import modelo.usuario.Credenciales;
import modelo.usuario.Direccion;
import modelo.usuario.Usuario;
import org.bson.Document;
import org.bson.types.ObjectId;


public class ControladorUsuarioBD {


    public ControladorUsuarioBD(){

    }

    public static void signUp(Cliente usuario){
        Connect connection = new Connect();
        MongoClient session = connection.startMongo();
        try {
            MongoDatabase sampleTrainingDB = session.getDatabase("Test");
            MongoCollection<Document> usersCollection = sampleTrainingDB.getCollection("users");
            usersCollection.insertOne(generateDocument(usuario));

        } catch (Exception e){
            System.out.println("We can't add this user to database");
        }

    }

    private static Document generateDocument(Cliente usuario){
        Document creds = new Document("userName", usuario.getCredentials().getUsername()).append("password", usuario.getCredentials().getPassword());
        Document direc = new Document("calle", usuario.getDireccion().getCalle()).append("numero", usuario.getDireccion().getNumero()).append("CodPostal", usuario.getDireccion().getCodPostal());
        Document document =  new Document("_id", new ObjectId());
        document.append("name", usuario.getName());
        document.append("surname", usuario.getSurname());
        document.append("dni", usuario.getDni());
        document.append("id", usuario.getId());
        document.append("credenciales", creds);
        document.append("dirección", direc);
        return document;
    }

    public static Usuario logIn(Credenciales creds){
        Connect connection = new Connect();
        MongoClient session = connection.startMongo();
        try {
            MongoDatabase sampleTrainingDB = session.getDatabase("Test");
            MongoCollection<Document> usersCollection = sampleTrainingDB.getCollection("users");
            Document cred = new Document("userName", creds.getUsername()).append("password", creds.getPassword());
            Document userFound = usersCollection.find(new Document("credenciales",cred)).first();


            Usuario user = docToUser(userFound);

            return user;
        } catch (Exception e){
            System.out.println("Error en el login");
            return null;
        }

    }

    private static Cliente docToUser(Document user){
        Document credencialesDoc = (Document) user.get("credenciales");
        Credenciales credenciales = new Credenciales(credencialesDoc.getString("userName"),
                credencialesDoc.getString("password"));

        Document direccionDoc = (Document) user.get("direccion");
        Direccion direccion = new Direccion(direccionDoc.getString("calle"), direccionDoc.getInteger("numero"),
                direccionDoc.getInteger("codPostal"));

        Cliente cliente = new Cliente(user.getString("name"),
                user.getString("surname"),
                user.getInteger("dni"),
                user.getInteger("id"),
                direccion,



                credenciales);
        return cliente;



    }


    /*Document cred = new Document("userName", "krato495").append("password", "pepito1234");


    Document user1 = usuarios.find(new Document("credenciales",cred)).first();

    System.out.println("El usuario que corresponde a esas credenciales es: " + user1.get("nombre"));*/
























}
