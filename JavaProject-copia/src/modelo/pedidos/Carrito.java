package modelo.pedidos;

import java.util.List;

import modelo.usuario.Usuario;

public class Carrito {
	
	private List <Item> productos;
	private int version;
	private Usuario usuario;


	public Carrito(List<Item> productos, int version, Usuario usuario) {
		this.productos = productos;
		this.version = version;
		this.usuario = usuario;
	}


	public List<Item> getProductos() {
		return productos;
	}

	public void setProductos(List<Item> productos) {
		this.productos = productos;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
