package comm.xuxuy.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="productos")
@Entity
public class Producto {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String nombre;
	private double precio;
	private int stock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
	private List<FacturaDetalle> facturaDetalle = new ArrayList<FacturaDetalle>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
	private List<ProformaDetalle> proformaDetalle = new ArrayList<ProformaDetalle>();
	
	@ManyToOne()
	private Pedido pedido; 
	
	
	
	public List<FacturaDetalle> getFacturaDetalle() {
		return facturaDetalle;
	}
	public void setFacturaDetalle(List<FacturaDetalle> facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	} 
	
	
	
}
