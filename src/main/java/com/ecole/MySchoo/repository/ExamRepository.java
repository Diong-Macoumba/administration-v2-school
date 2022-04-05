package com.ecole.MySchoo.repository;

import com.ecole.MySchoo.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Long> {
}
