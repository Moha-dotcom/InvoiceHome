package org.example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invoice {

    private Company from;
    private Company to;

    private String invoiceNumber;
    private Description des ;
    private Integer Amount;

    private Date date;
    private Map<Description, Integer> items = new HashMap<>();

    private double total;
    public Invoice(Company from, Company to, String invoiceNumber, Description des, Integer amount, Date date) {
        this.from = from;
        this.to = to;
        this.invoiceNumber = invoiceNumber;
        this.des = des;
        Amount = amount;
        this.date = date;
        this.items = items;
    }








    public void addNewItem(Description des, Integer amount){
       items.put(des, amount);
    }


    public double calculateInvoiceAmount(){
        double sumofItems = 0;
        for(Map.Entry<Description, Integer> a : items.entrySet()){
           sumofItems += a.getValue();
        }

        setTotal(sumofItems);
        return sumofItems;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Company getFrom() {
        return from;
    }

    public double getTotal() {
        return total;
    }

    public Company getTo() {
        return to;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Description getDes() {
        return des;
    }

    public Integer getAmount() {
        return Amount;
    }

    public Date getDate() {
        return date;
    }

    public Map<Description, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "from=" + from +
                ", to=" + to +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", des=" + des +
                ", Amount=" + Amount +
                ", date=" + date +
                ", items=" + items +
                '}';
    }
}
