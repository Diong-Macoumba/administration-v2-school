package com.ecole.MySchoo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamResponseDto {
    private LocalDate examDate;
    private Long courseId;
    private Long studentId;
    private double mark;
    private String examType;

}
