package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.util.RiskLevelUtils;


@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository riskRulerRepository;

    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,
                                VisitorRepository visitorRepository,
                                RiskRuleRepository riskRulerRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.visitorRepository = visitorRepository;
        this.riskRuleRepository = riskRulerRepository;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        Optional<RiskScore> existing = riskScoreRepository.findByVisitorId(visitorId);
        if (existing.isPresent()) {
            return existing.get();
        }

        int scoreValue = 50;

        RiskScore score = new RiskScore();
        score.setVisitor(visitor);
        score.setTotalScore(scoreValue);
        score.setRiskLevel(RiskLevelUtils.determineRiskLevel(scoreValue));
        RiskRule appliedRule = riskRuleRepository.findById(ruleId)
            .orElseThrow(() -> new ResourceNotFoundException("RiskRule not found"));
        score.setRiskRule(appliedRule);

        return riskScoreRepository.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId).orElse(null);
    }

    @Override
    public List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
