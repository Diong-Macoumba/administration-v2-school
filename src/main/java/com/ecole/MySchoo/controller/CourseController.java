package com.ecole.MySchoo.controller;

import com.ecole.MySchoo.dto.CourseResponseDto;
import com.ecole.MySchoo.model.Course;
import com.ecole.MySchoo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping(path = "/Courses/All")
    public List<Course> getAllCourses(){
        return courseService.findAllCourse();
    }

    @GetMapping(path = "/CoursesByTeacher/{teacherId}")
    public List<Course> getCoursesByTeacher(@PathVariable Long teacherId){
        return courseService.findCoursesByTeacherId(teacherId);
    }
    @GetMapping(path = "/Courses/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.findCourseById(id);
    }

    @PostMapping(path = "/Courses")
    public Course create(@RequestBody CourseResponseDto courseResponseDto){
        return courseService.createCourse(courseResponseDto);
    }

    @PutMapping(path = "/Courses/{id}")
    public Course update(@PathVariable Long id, @RequestBody CourseResponseDto courseResponseDto){
        return courseService.updateCourse(id, courseResponseDto);
    }

    @DeleteMapping(path = "/Courses/{id}")
    public void delete(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
