package com.ecole.MySchoo.repository;

import com.ecole.MySchoo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
