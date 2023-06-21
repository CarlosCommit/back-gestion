package comm.xuxuy.service.imp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.xuxuy.dtos.ProductoDTO;
import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.model.Factura;
import comm.xuxuy.model.FacturaDetalle;
import comm.xuxuy.model.Producto;
import comm.xuxuy.repository.FacturaDAO;
import comm.xuxuy.repository.ProductoDAO;
import comm.xuxuy.service.FacturaService;

@Service
public class FacturaServiceImp implements FacturaService {

	private long  numero=1;
	@Autowired
	private FacturaDAO facturaRepository;

	@Autowired
	private ProductoDAO productoRepository;
	@Override
	public Factura generarFactura(ProformaDTO proforma) {
		
	   System.out.println(proforma);
		FacturaDetalle facturaDetalle = new FacturaDetalle();
		Factura factura = new Factura(proforma.getNombreCliente(), proforma.getApellidoCliente(),proforma.getDniCliente()); 
		
        for(ProductoDTO producto : proforma.getProductos())
        {
         Producto productoBuscado = productoRepository.findById(producto.getId()).get();
         facturaDetalle = new FacturaDetalle();
         facturaDetalle.setProducto(productoBuscado);
         facturaDetalle.setCantidad(producto.getCantidad());
         facturaDetalle.setFactura(factura);
         factura.getFacturaDetalle().add(facturaDetalle);
        }
        
      
        factura.setNumero(numero++);
       // System.out.println(factura);
        return factura;
	}

	@Override
	public ProformaDTO registrarFactura(Factura factura) {
		facturaRepository.save(factura);
		
		
		ProformaDTO facturaRespuesta = new ProformaDTO(); 
		
		facturaRespuesta.setNombreCliente(factura.getNombreCliente());
		facturaRespuesta.setApellidoCliente(factura.getApellidoCliente());
		facturaRespuesta.setDniCliente(factura.getDniCliente());
		for(FacturaDetalle detalle : factura.getFacturaDetalle())
		{
			Producto producto = detalle.getProducto();
			ProductoDTO productoDto = new ProductoDTO(); 
			productoDto.setId(producto.getId());
			productoDto.setNombre(producto.getNombre());
			productoDto.setPrecio(producto.getPrecio());
			productoDto.setCantidad(detalle.getCantidad());
			facturaRespuesta.getProductos().add(productoDto);
		}

		return facturaRespuesta; 
	}
	
	
	
}
