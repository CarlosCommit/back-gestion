package comm.xuxuy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
	private List<FacturaDetalle> facturaDetalle = new ArrayList<FacturaDetalle>();	
	@ManyToOne
	private Cliente cliente;
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FacturaDetalle> getFacturaDetalle() {
		return facturaDetalle;
	}

	public void setFacturaDetalle(List<FacturaDetalle> facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}

	
	public long getId() {
		return id;
	}
	

	public Factura()
	{
	    fechaDeAlta = LocalDate.now();
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

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fechaDeAlta=" + fechaDeAlta + ", numero=" + numero + ", facturaDetalle="
				+ facturaDetalle + ", cliente=" + cliente + "]";
	}
	



	
	
	
}
