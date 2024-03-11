package com.group.assignment.dto.request.thirdAssignment;

import java.time.LocalDate;

public class FruitCreateRequest {
    private String name;
    private LocalDate warehosuingDate;
    private long price;

    public FruitCreateRequest(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehosuingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehosuingDate() {
        return warehosuingDate;
    }

    public long getPrice() {
        return price;
    }
}
