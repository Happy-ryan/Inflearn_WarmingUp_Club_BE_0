package com.group.assignment.dto.request.thirdAssignment;

public class FruitUpdateRequest {
    private int id;
    private String status;

    public FruitUpdateRequest(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}
