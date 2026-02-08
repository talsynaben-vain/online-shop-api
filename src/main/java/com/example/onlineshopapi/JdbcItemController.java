package com.example.onlineshopapi.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc/items")
public class JdbcItemController {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getAllItemsJdbc() {
        String sql = "SELECT * FROM shop_item";
        return jdbcTemplate.queryForList(sql);
    }
}
