package com.ecole.MySchoo.service;

import com.ecole.MySchoo.dto.TeacherResponseDto;
import com.ecole.MySchoo.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAllTeachers();
    Teacher findTeacherById(Long id);
    Teacher createTeacher(TeacherResponseDto teacherResponseDto);
    Teacher updateTeacher(Long id, TeacherResponseDto teacherResponseDto);
    void deleteTeacher(Long id);
}
