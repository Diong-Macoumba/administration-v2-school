package com.ecole.MySchoo.service;

import com.ecole.MySchoo.dto.ClassroomResponseDto;
import com.ecole.MySchoo.model.Classroom;
import com.ecole.MySchoo.model.Student;

import java.util.List;

public interface ClassroomService {
    List<Classroom> findAllClassroom();
    Classroom findClassroomById(Long id);
    Classroom createClassroom(ClassroomResponseDto classroomResponseDto);
    Classroom updateClassroom(Long id,ClassroomResponseDto classroomResponseDto);
    void deleteClassroom(Long id);
    List<Student> findAllStudentInClassroom(Long id);
}
