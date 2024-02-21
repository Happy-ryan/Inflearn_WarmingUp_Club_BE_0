package com.group.assignment.controller.secondAssignment;

import com.group.assignment.dto.request.secondAssignment.NumberRequest;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SecondAssignmentController {
    // 문제 1번 - RequestParam 이용하기
    @GetMapping("/api/v1/calc")
    public Map<String, Integer> calculateTwoNumber(@RequestParam int num1, @RequestParam int num2) {
        Map<String, Integer> response = new HashMap<>();
        response.put("add", num1 + num2);
        response.put("minus", num1 - num2);
        response.put("multiply", num1 * num2);

        return response;
    }
    // 문제 3번 - DTO 이용하기
    @PostMapping("/api/v1/calc")
    public int calculateNumbers(@RequestBody NumberRequest request) {
        int response = 0;
        for (int num : request.getNumbers()) {
            response += num;
        }
        System.out.println(response);
        return response;
    }

    // 문제 2번 - LocalDate
    @GetMapping("api/v1/day-of-the-week")
    public Map<String, DayOfWeek> calculateDayOfWeek(@RequestParam String date) {
        Map<String, DayOfWeek> response = new HashMap<>();

        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        LocalDate request = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = request.getDayOfWeek();

        response.put("dayOfWeek", dayOfWeek);

        return response;
    }

}
