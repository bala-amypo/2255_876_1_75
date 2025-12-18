package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    private final ScoreAuditLogRepository auditLogRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository ruleRepository;

    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository auditLogRepository,
                                    VisitorRepository visitorRepository,
                                    RiskRuleRepository ruleRepository) {
        this.auditLogRepository = auditLogRepository;
        this.visitorRepository = visitorRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        RiskRule rule = ruleRepository.findById(ruleId)
                .orElseThrow(() -> new RuntimeException("Rule not found"));

        log.setVisitor(visitor);
        log.setRule(rule);

        return auditLogRepository.save(log);
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return auditLogRepository.findByVisitorId(visitorId);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return auditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Audit log not found"));
    }
}
