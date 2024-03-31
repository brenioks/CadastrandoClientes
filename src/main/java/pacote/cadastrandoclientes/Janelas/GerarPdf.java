package pacote.cadastrandoclientes.Janelas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter; 
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class GerarPdf {
    
    public GerarPdf(String dados){
        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("relatorio.pdf"));
            
            String filePath = "C:\\Users\\USER\\OneDrive\\Área de Trabalho\\relatorio.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            
            document.open();
            document.add(new Paragraph("Relatório de Clientes\n\n" + dados));
            document.close();
            
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso verifique a area de trabalho!");
            System.out.println("PDF gerado com sucesso verifique a area de trabalho!");
            
        }catch(DocumentException | FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Erro ao gerar o PDF " + e.getMessage());
            System.out.println("Erro ao gerar o PDF " + e.getMessage());
            
        }
        
    }
    
}
