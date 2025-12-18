package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorRepository visitorRepository;

    public VisitorController(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id) {
        Optional<Visitor> visitor = visitorRepository.findById(id);
        return visitor.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
