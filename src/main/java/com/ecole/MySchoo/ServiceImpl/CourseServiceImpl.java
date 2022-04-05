package com.ecole.MySchoo.ServiceImpl;

import com.ecole.MySchoo.dto.CourseResponseDto;
import com.ecole.MySchoo.model.Course;
import com.ecole.MySchoo.model.Teacher;
import com.ecole.MySchoo.repository.CourseRepository;
import com.ecole.MySchoo.repository.TeacherRepository;
import com.ecole.MySchoo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course createCourse(CourseResponseDto courseResponseDto) {
        Teacher teacher=teacherRepository.findById(courseResponseDto.getTeacherId()).get();
        Course course = new Course();
        course.setTitle(courseResponseDto.getTitle());
        course.setYear(courseResponseDto.getYear());
        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, CourseResponseDto courseResponseDto) {
        Teacher teacher=teacherRepository.findById(courseResponseDto.getTeacherId()).get();
        Course course=courseRepository.getById(id);
        course.setTeacher(teacher);
        course.setTitle(courseResponseDto.getTitle());
        course.setYear(courseResponseDto.getYear());
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findCoursesByTeacherId(Long teacherId) {
        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getTeacher().getId().equals(teacherId))
                .collect(Collectors.toList());
    }

}
