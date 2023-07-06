package comm.xuxuy.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.xuxuy.dtos.ProductoDTO;
import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.model.Producto;
import comm.xuxuy.model.Proforma;
import comm.xuxuy.model.ProformaDetalle;
import comm.xuxuy.repository.ProformaDAO;
import comm.xuxuy.service.ProformaService;

@Service
public class ProformaServiceImp implements ProformaService {

	@Autowired
	ProformaDAO proformaRepository;
	
	@Override
	public ProformaDTO buscarProforma(long id) {
	
	
		Proforma proforma = proformaRepository.findById(id).get();
		
		
		ProformaDTO proformaRespuesta = new ProformaDTO(); 
		
		proformaRespuesta.setId(proforma.getId());
		proformaRespuesta.setIdCliente(proforma.getCliente().getId());
		proformaRespuesta.setNombreCliente(proforma.getCliente().getNombre());
		proformaRespuesta.setApellidoCliente(proforma.getCliente().getApellido());
		proformaRespuesta.setDniCliente(proforma.getCliente().getDni());
		
		for(ProformaDetalle detalle : proforma.getProformaDetalle())
		{
			Producto producto = detalle.getProducto();
			ProductoDTO productoDto = new ProductoDTO(); 
			productoDto.setId(producto.getId());
			productoDto.setNombre(producto.getNombre());
			productoDto.setPrecio(producto.getPrecio());
			productoDto.setCantidad(detalle.getCantidad());
			proformaRespuesta.getProductos().add(productoDto);
		}

		return proformaRespuesta; 
	}

}
