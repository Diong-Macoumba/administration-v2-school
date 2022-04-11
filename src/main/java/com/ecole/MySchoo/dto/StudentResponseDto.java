package com.ecole.MySchoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data @AllArgsConstructor
public class StudentResponseDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String parentFirstName;
    private String parentLastName;
    private String parentPhone;
    private String address;
    private String gender;
    private Long classroomId;
}
