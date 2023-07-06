package comm.xuxuy.service.imp;

import org.springframework.stereotype.Service;

import comm.xuxuy.dtos.ProformaDTO;
import comm.xuxuy.service.PdfService;
import comm.xuxuy.util.FacturaPdf;

@Service
public class PdfServiceImp implements PdfService {

	public void imprimir(ProformaDTO proformaDto)
	{
		//FacturaPdf facturaPdf = new FacturaPdf();
		FacturaPdf.generarPdf(proformaDto);
	}
	
}
