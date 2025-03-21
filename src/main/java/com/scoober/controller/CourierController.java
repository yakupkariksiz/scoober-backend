package com.scoober.controller;

import com.scoober.model.Courier;
import com.scoober.repository.CourierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/couriers")
public class CourierController {

    private final CourierRepository repository;

    public CourierController(CourierRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Courier create(@RequestBody Courier courier) {
        return repository.save(courier);
    }

    @GetMapping
    public List<Courier> getAll() {
        return repository.findAll();
    }
}
