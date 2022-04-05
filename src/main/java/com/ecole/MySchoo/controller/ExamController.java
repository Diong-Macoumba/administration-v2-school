package com.ecole.MySchoo.controller;

import com.ecole.MySchoo.dto.ExamResponseDto;
import com.ecole.MySchoo.model.Exam;
import com.ecole.MySchoo.service.ExamService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping(path = "/Exams/students/{studentId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Exam> getAllExam(@PathVariable Long studentId, @RequestBody Long courseId){
        return examService.findAllExamByStudentAndCourse(studentId,courseId);
    }

    @PostMapping(path = "/exams")
    public Exam createExam(@RequestBody ExamResponseDto examResponseDto){
        return examService.createExam(examResponseDto);
    }

}
