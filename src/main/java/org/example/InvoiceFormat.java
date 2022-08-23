package org.example;

import com.itextpdf.text.*;


import javax.print.Doc;
import java.io.*;


public class InvoiceFormat {

    public void createInvoiceDocument(String PDFName, Invoice invoice) throws IOException, DocumentException {

      InvoiceTypes a = InvoiceTypes.DEAFAULT;
      a.ShowInvoice(PDFName,  invoice);
      System.out.println("Invoice is Successfully Created" + "  \nInvoice Number : " +  invoice.getInvoiceNumber());




    }

//    private byte[] getByteArrayFromFile(final Document handledDocument) throws IOException {
//        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            InputStream in = new FileInputStream(handledDocument);
//            final byte[] buffer = new byte[500];
//
//            int read = -1;
//            while ((read = in.read(buffer)) > 0) {
//                baos.write(buffer, 0, read);
//            }
//            in.close();
//
//        return baos.toByteArray();
//    }


}


