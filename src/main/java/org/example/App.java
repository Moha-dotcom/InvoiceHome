package org.example;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.*;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, DocumentException, URISyntaxException {

        InvoiceFormat invoiceFormat =  new InvoiceFormat();
        invoiceFormat.createInvoiceDocument("Lester.pdf");

        List<Invoice> listofInvoices = new ArrayList<>();


//        Company from = new Company("North East Express LLC", "238 Wycliff ave N Saint Paul, MN, 55436");
//        Company to = new Company("Amazon", "423 WestBrook ave N Saint Monica, CA, 89942");
//        Description des= new Description("Load from Mn to Cal");
//        Invoice inv = new Invoice(from , to, "8383", des, 1345,new Date());
//        Description des1= new Description("Lumber Fee");
//        Description des2= new Description("Maintence");
//        inv.addNewItem(des1, 233);
//        inv.addNewItem(des2, 3);
//
//        listofInvoices.add(inv);
//
//
//
//
//        System.out.println(inv.calculateInvoiceAmount());
//        System.out.println(inv.getTotal());




    }

}