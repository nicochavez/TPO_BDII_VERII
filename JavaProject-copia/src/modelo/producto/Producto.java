package modelo.producto;

import java.awt.*;

public class Producto {
	
	private String nombre;
	private String descripcion;
	private double precio;
	private double id;
	private double descuento;
	private Image imagen;

	public Producto(String nombre, String descripcion, double precio, double id, double descuento) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.id = id;
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
}
