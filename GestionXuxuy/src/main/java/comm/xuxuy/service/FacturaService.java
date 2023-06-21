package comm.xuxuy.service;

import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.model.Factura;

public interface FacturaService {

	public Factura generarFactura(ProformaDTO proforma);
	
	public ProformaDTO registrarFactura(Factura factura);
	
}
