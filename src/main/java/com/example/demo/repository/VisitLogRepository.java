package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    @Query("SELECT v FROM VisitLog v WHERE v.visitor.id = :visitorId AND v.entryTime >= :since")
    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);

    @Query("SELECT COUNT(v) FROM VisitLog v WHERE v.visitor.id = :visitorId AND v.entryTime >= :start AND v.exitTime <= :end")
    long countVisitsInWindow(Long visitorId, LocalDateTime start, LocalDateTime end);
}
