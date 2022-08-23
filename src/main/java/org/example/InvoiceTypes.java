package org.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.print.Doc;
import java.io.FileOutputStream;
import java.io.IOException;

public enum InvoiceTypes {

    DEAFAULT{
        @Override
        public Document ShowInvoice(String PDFName, Invoice invoice) throws IOException, DocumentException {

            // Fonts Colors
            Font largeBold = new Font(Font.FontFamily.TIMES_ROMAN, 9,
                    Font.NORMAL,  new BaseColor(250, 47, 181));
            Font smallItalic = new Font(Font.FontFamily.HELVETICA, 10,
                    Font.ITALIC);
            Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                    Font.UNDERLINE, new BaseColor(250, 47, 181));


            Font DefaultInvoceFontType = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);

            Font desFonttype = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(PDFName));
            document.open();


            document.setPageSize(PageSize.A4);
            document.setPageCount(4);
            float col = 50f;
            float col1 =100f;
            float [] colwidth = {col, col1};

            // Bill From


            String imageLogo = invoice.getLogo();


            com.itextpdf.text.Image image
                     = com.itextpdf.text.Image.getInstance(imageLogo);

            image.scaleToFit(150f, 150f);
            image.setAlignment(Element.ALIGN_CENTER);





            PdfPTable from = new PdfPTable(colwidth);
            String billFrom = invoice.getFrom().getCompanyName() + "\n" +  invoice.getFrom().getCompanyAddress();
            Paragraph fromPhrase = new Paragraph(billFrom,DefaultInvoceFontType);
            fromPhrase.setFont(new Font(Font.FontFamily.COURIER));

            from.setHorizontalAlignment(0);
            from.setWidthPercentage(100);


//            fromPhrase.setSpacingBefore(23);






            PdfPCell pdfPCell = new PdfPCell(fromPhrase);
//            pdfPCell.setVerticalAlignment(10);
            pdfPCell.setPadding(10f);
            pdfPCell.setBorderColor(new BaseColor(250, 47, 181));
            pdfPCell.setBorder(0);
            pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            from.addCell(pdfPCell);

            image.setWidthPercentage(20);


            PdfPCell imagecell = new PdfPCell(image);
            imagecell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            imagecell.setBorder(0);

            from.addCell(imagecell);






            float [] toColWith = {130,290, 80};

            PdfPTable pdfPTable = new PdfPTable(toColWith);

            pdfPTable.setHorizontalAlignment(Element.ALIGN_LEFT);
            pdfPTable.setWidthPercentage(100);
            pdfPTable.setSpacingBefore(40);


            // Bill To

            PdfPCell Billtocell = new PdfPCell(new Phrase("BILL TO", largeBold));
            Billtocell.setRowspan(2);
            Billtocell.setBorder(0);
            pdfPTable.addCell(Billtocell);

            // Invoice #
            PdfPCell invoiceNo = new PdfPCell(new Phrase("INVOICE #", largeBold));
            invoiceNo.setBorder(0);
//        invoiceNo.setHorizontalAlignment(Element.ALIGN_RIGHT);
//        invoiceNo.setLeading(0f,2f);
            invoiceNo.setIndent(200f);

            pdfPTable.addCell(invoiceNo);

            // Invoice Number

            PdfPCell invoiceDate = new PdfPCell(new Phrase(invoice.getInvoiceNumber(), DefaultInvoceFontType));
            invoiceDate.setBorder(0);
//        invoiceDate.setLeading(0f,2f);
            invoiceDate.setHorizontalAlignment(Element.ALIGN_RIGHT);
            pdfPTable.addCell(invoiceDate);



            // Bill To

            PdfPTable rowF = new PdfPTable(toColWith);
            rowF.setHorizontalAlignment(Element.ALIGN_LEFT);
            rowF.setWidthPercentage(100);
            rowF.setSpacingBefore(10);
            String billToAddress =  invoice.getTo().getCompanyName() + "\n" + invoice.getTo().getCompanyAddress();
            Paragraph a = new Paragraph(billToAddress, DefaultInvoceFontType);
            a.setFont(new Font(Font.FontFamily.COURIER));



            PdfPCell addressrow = new PdfPCell(a);
            addressrow.setRowspan(2);
            addressrow.setBorder(0);
