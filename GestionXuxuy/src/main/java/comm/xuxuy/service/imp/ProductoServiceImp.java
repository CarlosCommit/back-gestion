package comm.xuxuy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.xuxuy.dtos.ProductoDTO;
import comm.xuxuy.model.Producto;
import comm.xuxuy.repository.ProductoDAO;

@Service
public class ProductoServiceImp {

	@Autowired
	ProductoDAO productoRepository; 
	
	public List<Producto> getListaProductos()
	{
		return productoRepository.findAll();
	}
	
	public ProductoDTO getProductoById(long id)
	{
		Producto producto =  productoRepository.findById(id).get();
		ProductoDTO productoRespuesta = new ProductoDTO();
		productoRespuesta.setId(producto.getId());
		productoRespuesta.setNombre(producto.getNombre());
		productoRespuesta.setPrecio(producto.getPrecio());
		productoRespuesta.setStock(producto.getStock());
		return productoRespuesta;
	}
	public void actualizarStockProductos(List<ProductoDTO>productos)
	{
		Producto producto = new Producto();
		for(ProductoDTO product: productos)
		{
			producto = productoRepository.findById(product.getId()).get();
			producto.setStock(producto.getStock()-product.getCantidad());
			productoRepository.save(producto); 
		}
		
	}
}
