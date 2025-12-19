package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.time.*;
import java.util.*;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    List<VisitLog> findByVisitorId(Long visitorId);

    List<VisitLog> findByVisitorIdAndEntryTimeAfter(
            Long visitorId,
            LocalDateTime since
    );

    long countByVisitorIdAndEntryTimeBetween(
            Long visitorId,
            LocalDateTime start,
            LocalDateTime end
    );
}
