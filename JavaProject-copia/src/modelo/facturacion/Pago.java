package modelo.facturacion;

import java.time.LocalDateTime;

import modelo.usuario.Operador;
import modelo.usuario.Usuario;

public class Pago {
	
	private Factura factura;
	private int nroFactura;
	private Operador operador;
	private LocalDateTime fecha;
	private String fechaS;
	private double importe;
	private MedioPago medioPago;
	private String medioPagoS;
	private int id;


	public Pago(Factura factura) {
		this.factura = factura;
		this.fecha = factura.getFecha();
		this.importe = factura.getImporte();
		this.id = Integer.parseInt(factura.getUser_id());
	}

	public Pago(Factura factura, Operador operador) {
		this.factura = factura;
		this.operador = operador;
		this.fecha = factura.getFecha();
		this.importe = factura.getImporte();
		this.id = Integer.parseInt(factura.getUser_id());
	}

	public Pago(int nroFactura, String fechaS, double importe, String medioPagoS, int id) {
		this.nroFactura = nroFactura;
		this.fechaS = fechaS;
		this.importe = importe;
		this.medioPagoS = medioPagoS;
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
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

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}

	public String getFechaS() {
		return fechaS;
	}

	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}

	public String getMedioPagoS() {
		return medioPagoS;
	}

	public void setMedioPagoS(String medioPagoS) {
		this.medioPagoS = medioPagoS;
	}
}
