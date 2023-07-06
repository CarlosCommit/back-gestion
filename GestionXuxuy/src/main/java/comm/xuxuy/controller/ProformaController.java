package comm.xuxuy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comm.xuxuy.dtos.ProformaDTO;

import comm.xuxuy.service.ProformaService;

@RestController
@RequestMapping("/proforma")
public class ProformaController {

	@Autowired
	ProformaService proformaService;
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object> > obtenerProforma(@PathVariable long id)
	{
		Map<String, Object> response = new HashMap<>();
		ProformaDTO proforma = proformaService.buscarProforma(id);
		response.put("Proforma encontrada:", proforma);
		return new ResponseEntity<Map<String,Object> >(response,HttpStatus.OK); 	
	}
	
	
	
}
