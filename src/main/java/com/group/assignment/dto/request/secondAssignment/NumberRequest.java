package com.group.assignment.dto.request.secondAssignment;

import java.util.List;

public class NumberRequest {
    private List<Integer> numbers;

    // 왜 기본 생성자 추가해야하는거야?
    public NumberRequest() {
    }

    public NumberRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

