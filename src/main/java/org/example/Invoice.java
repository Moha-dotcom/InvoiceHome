package org.example;

import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Invoice extends Items {

    private Company from;
    private Company to;

    private String invoiceNumber;

    private String logo;


    private LocalDate date;

    private List<Items> item = new ArrayList<>();


    private double total;

    public Invoice(Company from, Company to, String invoiceNumber,  LocalDate date, String logo) {
        super();

        this.logo = logo;

        this.from = from;
        this.to = to;
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.total = getTotal();

    }

    public String getLogo() {
        return logo;
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
       double sum = item.stream()
               .map(Items::getAmount)
               .reduce(0 , Integer::sum);
        return sum;
    }

}
