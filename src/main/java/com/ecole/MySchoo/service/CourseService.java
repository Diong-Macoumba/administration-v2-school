package com.ecole.MySchoo.service;

import com.ecole.MySchoo.dto.CourseResponseDto;
import com.ecole.MySchoo.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    Course findCourseById(Long id);
    Course createCourse(CourseResponseDto courseResponseDto);
    Course updateCourse(Long id, CourseResponseDto courseResponseDto);
    void deleteCourse(Long id);
    List<Course> findCoursesByTeacherId(Long teacherId);
}
