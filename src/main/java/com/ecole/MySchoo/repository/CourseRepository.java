package com.ecole.MySchoo.repository;

import com.ecole.MySchoo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
