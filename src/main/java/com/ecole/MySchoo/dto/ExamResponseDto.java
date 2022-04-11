package com.ecole.MySchoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class ExamResponseDto {
    private LocalDate examDate;
    private Long courseId;
    private Long studentId;
    private double mark;
    private String examType;

}
