package com.acme.sales.domain.model.aggregates;

import com.acme.shared.domain.model.valueobjects.Address;

import java.util.List;
import java.util.UUID;

public class SalesOrder {
    public UUID getInternalId() {
        return internalId;
    }

    private final UUID internalId;

    public String getShippingAddress() {
        return shippingAddress.getAddressAsString();
    }

    private final Address shippingAddress;

    private SalesOrderStatus status;

    private List<SalesOrderItem> items;


    public SalesOrder(Address shippingAddress) {
        this.internalId = UUID.randomUUID();
        this.shippingAddress = shippingAddress;
        this.status = SalesOrderStatus.CREATED;
    }

    public void cancel() {
        this.status = SalesOrderStatus.CANCELLED;
    }

    public void addItem(int quantity, double unitPrice, Long productId) {
        this.items.add(new SalesOrderItem(quantity, productId, unitPrice));
    }
}
