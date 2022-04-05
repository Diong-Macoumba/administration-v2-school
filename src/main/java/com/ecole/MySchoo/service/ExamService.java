package com.ecole.MySchoo.service;

import com.ecole.MySchoo.dto.ExamResponseDto;
import com.ecole.MySchoo.model.Exam;

import java.util.List;

public interface ExamService {
    List<Exam> findAllExamByStudentAndCourse(Long studentId, Long courseId);
    Exam createExam(ExamResponseDto examResponseDto);
    Exam updateExam(Long id, ExamResponseDto examResponseDto);
    void delete(Long id);
}
