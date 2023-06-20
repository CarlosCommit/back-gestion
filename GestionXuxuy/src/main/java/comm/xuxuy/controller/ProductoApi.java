package comm.xuxuy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.xuxuy.service.imp.ProductoServiceImp;

@RestController
@RequestMapping("productos/")
public class ProductoApi {

	@Autowired
	ProductoServiceImp productoService;
	
	@GetMapping("nombre/{nombre}")
	public ResponseEntity<Map<String, Object> > getProductoByName(@PathVariable String nombre)
	{
		Map<String, Object> response = new HashMap<>();
		response.put("Producto Buscado:", productoService.getProductoByName(nombre));
		return new ResponseEntity<Map<String,Object> >(response,HttpStatus.OK); 	
	}
	
	
}
