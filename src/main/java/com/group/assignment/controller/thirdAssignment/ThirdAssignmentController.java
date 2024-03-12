package com.group.assignment.controller.thirdAssignment;

import com.group.assignment.dto.request.thirdAssignment.FruitCreateRequest;
import com.group.assignment.dto.request.thirdAssignment.FruitUpdateRequest;
import com.group.assignment.dto.response.SalesAmountResponse;
import com.group.assignment.dto.response.StatusAndAmountResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ThirdAssignmentController {

    private final JdbcTemplate jdbcTemplate;

    public ThirdAssignmentController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        String sql = "insert into fruit (name, warehousingDate, price, status) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehosuingDate(), request.getPrice(), "NOT SELL");

    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request) {

        String sql = "update fruit set status=? where id=?";
        jdbcTemplate.update(sql, request.getStatus(), request.getId());
    }

    @GetMapping("api/v1/fruit/stat")
    public SalesAmountResponse getSalesAndNonSalesAmount(@RequestParam String name) {
        String readSql = "select status, sum(price) as PRICE from fruit where name=? group by status";
        List<StatusAndAmountResponse> result = jdbcTemplate.query(readSql, new Object[]{name}, new RowMapper<StatusAndAmountResponse>() {
            @Override
            public StatusAndAmountResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                String status = rs.getString("status");
                long price = rs.getLong("PRICE");
                return new StatusAndAmountResponse(status, price);
            }
        });

        Map<String, Long> salesAmount = new HashMap<>();
        for (StatusAndAmountResponse response : result) {
            salesAmount.put(response.getStatus(), response.getAmount());
        }
        SalesAmountResponse response = new SalesAmountResponse(salesAmount.getOrDefault("SELL", 0L), salesAmount.getOrDefault("NOT SELL", 0L));

        return response;

    }

}
