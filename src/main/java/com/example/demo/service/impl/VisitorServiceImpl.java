package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.*;
import java.util.*;

@Service
public class VisitorServiceImpl implements Visitor{

    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id).orElse(null);
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
