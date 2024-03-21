package com.acme.sales.domain.model.aggregates;

import java.util.UUID;

public class SalesOrderItem {
    private UUID itemId;

    private int quantity;

    private Long productId;

    private double unitPrice;

    private boolean dispatched;


    public SalesOrderItem(int quantity, Long productId, double unitPrice) {
        this.itemId = UUID.randomUUID();
        this.quantity = quantity;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.dispatched = false;
    }

    public double calculatePrice() {
        return unitPrice*quantity;
    }

    public boolean isDispatched() {
        return dispatched;
    }

    public void dispatch() {
        dispatched = true;
    }
}
