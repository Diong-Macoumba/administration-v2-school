package com.ecole.MySchoo;

import com.ecole.MySchoo.dto.*;
import com.ecole.MySchoo.model.Classroom;
import com.ecole.MySchoo.model.Course;
import com.ecole.MySchoo.model.Student;
import com.ecole.MySchoo.model.Teacher;
import com.ecole.MySchoo.model.domain.Role;
import com.ecole.MySchoo.model.domain.User;
import com.ecole.MySchoo.service.*;
import com.ecole.MySchoo.service.domain.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class MySchooApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySchooApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, ClassroomService classroomService, CourseService courseService, ExamService examService, RoomService roomService, TeacherService teacherService, StudentService studentService) {
		return args -> {
			userService.saveRole(new Role( null, "ADMIN"));
			userService.saveRole(new Role( null, "USER_SIMPLE"));
			userService.saveRole(new Role( null, "SUPER_ADMIN"));
			userService.saveRole(new Role( null, "MANAGER"));

			userService.createUser( new User( null, "Zap", "Host", "zap12", "zap123", new ArrayList<>()));
			userService.createUser( new User( null, "Ass", "Diong", "mac30", "Mac123", new ArrayList<>()));
			userService.createUser( new User( null, "Waze", "Saze", "Wa12", "Zac123", new ArrayList<>()));
			userService.createUser( new User( null, "Dev", "Sawz", "Dev322", "Mac123", new ArrayList<>()));
			userService.createUser( new User( null, "Cide", "Queye", "Ci21de", "Zac123", new ArrayList<>()));
			userService.createUser( new User( null, "Domin", "Deven", "Dom159", "Mac123", new ArrayList<>()));

			userService.addRoleToUser("zap12", "ADMIN");
			userService.addRoleToUser("mac30", "MANAGER");
			userService.addRoleToUser("Wa12", "MANAGER");
			userService.addRoleToUser("Dev322", "SUPER_ADMIN");
			userService.addRoleToUser("Ci21de", "USER_SIMPLE");
			userService.addRoleToUser("Dom159", "ADMIN");

			Classroom l1 = classroomService.createClassroom(new ClassroomResponseDto("L1"));
			Classroom l2 = classroomService.createClassroom( new ClassroomResponseDto("L2"));
			Classroom l3 = classroomService.createClassroom( new ClassroomResponseDto("L3"));
			Classroom m1 = classroomService.createClassroom( new ClassroomResponseDto("M1"));
			Classroom m2 = classroomService.createClassroom( new ClassroomResponseDto("M2"));


			Teacher teacher1 = teacherService.createTeacher(new TeacherResponseDto("Franc", "Albert", "franc@school.fr", "004411122", "Patte d'oie", "MALE"));
			Teacher teacher2 = teacherService.createTeacher(new TeacherResponseDto("Marc", "Misky", "marc@school.fr", "005558877", "Paris", "MALE"));
			Teacher teacher3 = teacherService.createTeacher(new TeacherResponseDto("Ousmane", "Ndiaye", "ndiaye@school.fr", "009995511", "Dakar", "MALE"));
			Teacher teacher4 = teacherService.createTeacher(new TeacherResponseDto("Amy", "Fall", "amy@school.fr", "005588744", "Dakar", "FEMALE"));
			Teacher teacher5 = teacherService.createTeacher(new TeacherResponseDto("Khady", "Coly", "khady@school.fr", "003332266", "Dakar", "FEMALE"));

			Course course1 = courseService.createCourse(new CourseResponseDto("Francais", 2022, teacher1.getId()));
			Course course2 =courseService.createCourse( new CourseResponseDto("Maths",2022, teacher2.getId()));
			Course course3 =courseService.createCourse( new CourseResponseDto("Crypto",2022, teacher3.getId()));
			Course course4 =courseService.createCourse( new CourseResponseDto("Forensic",2022, teacher4.getId()));
			Course course5 =courseService.createCourse( new CourseResponseDto("Réseau",2022, teacher5.getId()));

			Student student1 = studentService.createStudent(new StudentResponseDto("Ahmeth", "Gueye", LocalDate.now(), "Omar", "Amina", "001745986", "Yoff", "MALE", l1.getId()));
			Student student2 = studentService.createStudent( new StudentResponseDto("Omar", "Sall", LocalDate.now(),"Assane", "Aicha","001475625","Dakar","MALE", l2.getId()));
			Student student3 = studentService.createStudent( new StudentResponseDto("Khadim", "Fall", LocalDate.now(),"Elimane", "Amy","001745986","Medina","MALE", l1.getId()));
			Student student4 = studentService.createStudent( new StudentResponseDto("Makhtar", "Ndiaye", LocalDate.now(),"Alassane", "Khady","001574866","Keur Massar","MALE", l3.getId()));
			Student student5 = studentService.createStudent( new StudentResponseDto("Assane", "Wade", LocalDate.now(),"Khadim", "Sokhna","002322145","PA","MALE", m1.getId()));
			Student student6 = studentService.createStudent( new StudentResponseDto("Adama", "Touré", LocalDate.now(),"Alassane", "Amina","003698541","Colobane","FEMALE", m2.getId()));
			Student student7 = studentService.createStudent( new StudentResponseDto("Elimane", "Mané", LocalDate.now(),"Ahmeth", "Maty","002698532","Bargny","MALE", m1.getId()));
			Student student8 = studentService.createStudent( new StudentResponseDto("Aicha", "Diop", LocalDate.now(),"Makhtar", "Adama","001478965","Yoff","FEMALE", l3.getId()));

			examService.createExam( new ExamResponseDto(LocalDate.now(),course1.getId(), student1.getId(),14,"Devoir"));
			examService.createExam( new ExamResponseDto(LocalDate.now(),course2.getId(), student2.getId(),14,"TD"));
			examService.createExam( new ExamResponseDto(LocalDate.now(),course3.getId(), student3.getId(),14,"TD"));
			examService.createExam( new ExamResponseDto(LocalDate.now(),course4.getId(), student4.getId(),14,"TD"));
			examService.createExam( new ExamResponseDto(LocalDate.now(),course5.getId(), student5.getId(),14,"Devoir"));
			examService.createExam( new ExamResponseDto(LocalDate.now(),course1.getId(), student6.getId(),14,"Devoir"));
			examService.createExam( new ExamResponseDto(LocalDate.now(),course5.getId(), student7.getId(),14,"TD"));
			examService.createExam( new ExamResponseDto(LocalDate.now(),course4.getId(), student8.getId(),14,"Devoir"));

			roomService.createRoom( new RoomResponseDto(1));
			roomService.createRoom( new RoomResponseDto(2));
			roomService.createRoom( new RoomResponseDto(3));
			roomService.createRoom( new RoomResponseDto(4));
			roomService.createRoom( new RoomResponseDto(5));

		};
	}

}
