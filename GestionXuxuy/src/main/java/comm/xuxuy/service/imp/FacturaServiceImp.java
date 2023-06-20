package comm.xuxuy.service.imp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.model.Factura;
import comm.xuxuy.repository.FacturaDAO;
import comm.xuxuy.service.FacturaService;

@Service
public class FacturaServiceImp implements FacturaService {

	@Autowired
	private FacturaDAO facturaRepository;

	@Override
	public Factura generarFactura(ProformaDTO proforma) {
		Factura factura = new Factura(proforma.getNombreCliente(), proforma.getApellidoCliente(),proforma.getDniCliente(),proforma.getProductos()); 
	    factura.setFechaDeAlta(LocalDate.now());
		return factura;
	}

	@Override
	public Factura registrarFactura(Factura factura) {
		facturaRepository.save(factura);
		return factura; 
	}
	
	
	
}
