package com.example.onlineshopapi;

import com.example.onlineshopapi.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    // 1) GET all
    @GetMapping
    public List<Item> getAll() {
        return service.getAll();
    }

    // 2) GET by id
    @GetMapping("/{id}")
    public Item getById(@PathVariable Integer id) {
        return service.getById(id); // not found болса exception лақтырады
    }

    // 3) POST create
    @PostMapping
    public Item create(@RequestBody Item item) {
        return service.create(item);
    }

    // 4) PUT update
    @PutMapping("/{id}")
    public Item update(@PathVariable Integer id, @RequestBody Item newItem) {
        return service.update(id, newItem);
    }

    // 5) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}