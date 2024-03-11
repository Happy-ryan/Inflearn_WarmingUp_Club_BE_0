package com.group.assignment.controller.thirdAssignment;

import com.group.assignment.dto.request.thirdAssignment.FruitCreateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdAssignmentController {

    private final JdbcTemplate jdbcTemplate;

    public ThirdAssignmentController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        String sql = "insert into fruit (name, warehousingDate, price) values (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehosuingDate(), request.getPrice());

    }
}
