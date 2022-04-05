package com.ecole.MySchoo.ServiceImpl;

import com.ecole.MySchoo.dto.ExamResponseDto;
import com.ecole.MySchoo.model.Course;
import com.ecole.MySchoo.model.Exam;
import com.ecole.MySchoo.model.ExamType;
import com.ecole.MySchoo.model.Student;
import com.ecole.MySchoo.repository.CourseRepository;
import com.ecole.MySchoo.repository.ExamRepository;
import com.ecole.MySchoo.repository.StudentRepository;
import com.ecole.MySchoo.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public List<Exam> findAllExamByStudentAndCourse(Long studentId, Long courseId) {
        return examRepository
                .findAll()
                .stream()
                .filter(exam -> exam.getCourse().getId().equals(courseId))
                .filter(exam -> exam.getStudent().getId().equals(studentId))
                .collect(Collectors.toList());
    }

    @Override
    public Exam createExam(ExamResponseDto examResponseDto) {
        Student student = studentRepository.getById(examResponseDto.getStudentId());
        Course course = courseRepository.getById(examResponseDto.getCourseId());
        Exam exam=new Exam();
        exam.setStudent(student);
        exam.setCourse(course);
        exam.setExamType(ExamType.valueOf(examResponseDto.getExamType()));
        exam.setExamDate(examResponseDto.getExamDate());
        exam.setMark(examResponseDto.getMark());
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Long id, ExamResponseDto examResponseDto) {
        Exam exam = examRepository.getById(id);
        exam.setMark(examResponseDto.getMark());
        exam.setExamDate(examResponseDto.getExamDate());
        exam.setExamType(ExamType.valueOf(examResponseDto.getExamType()));
        return examRepository.save(exam);
    }

    @Override
    public void delete(Long id) {
        examRepository.deleteById(id);
    }
}
