package com.ecole.MySchoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CourseResponseDto {

    private String title;
    private int year;
    private Long teacherId;

}
