package com.nelio.udemy.project.entities.enumns;

public enum OrderStatus {

    WAITING_PAYMENT(0),
    PAID(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static OrderStatus fromInt(int code) {

        for(var status : OrderStatus.values()) {
            if(status.getCode() == code) return status;
        }

        throw new IllegalArgumentException("Order code is invalid !");
    }
}
