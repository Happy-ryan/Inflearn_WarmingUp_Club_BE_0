package com.group.assignment.dto.response;

public class StatusAndAmountResponse {
    private String status;
    private long amount;

    public StatusAndAmountResponse(String status, long amount) {
        this.status = status;
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public long getAmount() {
        return amount;
    }
}
