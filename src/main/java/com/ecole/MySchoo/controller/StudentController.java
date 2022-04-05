package com.ecole.MySchoo.controller;

import com.ecole.MySchoo.dto.StudentResponseDto;
import com.ecole.MySchoo.model.Student;
import com.ecole.MySchoo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping(path = "/Students")
    public List<Student> getAllStudent(){
        return studentService.findAllStudents();
    }
    @GetMapping(path = "/Students/{id}")
    public Student GetStudentById(@PathVariable Long id){
        return this.studentService.findStudentById(id);
    }
    @PostMapping(path ="/Students")
    public Student create(@RequestBody StudentResponseDto studentResponseDto){
        return studentService.createStudent(studentResponseDto);
    }
    @PutMapping(path = "/Students/{id}")
    public Student update(@PathVariable Long id,@RequestBody StudentResponseDto studentResponseDto){
        return studentService.updateStudent(id,studentResponseDto);
    }
    @DeleteMapping(path = "/Students/{id}")
    public void delete(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
