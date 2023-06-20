package comm.xuxuy.service.imp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.model.Factura;
import comm.xuxuy.model.Producto;
import comm.xuxuy.repository.FacturaDAO;
import comm.xuxuy.repository.ProductoDAO;
import comm.xuxuy.service.FacturaService;

@Service
public class FacturaServiceImp implements FacturaService {

	@Autowired
	private FacturaDAO facturaRepository;

	@Autowired
	private ProductoDAO productoRepository;
	@Override
	public Factura generarFactura(ProformaDTO proforma) {
		Factura factura = new Factura(proforma.getNombreCliente(), proforma.getApellidoCliente(),proforma.getDniCliente()); 
		
        for(Producto producto : proforma.getProductos())
        {
         Producto productoBuscado = productoRepository.findById(producto.getId()).get();
        		 factura.getProductos().add(productoBuscado);
        	System.out.println(producto);
        }
		
        return factura;
	}

	@Override
	public Factura registrarFactura(Factura factura) {
		facturaRepository.save(factura);
		return factura; 
	}
	
	
	
}
