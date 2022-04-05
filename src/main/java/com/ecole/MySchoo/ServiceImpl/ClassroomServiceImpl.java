package com.ecole.MySchoo.ServiceImpl;

import com.ecole.MySchoo.dto.ClassroomResponseDto;
import com.ecole.MySchoo.model.Classroom;
import com.ecole.MySchoo.model.Student;
import com.ecole.MySchoo.repository.ClassroomRepository;
import com.ecole.MySchoo.repository.StudentRepository;
import com.ecole.MySchoo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;
    @Autowired
    private StudentRepository studentRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<Classroom> findAllClassroom() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom findClassroomById(Long id) {
        return classroomRepository.findById(id).get();
    }

    @Override
    public Classroom createClassroom(ClassroomResponseDto classroomResponseDto) {
        Classroom classroom=new Classroom();
        classroom.setClassName(classroomResponseDto.getClassName());
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom updateClassroom(Long id, ClassroomResponseDto classroomResponseDto) {
        Classroom classroom =classroomRepository.findById(id).get();
        classroom.setClassName(classroomResponseDto.getClassName());
        return classroomRepository.save(classroom);
    }

    @Override
    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudentInClassroom(Long id) {
        return studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getClassroom().getId().equals(id))
                .collect(Collectors.toList());
    }
}
