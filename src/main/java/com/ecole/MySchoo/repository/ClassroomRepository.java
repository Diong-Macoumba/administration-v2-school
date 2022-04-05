package com.ecole.MySchoo.repository;

import com.ecole.MySchoo.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
