package com.ecole.MySchoo.controller;

import com.ecole.MySchoo.dto.TeacherResponseDto;
import com.ecole.MySchoo.model.Teacher;
import com.ecole.MySchoo.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping(path = "/Teachers")
    public List<Teacher> getAllTeacher(){
        return teacherService.findAllTeachers();
    }
    @GetMapping(path = "/Teachers/{id}")
    public Teacher getTeacher(@PathVariable Long id){
        return this.teacherService.findTeacherById(id);
    }
    @PostMapping(path = "/Teachers")
    public Teacher create(@RequestBody TeacherResponseDto teacherResponseDto){
        return teacherService.createTeacher(teacherResponseDto);
    }
    @PutMapping(path = "/Teachers/{id}")
    public Teacher update(@PathVariable Long id, @RequestBody TeacherResponseDto teacherResponseDto){
        return this.teacherService.updateTeacher(id, teacherResponseDto);
    }
    @DeleteMapping(path = "/Teachers/{id}")
    public void delete(@PathVariable Long id){
         this.teacherService.deleteTeacher(id);
    }

}
