package com.group.assignment.dto.response;

public class SalesAmountResponse {
    private long salesAmount;
    private long notSalesAmount;
    public SalesAmountResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
