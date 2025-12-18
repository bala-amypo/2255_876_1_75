package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/{visitorId}")
    public VisitLog createVisitLog(@PathVariable Long visitorId, @RequestBody VisitLog log) {
        return visitLogService.createVisitLog(visitorId, log);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<VisitLog> getLogsByVisitor(@PathVariable Long visitorId) {
        return visitLogService.getLogsByVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public VisitLog getLog(@PathVariable Long id) {
        return visitLogService.getLog(id);
    }
}
