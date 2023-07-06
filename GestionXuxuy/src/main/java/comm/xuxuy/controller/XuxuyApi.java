package comm.xuxuy.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.xuxuy.dtos.ProductoDTO;
import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.model.Factura;
import comm.xuxuy.service.FacturaService;
import comm.xuxuy.service.PdfService;
import comm.xuxuy.service.imp.ProductoServiceImp;
import comm.xuxuy.util.FacturaPdf;

@RestController
@RequestMapping("/xuxuy") 
public class XuxuyApi {
	
	@Autowired 
	private FacturaService facturaService;
	@Autowired
	private PdfService pdfService;
	@Autowired
	private ProductoServiceImp productoService;
	
	
	@PostMapping
	public ResponseEntity<Map<String, Object> > guardarFactura(@RequestBody ProformaDTO proforma)
	{
		System.out.println("llego");
		Map<String, Object> response = new HashMap<>();
		//Generamos factura y registramos
         Factura factura = facturaService.generarFactura(proforma); 
         System.out.println("factura que generamos: " + factura);
         ProformaDTO facturaDTO = facturaService.registrarFactura(factura);
		//Imprimimos factura
		 pdfService.imprimir(facturaDTO);
		//Actualizar stock
		productoService.actualizarStockProductos(facturaDTO.getProductos());
		response.put("Factura guardada:", facturaDTO);
		return new ResponseEntity<Map<String,Object> >(response,HttpStatus.OK); 	
	}
	
}
