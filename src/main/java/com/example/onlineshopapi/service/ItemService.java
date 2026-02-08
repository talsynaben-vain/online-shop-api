package com.example.onlineshopapi.service;

import com.example.onlineshopapi.Item;
import com.example.onlineshopapi.ItemRepository;
import com.example.onlineshopapi.exception.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    // 1) GET all
    public List<Item> getAll() {
        return repo.findAll();
    }

    // 2) GET by id (exception with ItemNotFoundException)
    public Item getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    // 3) POST create
    public Item create(Item item) {
        item.setId(null); // жаңа item болғандықтан id жоқ
        return repo.save(item);
    }

    // 4) PUT update
    public Item update(Integer id, Item newItem) {
        Item old = getById(id); // табылмаса exception лақтырады

        old.setName(newItem.getName());
        old.setPrice(newItem.getPrice());
        old.setQuantity(newItem.getQuantity());

        return repo.save(old);
    }

    // 5) DELETE
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new ItemNotFoundException(id);
        }
        repo.deleteById(id);
    }
}