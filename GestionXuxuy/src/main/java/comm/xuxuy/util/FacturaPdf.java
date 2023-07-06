package comm.xuxuy.util;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfVersion;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import comm.xuxuy.dtos.ProductoDTO;
import comm.xuxuy.dtos.ProformaDTO;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;




public class FacturaPdf {

	public static void generarPdf(ProformaDTO factura)
	{
		
		/*
		try{
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outputStream,new WriterProperties().setPdfVersion(PdfVersion.PDF_1_7)));
	            pdfDoc.addNewPage();
				pdfDoc.setDefaultPageSize(PageSize.TABLOID);
				
	            Document document = new Document(pdfDoc);
	            
	     
	            Paragraph title = new Paragraph("Factura de compra").setFontSize(20f).setBold();
	            document.add(title);
	            document.add(new Paragraph("Factura de compra").setFontSize(20f).setBold());
	            document.close();
	       
	            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
	            String printerName = "Microsoft XPS Document Writer";
	            PrintService printService = getPrintServiceByName(printerName);
	            if (printService != null) {
	                PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
	                attributes.add(MediaSizeName.ISO_A4);
	                DocPrintJob printJob = printService.createPrintJob();
	                Doc doc = new SimpleDoc(inputStream, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
	               printJob.print(doc, attributes);
	                System.out.println("El PDF se ha enviado a imprimir correctamente.");
	            } else {
	                System.out.println("Impresora no encontrada.");
	            }
	            
	        
	           
	            inputStream.close();
	            outputStream.close();
	            
	        } catch (IOException | PrintException e) {
	            e.printStackTrace();}
		*/
		
		
		
		

        try {
            // Inicializar el documento PDF
        	FileOutputStream outputStream = new FileOutputStream("archivo1.pdf");
            PdfWriter pdfWriter = new PdfWriter(outputStream);
            PdfDocument pdfDoc= new PdfDocument(pdfWriter);
            Document document = new Document(pdfDoc);
            

            
            
            
            
            // Fuente para los encabezados
            com.itextpdf.kernel.font.PdfFont headerFont = PdfFontFactory.createFont();
            
            // Fuente para el contenido
            com.itextpdf.kernel.font.PdfFont contentFont = PdfFontFactory.createFont();

            
            
            
         
            
            // Crear los elementos de la factura
            Paragraph title = new Paragraph("XUXUY - Factura de Compra")
                    .setFont(headerFont)
                    .setFontSize(20f)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(20f)
                    .add(new Text("     NUMERO DE FACTURA: "+ "000"+ factura.getId() ).setFontSize(9f));

            // Datos del cliente
            Paragraph customerInfo = new Paragraph()
                    .add(new Text("Nombre del Cliente: ").setFont(contentFont))
                    .add(new Text( factura.getNombreCliente()).setFont(contentFont))
                    .add(new Text(" " + factura.getApellidoCliente()).setFont(contentFont))
                    .add(new Text(" DNI: " +factura.getDniCliente()).setFont(contentFont))
                    .setMarginBottom(10f);

            DateTimeFormatter fechaFormato =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            Paragraph dateInfo = new Paragraph()
                    .add(new Text("Fecha: ").setFont(contentFont))
                    .add(new Text( fechaFormato.format(LocalDate.now()) ).setFont(contentFont))
                    .setMarginBottom(10f);


            // Total
            Paragraph total = new Paragraph()
                    .add(new Text("Total: ").setFont(contentFont))
                    .add(new Text("$"+getTotal(factura.getProductos())).setFont(contentFont))
                    .setMarginTop(20f);

            // Agregar los elementos al documento
            
            
            Div contentDiv = new Div()
                    .setBorder(new SolidBorder(1f)) // Establecer el borde al Div
                    .setPadding(20f); // Agregar un espacio interno de 20 unidades

            // Agregar el contenido de la factura al Div
            
            
            contentDiv.add(title);
            contentDiv.add(customerInfo);
            
            contentDiv.add(dateInfo);
            contentDiv.add(getTablaDeProducto(factura.getProductos()));
            
            contentDiv.add(total);
            document.add(contentDiv);
            
            

            // Cerrar el documento
            document.close();

            System.out.println("La factura ha sido generada correctamente.");

        } catch ( IOException e) {
            e.printStackTrace();
        }
    
	}
	
	
	
	// Obtén una instancia de PrintService por nombre
    static PrintService getPrintServiceByName(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

        for (PrintService printService : printServices) {
            if (printService.getName().equalsIgnoreCase(printerName)) {
                return printService;
            }
        }

        return null;
    }
    
    
    static Table getTablaDeProducto(List<ProductoDTO> productos)
    {
    	 Table table = new Table(new float[]{1, 4, 2, 2})
                 .useAllAvailableWidth()
                 .setHorizontalAlignment(HorizontalAlignment.CENTER)
                 .setMarginBottom(20f);
    	try {
    	 // Fuente para los encabezados
        com.itextpdf.kernel.font.PdfFont headerFont = PdfFontFactory.createFont();
        
        // Fuente para el contenido
        com.itextpdf.kernel.font.PdfFont contentFont = PdfFontFactory.createFont();

       

        // Encabezados de la tabla
        table.addHeaderCell(new Cell().add(new Paragraph("ID").setFont(headerFont)));
        table.addHeaderCell(new Cell().add(new Paragraph("Producto").setFont(headerFont)));
        table.addHeaderCell(new Cell().add(new Paragraph("Precio Unitario").setFont(headerFont)));
        table.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFont(headerFont)));

        
        for(ProductoDTO producto: productos)
        {
        	 table.addCell(""+producto.getId());
             table.addCell(producto.getNombre());
             table.addCell("$"+producto.getPrecio());
             table.addCell(""+producto.getCantidad());
        }
        
    	}catch(IOException e){
    		e.getMessage();
    		
    	}
        return table; 
    }
	
    private static double getTotal(List<ProductoDTO> productos)
    {
    	double total=0;
    	for(ProductoDTO producto : productos)
    	{
    		total = total+ producto.getPrecio()*producto.getCantidad();
    	}
    	return total;
    	
    }
}
