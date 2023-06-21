package comm.xuxuy.dtos;

import java.util.ArrayList;
import java.util.List;


public class ProformaDTO {

	private String nombreCliente;
	private String apellidoCliente;
	private String dniCliente;
	private List<ProductoDTO> productos = new ArrayList<>(); 
	
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
	
	
}
