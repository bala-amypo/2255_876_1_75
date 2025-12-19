package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService auditLogService;

    public ScoreAuditLogController(ScoreAuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<ScoreAuditLog> logScoreChange(
            @PathVariable Long visitorId,
            @PathVariable Long ruleId,
            @RequestBody ScoreAuditLog log) {
        ScoreAuditLog savedLog = auditLogService.logScoreChange(visitorId, ruleId, log);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLog);
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> getLogsByVisitor(@PathVariable Long visitorId) {
        List<ScoreAuditLog> logs = auditLogService.getLogsByVisitor(visitorId);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreAuditLog> getLog(@PathVariable Long id) {
        ScoreAuditLog log = auditLogService.getLog(id);
        return ResponseEntity.ok(log);
    }
}
