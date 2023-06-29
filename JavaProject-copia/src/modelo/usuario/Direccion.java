package modelo.usuario;

public class Direccion {
	
	private String calle;
	private int numero;
	private int codPostal;

	public Direccion(String calle, int numero, int codPostal) {
		this.calle = calle;
		this.numero = numero;
		this.codPostal = codPostal;
	}


	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
}
