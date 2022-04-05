package com.ecole.MySchoo.service;

import com.ecole.MySchoo.dto.StudentResponseDto;
import com.ecole.MySchoo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(Long id);
    Student createStudent(StudentResponseDto studentResponseDto);
    Student updateStudent(Long id, StudentResponseDto studentResponseDto);
    void deleteStudent(Long id);
}
