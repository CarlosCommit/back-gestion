package comm.xuxuy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Producto getProductoByName(String name)
	{
		return productoRepository.findByNombre(name);
	}
}
