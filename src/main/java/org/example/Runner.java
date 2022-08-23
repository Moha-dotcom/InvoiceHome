package org.example;

import com.itextpdf.text.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Runner {


    @Autowired
    JdbcTemplate jdbcTemplate;
    public static void main(String[] args) throws IOException, DocumentException, URISyntaxException {



//

        Company from = new Company("Liberty Mututal Insurance", "238 Wycliff ave N Saint Paul, MN, 55436");
        Company to = new Company("North East Express", "423 WestBrook ave N Saint Monica, CA, 89942");

        Invoice CompanyInvoice = new Invoice(from, to, "84994293", LocalDate.now(), "images/logo.jpg");

        Items item = new Items(2, "Load Fee", 3000);
        Items item2 = new Items(2, "Lumber Fee", 200);
        Items item3 = new Items(4, "Maintaince Expense", 340);
        CompanyInvoice.setItems(item);
        CompanyInvoice.setItems(item2);
        CompanyInvoice.setItems(item3);




        InvoiceFormat invoiceFormat =  new InvoiceFormat();
        invoiceFormat.createInvoiceDocument(String.valueOf(CompanyInvoice.getInvoiceNumber() + ".pdf"), CompanyInvoice);















    }

}