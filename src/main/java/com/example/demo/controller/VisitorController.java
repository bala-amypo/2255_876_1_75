package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public Visitor create(@RequestBody Visitor visitor) {
        return visitorService.createVisitor(visitor);
    }

    @GetMapping
    public List<Visitor> all() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("/{id}")
    public Visitor get(@PathVariable Long id) {
        return visitorService.getVisitor(id);
    }
}
