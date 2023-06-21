package comm.xuxuy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.model.Factura;
import comm.xuxuy.service.FacturaService;

@RestController
@RequestMapping("/xuxuy") 
public class XuxuyApi {
	
	@Autowired 
	private FacturaService facturaService;
	
	@PostMapping
	public ResponseEntity<Map<String, Object> > guardarFactura(@RequestBody ProformaDTO proforma)
	{
		Map<String, Object> response = new HashMap<>();
		//COBRO Y GENERAR LA VENTA		
		//GENERAMOS FACTURA
		Factura factura = facturaService.generarFactura(proforma); 
		response.put("Factura guardado:",facturaService.registrarFactura(factura));
		return new ResponseEntity<Map<String,Object> >(response,HttpStatus.OK); 	
	}
	
}
