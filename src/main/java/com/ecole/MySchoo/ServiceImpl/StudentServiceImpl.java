package com.ecole.MySchoo.ServiceImpl;

import com.ecole.MySchoo.dto.StudentResponseDto;
import com.ecole.MySchoo.model.Classroom;
import com.ecole.MySchoo.model.Gender;
import com.ecole.MySchoo.model.Student;
import com.ecole.MySchoo.repository.ClassroomRepository;
import com.ecole.MySchoo.repository.StudentRepository;
import com.ecole.MySchoo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long id) {
        return this.studentRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Student createStudent(StudentResponseDto studentResponseDto) {
        Classroom classroom=classroomRepository.getById(studentResponseDto.getClassroomId());
        Student student=new Student();
        student.setAddress(studentResponseDto.getAddress());
        student.setClassroom(classroom);
        student.setFirstName(studentResponseDto.getFirstName());
        student.setLastName(studentResponseDto.getLastName());
        student.setParentFirstName(studentResponseDto.getParentFirstName());
        student.setParentLastName(studentResponseDto.getParentLastName());
        student.setDateOfBirth(studentResponseDto.getDateOfBirth());
        student.setGender(Gender.valueOf(studentResponseDto.getGender()));
        student.setParentPhone(studentResponseDto.getParentPhone());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, StudentResponseDto studentResponseDto) {
        Classroom classroom= classroomRepository.getById(studentResponseDto.getClassroomId());
        Student student=studentRepository.getById(id);
        student.setAddress(studentResponseDto.getAddress());
        student.setClassroom(classroom);
        student.setFirstName(studentResponseDto.getFirstName());
        student.setLastName(studentResponseDto.getLastName());
        student.setParentFirstName(studentResponseDto.getParentFirstName());
        student.setParentLastName(studentResponseDto.getParentLastName());
        student.setDateOfBirth(studentResponseDto.getDateOfBirth());
        student.setGender(Gender.valueOf(studentResponseDto.getGender()));
        student.setParentPhone(studentResponseDto.getParentPhone());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
