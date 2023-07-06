package comm.xuxuy.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ProformaDTO {

	private long id;
	
	private long idCliente; 
	private String nombreCliente;
	private String apellidoCliente;
	private String dniCliente;
	private List<ProductoDTO> productos = new ArrayList<>(); 
	private LocalDate fechaDeAlta;
	
	
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public List<ProductoDTO> getProductos() {
		return productos;
	}
	
	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
