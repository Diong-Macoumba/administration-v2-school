package com.ecole.MySchoo.controller;

import com.ecole.MySchoo.dto.ClassroomResponseDto;
import com.ecole.MySchoo.model.Classroom;
import com.ecole.MySchoo.model.Student;
import com.ecole.MySchoo.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping(path = "/Classroom")
    public List<Classroom> getAllClassroom(){
        return classroomService.findAllClassroom();
    }

    @GetMapping(path = "/Classroom/{id}")
    public Classroom getClassroom(@PathVariable Long id){
        return classroomService.findClassroomById(id);
    }

    @PostMapping(path = "/Classroom")
    public Classroom create(@RequestBody ClassroomResponseDto classroomResponseDto){
        return classroomService.createClassroom(classroomResponseDto);
    }

    @GetMapping(path = "/Classroom/Students/{id}")
    public List<Student> getAllStudentByClassroomId(@PathVariable Long id){
        return classroomService.findAllStudentInClassroom(id);
    }

    @PutMapping(path = "/Classroom/{id}")
    public Classroom update(@PathVariable Long id, @RequestBody ClassroomResponseDto classroomResponseDto){
        return classroomService.updateClassroom(id, classroomResponseDto);
    }

    @DeleteMapping(path = "/Classroom/{id}")
    public void delete(@PathVariable Long id){
        this.classroomService.deleteClassroom(id);
    }
}
