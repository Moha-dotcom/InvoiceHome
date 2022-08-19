package org.example;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.colors.ColorConstants;
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

    public void createInvoiceDocument(String PDFName) throws IOException, DocumentException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(PDFName));
        document.open();


        document.setPageSize(PageSize.A4);
        document.setPageCount(2);
        float col = 50f;
        float col1 = 110f;
        float [] colwidth = {col};



        PdfPTable from = new PdfPTable(colwidth);
        Paragraph fromPhrase = new Paragraph("North East Express LLC  2450 Wnnetka ave N  Golden Valley MN, 55427");

        fromPhrase.setFont(new Font(Font.FontFamily.COURIER));

        from.setHorizontalAlignment(0);
        from.setWidthPercentage(35);
        fromPhrase.setSpacingBefore(23);

        PdfPCell pdfPCell = new PdfPCell(fromPhrase);
        pdfPCell.setVerticalAlignment(10);
        pdfPCell.setPadding(20f);
        pdfPCell.setBorderColor(new BaseColor(230, 210, 170));
        from.addCell(pdfPCell);

        float [] colwidth1 = {200};
        PdfPTable to = new PdfPTable(colwidth1);
        Paragraph toPhrase = new Paragraph("North East Express LLC  2450 Wnnetka ave N  Golden Valley MN, 55427");

        toPhrase.setFont(new Font(Font.FontFamily.COURIER));


        to.setWidthPercentage(30);
        toPhrase.setSpacingBefore(23);
        to.setHorizontalAlignment(Element.ALIGN_LEFT);

        PdfPCell topdfPCell = new PdfPCell(toPhrase);
        topdfPCell.setVerticalAlignment(10);
        topdfPCell.setPadding(20f);
        topdfPCell.setBorderColor(new BaseColor(230, 210, 170));
        topdfPCell.setBackgroundColor(new BaseColor(96, 1, 44));



        to.setSpacingBefore(50);

        to.addCell(topdfPCell);







        PdfPTable invoiceinfo = new PdfPTable(colwidth);
        Paragraph invocePhrase = new Paragraph("North East Express LLC  2450 Wnnetka ave N  Golden Valley MN, 55427");

        invocePhrase.setFont(new Font(Font.FontFamily.COURIER));



        invocePhrase.setSpacingBefore(23);

        PdfPCell invoicecell = new PdfPCell(invocePhrase);


        invoicecell.setBorderColor(new BaseColor(230, 210, 170));
        invoiceinfo.addCell(invoicecell);

        invoiceinfo.setWidthPercentage(30);
        invoiceinfo.setHorizontalAlignment(Element.ALIGN_RIGHT);
       invoiceinfo.








        document.add(from);
        document.add(to);
        document.add(invoiceinfo);




        document.close();




    }

    public void addCustomRows(){

    }

    public void addHeader(PdfPTable pdfPTable) throws BadElementException, IOException {




    }

}


//
//
//    PdfPTable pdfPTable = new PdfPTable(colwidth);
//        pdfPTable.addCell("Name");
//                pdfPTable.addCell("Age");
//                pdfPTable.addCell("Company");
//
//                BaseColor color = new BaseColor(2, 203, 66);
//
//                Phrase phrase =new Phrase("Mohamed Ahmed");
//
//
//                phrase.setFont(new Font(Font.FontFamily.COURIER, 1));
//
//                PdfPCell pdfPCell = new PdfPCell(phrase);
//                pdfPCell.setBorderColorLeft(color);
//                pdfPCell.setBorder(0);
//                pdfPCell.setBackgroundColor(color);
//
//                pdfPTable.addCell(pdfPCell);
//                PdfPCell pdfPCell1 = new PdfPCell(new Phrase("12"));
//                pdfPCell1.setBorder(0);
//                pdfPCell1.setBackgroundColor(color);
//                pdfPTable.addCell(pdfPCell1);
//                pdfPTable.addCell("Amazon");
//                pdfPTable.setHorizontalAlignment(0);
//
//
//                pdfPTable.addCell();
//                pdfPTable.addCell("29");
//                pdfPTable.addCell("Akron");
//
//
//                float pcol [] = {70, 160, 250};
//
//                Font font = new Font();
//
//
//                PdfPTable p = new PdfPTable(pcol);
//                PdfPCell cell1 = new PdfPCell(new Phrase("Supplier ID"));
//                cell1.setBorder(0);
//                cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                p.addCell(cell1);
//                p.addCell("Supplier Name");
//                p.addCell("Supper Location");
//
//                p.addCell("27882");
//                p.addCell("Amazon Packaging");
//                p.addCell("737 Van buren Ava Golden Valley MN");
//                p.setSpacingBefore(100);
//                p.setHorizontalAlignment(0);
//                p.setWidthPercentage(100);
//
//
//
//
//
//
//
//                document.add(pdfPTable);
//                document.add(p);
