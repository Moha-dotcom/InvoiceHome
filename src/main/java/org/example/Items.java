package org.example;

public class Items {

    private int qty;
    private String description;
    private int unitPrice;
    private int amount;


    public Items() {
    }

    public Items(int qty, String description, int unitPrice) {
        this.qty = qty;
        this.description = description;
        this.unitPrice = unitPrice;
        this.amount = qty * unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getAmount() {
        return amount;
    }
}
