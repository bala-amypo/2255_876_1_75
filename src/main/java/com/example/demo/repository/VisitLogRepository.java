package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.VisitLog;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog,Long>{

}
