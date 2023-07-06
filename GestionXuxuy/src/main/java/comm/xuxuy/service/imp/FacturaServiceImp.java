package comm.xuxuy.service.imp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.xuxuy.dtos.ProductoDTO;
import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.model.Cliente;
import comm.xuxuy.model.Factura;
import comm.xuxuy.model.FacturaDetalle;
import comm.xuxuy.model.Producto;
import comm.xuxuy.model.ProformaDetalle;
import comm.xuxuy.repository.ClienteDAO;
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
	
	@Autowired
	private ClienteDAO clienteRepository; 
	@Override
	public Factura generarFactura(ProformaDTO proforma) {
		
		Factura nuevaFactura = new Factura(); 
		Cliente cliente = clienteRepository.findById(proforma.getIdCliente()).get();
		nuevaFactura.setCliente(cliente);
		nuevaFactura.setNumero(numero++);
		FacturaDetalle detalleFactura = new FacturaDetalle(); 
		for(ProductoDTO producto: proforma.getProductos())
		{
			
			detalleFactura.setProducto(productoRepository.findById(producto.getId()).get());
			detalleFactura.setCantidad(producto.getCantidad());
			detalleFactura.setFactura(nuevaFactura);
			nuevaFactura.getFacturaDetalle().add(detalleFactura);
			detalleFactura = new FacturaDetalle(); 
		}
		
		return nuevaFactura; 
	}

	@Override
	public ProformaDTO registrarFactura(Factura factura) {
		factura = facturaRepository.save(factura);

		ProformaDTO facturaRespuesta = new ProformaDTO(); 
		
		facturaRespuesta.setId(factura.getId());
		facturaRespuesta.setNombreCliente(factura.getCliente().getNombre());
		facturaRespuesta.setApellidoCliente(factura.getCliente().getApellido());
		facturaRespuesta.setDniCliente(factura.getCliente().getDni());
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
