package com.ecole.MySchoo.repository;

import com.ecole.MySchoo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
