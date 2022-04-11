package com.ecole.MySchoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class TeacherResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String gender;
}
