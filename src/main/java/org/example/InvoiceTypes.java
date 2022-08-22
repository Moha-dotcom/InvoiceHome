package org.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public enum InvoiceTypes {

    DEAFAULT{
        @Override
        public void ShowInvoice(String PDFName, Invoice invoice) throws FileNotFoundException, DocumentException {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(PDFName));
            document.open();


            document.setPageSize(PageSize.A4);
            document.setPageCount(4);
            float col = 50f;
            float col1 = 110f;
            float [] colwidth = {col};

            // Bill From

            PdfPTable from = new PdfPTable(colwidth);
            String billFrom = invoice.getFrom().getCompanyName() + invoice.getFrom().getCompanyAddress();
            Paragraph fromPhrase = new Paragraph(billFrom);
            fromPhrase.setFont(new Font(Font.FontFamily.COURIER));

            from.setHorizontalAlignment(0);
            from.setWidthPercentage(35);
//            fromPhrase.setSpacingBefore(23);


            PdfPCell pdfPCell = new PdfPCell(fromPhrase);
            pdfPCell.setVerticalAlignment(10);
            pdfPCell.setPadding(20f);
            pdfPCell.setBorderColor(new BaseColor(194, 16, 16));
            from.addCell(pdfPCell);


            float [] toColWith = {130,290, 80};

            PdfPTable pdfPTable = new PdfPTable(toColWith);

            pdfPTable.setHorizontalAlignment(Element.ALIGN_LEFT);
            pdfPTable.setWidthPercentage(100);
            pdfPTable.setSpacingBefore(40);


            // Bill To

            PdfPCell Billtocell = new PdfPCell(new Phrase("Bill To"));
            Billtocell.setRowspan(2);
            Billtocell.setBorder(0);
            pdfPTable.addCell(Billtocell);

            // Invoice #
            PdfPCell invoiceNo = new PdfPCell(new Phrase("Invoice #"));
            invoiceNo.setBorder(0);
//        invoiceNo.setHorizontalAlignment(Element.ALIGN_RIGHT);
//        invoiceNo.setLeading(0f,2f);
            invoiceNo.setIndent(217f);

            pdfPTable.addCell(invoiceNo);

            // Invoice Number

            PdfPCell invoiceDate = new PdfPCell(new Phrase(invoice.getInvoiceNumber()));
            invoiceDate.setBorder(0);
//        invoiceDate.setLeading(0f,2f);
            invoiceDate.setHorizontalAlignment(Element.ALIGN_RIGHT);
            pdfPTable.addCell(invoiceDate);



            // Bill To

            PdfPTable rowF = new PdfPTable(toColWith);
            rowF.setHorizontalAlignment(Element.ALIGN_LEFT);
            rowF.setWidthPercentage(100);
            rowF.setSpacingBefore(10);
            String billToAddress =  invoice.getTo().getCompanyName() + invoice.getTo().getCompanyAddress();
            Paragraph a = new Paragraph(billToAddress);
            a.setFont(new Font(Font.FontFamily.COURIER));

            PdfPCell addressrow = new PdfPCell(a);
            addressrow.setRowspan(2);
            addressrow.setBorder(0);
//        addressrow.setBackgroundColor(new BaseColor(1,2,45));

            addressrow.setHorizontalAlignment(Element.ALIGN_LEFT);

            rowF.addCell(addressrow);


            PdfPCell invoiceDat = new PdfPCell(new Phrase("Invoice Date"));
            invoiceDat.setBorder(0);
            invoiceDat.setIndent(210f);
            invoiceDat.setPadding(10);

            rowF.addCell(invoiceDat);


            PdfPCell Datein = new PdfPCell(new Phrase(String.valueOf(invoice.getDate())));
            Datein.setHorizontalAlignment(Element.ALIGN_RIGHT);
            Datein.setPadding(10);

            Datein.setBorder(0);
            rowF.addCell(Datein);



            float[] destable = {100,100};
            PdfPTable des = new PdfPTable(destable);
            des.setSpacingBefore(100);
            des.setWidthPercentage(100);
            des.setHorizontalAlignment(Element.ALIGN_LEFT);



            Font largeBold = new Font(Font.FontFamily.COURIER, 32,
                    Font.BOLD);
            Font smallItalic = new Font(Font.FontFamily.HELVETICA, 10,
                    Font.ITALIC);
            Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                    Font.UNDERLINE, BaseColor.WHITE);




            PdfPCell decription = new PdfPCell(new Phrase("DESCRIPTION"));
            decription.setBorderWidthRight(0);
            decription.setBorderWidthLeft(0);
            decription.setBorderWidthTop(2);
            decription.setBorderWidthBottom(2);
            decription.setBorderColor(new BaseColor(194, 16, 16));
            decription.setPadding(5);

            des.addCell(decription);

            PdfPCell Amount = new PdfPCell(new Phrase("AMOUNT"));
            Amount.setBorderWidthLeft(0);
            Amount.setBorderWidthRight(0);
            Amount.setBorderWidthTop(2);
            Amount.setBorderWidthBottom(2);
            Amount.setHorizontalAlignment(Element.ALIGN_RIGHT);
            Amount.setBorderColor(new BaseColor(194, 16, 16));
            Amount.setPadding(5);

            des.addCell(Amount);



            document.add(from);
            document.add(pdfPTable);
            document.add(rowF);
            document.add(des);


            document.close();

        }
    } , BLACK{
        @Override
        public void ShowInvoice(String PDFName, Invoice invoice) {

        }
    }, YELLOW {
        @Override
        public void ShowInvoice(String PDFName, Invoice invoice) {

        }
    };


    InvoiceTypes() {
    }




    public void ShowInvoice(String PDFName, Invoice invoice) throws FileNotFoundException, DocumentException {

    }

}
