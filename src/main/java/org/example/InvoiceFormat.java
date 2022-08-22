package org.example;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.Background;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;


import javax.print.Doc;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;


public class InvoiceFormat {

    public void createInvoiceDocument(String PDFName, Invoice invoice) throws IOException, DocumentException {

      InvoiceTypes a = InvoiceTypes.DEAFAULT;

      a.ShowInvoice(PDFName,  invoice);




    }

    public void addCustomRows(){

    }

    public void addHeader(PdfPTable pdfPTable) throws BadElementException, IOException {




    }

}


