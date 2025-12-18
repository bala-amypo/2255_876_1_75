package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
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
    public ScoreAuditLog logScoreChange(@PathVariable Long visitorId,
                                        @PathVariable Long ruleId,
                                        @RequestBody ScoreAuditLog log) {
        return auditLogService.logScoreChange(visitorId, ruleId, log);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<ScoreAuditLog> getLogsByVisitor(@PathVariable Long visitorId) {
        return auditLogService.getLogsByVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public ScoreAuditLog getLog(@PathVariable Long id) {
        return auditLogService.getLog(id);
    }
}
