package com.ecole.MySchoo.ServiceImpl;

import com.ecole.MySchoo.dto.TeacherResponseDto;
import com.ecole.MySchoo.model.Gender;
import com.ecole.MySchoo.model.Teacher;
import com.ecole.MySchoo.repository.TeacherRepository;
import com.ecole.MySchoo.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherById(Long id) {
        final Teacher teacher = teacherRepository.findById(id).get();
        return teacher;
    }

    @Override
    public Teacher createTeacher(TeacherResponseDto teacherResponseDto) {
        Teacher teacher =new Teacher();
        return getTeacher(teacherResponseDto, teacher);
    }

    private Teacher getTeacher(TeacherResponseDto teacherResponseDto, Teacher teacher) {
        teacher.setFirstName(teacherResponseDto.getFirstName());
        teacher.setLastName(teacherResponseDto.getLastName());
        teacher.setGender(Gender.valueOf(teacherResponseDto.getGender()));
        teacher.setAddress(teacherResponseDto.getAddress());
        teacher.setEmail(teacherResponseDto.getEmail());
        teacher.setPhone(teacherResponseDto.getPhone());
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, TeacherResponseDto teacherResponseDto) {
        Teacher teacher = teacherRepository.findById(id).get();
        return getTeacher(teacherResponseDto, teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
    teacherRepository.deleteById(id);
    }
}
