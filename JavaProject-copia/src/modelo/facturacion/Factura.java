package modelo.facturacion;

import modelo.pedidos.Pedido;

import java.time.LocalDateTime;


public class Factura {

	private Pedido pedido;
	private static int numero;
	private int numeroFactura;
	private LocalDateTime fecha;
	private String fechaS;
	private double importe;
	private String condicionIVA;
	private String user_id;

	public Factura(Pedido pedido, int numeroFactura, LocalDateTime fecha, double importe, String user_id) {
		this.pedido = pedido;
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		this.importe = importe;
		this.user_id = user_id;
	}

	public Factura(int numeroFactura, String fecha, double importe, String user_id) {
		this.numeroFactura = numeroFactura;
		this.fechaS = fecha;
		this.importe = importe;
		this.user_id = user_id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public static int getNumero() {
		return numero;
	}

	public static void setNumero(int numero) {
		Factura.numero = numero;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFechaS() {
		return fechaS;
	}

	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}
}
