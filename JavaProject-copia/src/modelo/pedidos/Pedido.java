package modelo.pedidos;

import java.util.List;

import modelo.usuario.Cliente;
import modelo.usuario.Usuario;

public class Pedido {
	
	private List <Item> productos;
	private Cliente Cliente;
	private double importe;
	private double impuestos;
	private int id;

	public Pedido(List<Item> productos, modelo.usuario.Cliente cliente, double importe, double impuestos, int id) {
		this.productos = productos;
		Cliente = cliente;
		this.importe = importe;
		this.impuestos = impuestos;
		this.id = id;
	}

	public List<Item> getProductos() {
		return productos;
	}

	public void setProductos(List<Item> productos) {
		this.productos = productos;
	}

	public modelo.usuario.Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(modelo.usuario.Cliente cliente) {
		Cliente = cliente;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
