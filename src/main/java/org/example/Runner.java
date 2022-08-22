package org.example;

import com.itextpdf.text.*;



import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, DocumentException, URISyntaxException {





        Company from = new Company("North East Express LLC", "238 Wycliff ave N Saint Paul, MN, 55436");
        Company to = new Company("Amazon", "423 WestBrook ave N Saint Monica, CA, 89942");
        Description des= new Description("Load from Mn to Cal");
        Invoice inv = new Invoice(from , to, "8383993",  LocalDate.now());



        Items item = new Items(1,"Load Fee", 1000);
        Items item2 = new Items(2, "Lumber Fee", 200);
        Items item3 = new Items(4, "Maintaince Expense", 340);

        inv.setItems(item);
        inv.setItems(item2);
        inv.setItems(item3);



        InvoiceFormat invoiceFormat =  new InvoiceFormat();
        invoiceFormat.createInvoiceDocument("Lester.pdf", inv);








    }

}