//        addressrow.setBackgroundColor(new BaseColor(1,2,45));

            addressrow.setHorizontalAlignment(Element.ALIGN_LEFT);

            rowF.addCell(addressrow);


            PdfPCell invoiceDat = new PdfPCell(new Phrase("INVOICE DATE", largeBold));
            invoiceDat.setBorder(0);
            invoiceDat.setIndent(190f);
            invoiceDat.setPadding(10);

            rowF.addCell(invoiceDat);


            PdfPCell Datein = new PdfPCell(new Phrase(String.valueOf(invoice.getDate()), DefaultInvoceFontType));
            Datein.setHorizontalAlignment(Element.ALIGN_RIGHT);
            Datein.setPadding(10);

            Datein.setBorder(0);
            rowF.addCell(Datein);



            float[] destable = {30,180, 100, 100};
            PdfPTable des = new PdfPTable(destable);
            des.setSpacingBefore(100);
            des.setWidthPercentage(100);
            des.setHorizontalAlignment(Element.ALIGN_LEFT);







            PdfPCell qty = new PdfPCell(new Phrase("QTY", desFonttype));
            qty.setBorderWidthRight(0);
            qty.setBorderWidthLeft(0);
            qty.setBorderWidthTop(1);
            qty.setBorderWidthBottom(1);
            qty.setBorderColor(new BaseColor(250, 47, 181));
            qty.setPadding(5);



            des.addCell(qty);

            PdfPCell decription = new PdfPCell(new Phrase("DESCRIPTION", desFonttype));
            decription.setBorderWidthRight(0);
            decription.setBorderWidthLeft(0);
            decription.setBorderWidthTop(1);
            decription.setBorderWidthBottom(1);
            decription.setBorderColor(new BaseColor(250, 47, 181));
            decription.setPadding(5);

            des.addCell(decription);

            PdfPCell unit = new PdfPCell(new Phrase("UNIT PRICE", desFonttype));
            unit.setBorderWidthRight(0);
            unit.setBorderWidthLeft(0);
            unit.setBorderWidthTop(1);
            unit.setBorderWidthBottom(1);
            unit.setBorderColor(new BaseColor(250, 47, 181));
            unit.setPadding(5);

           des.addCell(unit);

            PdfPCell Amount = new PdfPCell(new Phrase("AMOUNT", desFonttype));
            Amount.setBorderWidthLeft(0);
            Amount.setBorderWidthRight(0);
            Amount.setBorderWidthTop(1);
            Amount.setBorderWidthBottom(1);
            Amount.setHorizontalAlignment(Element.ALIGN_RIGHT);
            Amount.setBorderColor(new BaseColor(250, 47, 181));
            Amount.setPadding(5);

            des.addCell(Amount);










            document.add(from);
            document.add(pdfPTable);
            document.add(rowF);
            document.add(des);

            for(int i = 0; i < invoice.getItem().size(); i++){
                // Invoice Description

                PdfPTable desTable = new PdfPTable(destable);
                desTable.setSpacingBefore(10);
                desTable.setWidthPercentage(100);
                desTable.setHorizontalAlignment(Element.ALIGN_LEFT);


                // Qty Row

                PdfPCell qtysec = new PdfPCell(new Phrase(String.valueOf(invoice.getItem().get(i).getQty()), desFonttype));
                qtysec.setBorder(0);

                desTable.addCell(qtysec);

                PdfPCell itemdesSec = new PdfPCell(new Phrase(invoice.getItem().get(i).getDescription(), desFonttype));
                itemdesSec.setBorder(0);
                desTable.addCell(itemdesSec);

                PdfPCell unitpricesec = new PdfPCell(new Phrase(String.valueOf("$" + invoice.getItem().get(i).getUnitPrice()), desFonttype));
                unitpricesec.setBorder(0);
//                unitpricesec.setHorizontalAlignment(Element.ALIGN_RIGHT);
                desTable.addCell(unitpricesec);


                PdfPCell amountpricesec = new PdfPCell(new Phrase(String.valueOf("$" + invoice.getItem().get(i).getAmount()), desFonttype));
                amountpricesec.setBorder(0);
                amountpricesec.setHorizontalAlignment(Element.ALIGN_RIGHT);
                desTable.addCell(amountpricesec);



                desTable.addCell(amountpricesec);
                document.add(desTable);
            }


            float totalcol [] =  {100, 100};

            PdfPTable totaltable = new PdfPTable(totalcol);
            totaltable.setSpacingBefore(60);

            totaltable.setWidthPercentage(100);
            totaltable.setHorizontalAlignment(Element.ALIGN_LEFT);
//            totaltable.addCell("");
//
//            totaltable.addCell(" ");
            PdfPCell totaldes = new PdfPCell(new Phrase("TOTAL", desFonttype));
            totaldes.setBorder(0);
            totaldes.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totaltable.addCell(totaldes);
            PdfPCell ttlamoutn = new PdfPCell(new Phrase(String.valueOf("$" + invoice.getTotal()), desFonttype));
            ttlamoutn.setHorizontalAlignment(Element.ALIGN_RIGHT);
            ttlamoutn.setBorder(0);
            totaltable.addCell(ttlamoutn);



            document.add(totaltable);

            Font thankyoufont = new Font(Font.FontFamily.TIMES_ROMAN, 35,
                    Font.ITALIC,  new BaseColor(250, 47, 181));

            Font signaturefont = new Font(Font.FontFamily.TIMES_ROMAN, 15,
                    Font.ITALIC,  new BaseColor(250, 47, 181));

            float [] thankyouspa = {100, 100};
            PdfPTable thankyou = new PdfPTable(thankyouspa);
            thankyou.setSpacingBefore(200);
            thankyou.setWidthPercentage(100);

            PdfPCell signature = new PdfPCell(new Phrase("Signature", signaturefont));
            signature.setHorizontalAlignment(Element.ALIGN_LEFT);
            thankyou.addCell(signature);





            PdfPCell thankyoucell = new PdfPCell(new Phrase("Thank You",thankyoufont));
            thankyoucell.setBorder(0);
            thankyoucell.setHorizontalAlignment(Element.ALIGN_RIGHT);

            thankyou.addCell(thankyoucell);



            document.add(thankyou);

            document.close();


            return document;

        }
    } , BLACK{
        @Override
        public Document ShowInvoice(String PDFName, Invoice invoice) {

            return null;
        }
    }, YELLOW {
        @Override
        public Document ShowInvoice(String PDFName, Invoice invoice) {

            return null;
        }
    };


    InvoiceTypes() {
    }




    public Document ShowInvoice(String PDFName, Invoice invoice) throws IOException, DocumentException {

        return  null;
    }

}
