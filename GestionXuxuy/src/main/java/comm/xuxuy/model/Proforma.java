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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Proforma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long numero;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proforma")
	private List<ProformaDetalle> proformaDetalle = new ArrayList<ProformaDetalle>();
	@ManyToOne
	private Cliente cliente;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	public List<ProformaDetalle> getProformaDetalle() {
		return proformaDetalle;
	}
	public void setProformaDetalle(List<ProformaDetalle> proformaDetalle) {
		this.proformaDetalle = proformaDetalle;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	} 
	
	
	
}
