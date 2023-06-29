package modelo.usuario;

public class Operador extends Usuario{

    public Operador(String nombre, String apellido, int dni, int id, Credenciales credenciales) {
        super(nombre, apellido, dni, 1, credenciales);
    }

}
