package modelo.usuario;

public class Usuario {

	private String name;
	private String surname;
	private int dni;
	private int id;
	private Credenciales credenciales;


	public Usuario(String name, String surname, int dni, int id, Credenciales credenciales) {
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.id = id;
		this.credenciales = credenciales;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public int getDni() {
		return this.dni;
	}

	public Credenciales getCredentials() {
		return this.credenciales;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setCredenciales(Credenciales credenciales) {
		this.credenciales = credenciales;
	}

	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}
}
