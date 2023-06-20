package comm.xuxuy.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="facturas")
@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate fechaDeAlta;
	private long numero; 
	@ManyToMany(cascade = {jakarta.persistence.CascadeType.ALL},
	           fetch = jakarta.persistence.FetchType.EAGER)
	private List<Producto> productos;
	@OneToOne(mappedBy = "factura")
	private Venta venta;
	
	//Datos del cliente
	private String nombreCliente; 
	private String apellidoCliente; 
	private String dniCliente;
	
	public long getId() {
		return id;
	}
	
	public Factura(String nombre, String apellido, String dni, List<Producto> productos)
	{
	    nombreCliente = nombre; 
	    apellidoCliente = apellido; 
	    dniCliente = dni;
	    this.productos = productos; 
	}
	

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
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
