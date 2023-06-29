package modelo.usuario;

import java.util.List;

import modelo.facturacion.Pago;
import modelo.usuario.categorías.CategoriaUsuario;

public class Cliente extends Usuario{
	
	private List<Pago> pagos;
	private CategoriaUsuario categoria;
	private Direccion direccion;


	public Cliente(String nombre, String apellido, int dni, int id, Direccion direccion, Credenciales credenciales) {
		super(nombre, apellido, dni, 0, credenciales);
		this.direccion = direccion;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public CategoriaUsuario getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaUsuario categoria) {
		this.categoria = categoria;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}
