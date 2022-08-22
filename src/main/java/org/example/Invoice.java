package org.example;

import java.time.LocalDate;
import java.util.*;

public class Invoice extends Items {

    private Company from;
    private Company to;

    private String invoiceNumber;


    private LocalDate date;

    private List<Items> item = new ArrayList<>();


    private double total;

    public Invoice(Company from, Company to, String invoiceNumber,  LocalDate date) {
        super();

        this.from = from;
        this.to = to;
        this.invoiceNumber = invoiceNumber;
        this.date = date;

    }

    public void setItems(Items items) {
        item.add(items);
    }

    public Company getFrom() {
        return from;
    }

    public Company getTo() {
        return to;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Items> getItem() {
        return item;
    }

    public double getTotal() {
        return total;
    }
}
