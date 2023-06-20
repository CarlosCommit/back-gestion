package comm.xuxuy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import comm.xuxuy.service.imp.ProductoServiceImp;

@RestController
@RequestMapping("catalogo")
public class CatalogoApi {
	
	@Autowired
	ProductoServiceImp productoService;
	
	//servicioProductos
	@GetMapping()
	public ResponseEntity<Map<String, Object> > obtenerLista()
	{
		Map<String, Object> response = new HashMap<>();

		response.put("Lista de Productos Disponibles:", productoService.getListaProductos());
		return new ResponseEntity<Map<String,Object> >(response,HttpStatus.OK); 	
	}
	
}
