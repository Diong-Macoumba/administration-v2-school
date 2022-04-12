package com.ecole.MySchoo;

import com.ecole.MySchoo.model.*;
import com.ecole.MySchoo.model.domain.Role;
import com.ecole.MySchoo.model.domain.User;
import com.ecole.MySchoo.repository.*;
import com.ecole.MySchoo.service.domain.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MySchooApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySchooApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, ClassroomRepository classroomRepository, CourseRepository courseRepository, ExamRepository examRepository, RoomRepository roomRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
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
			userService.addRoleToUser("mac30", "ADMIN");
			userService.addRoleToUser("Wa12", "ADMIN");
			userService.addRoleToUser("Dev322", "ADMIN");
			userService.addRoleToUser("Ci21de", "ADMIN");
			userService.addRoleToUser("Dom159", "ADMIN");


			Classroom l1 = classroomRepository.save(new Classroom(null,"L1"));
			Classroom l2 = classroomRepository.save(new Classroom(null,"L2"));
			Classroom l3 = classroomRepository.save(new Classroom(null,"L3"));
			Classroom m1 = classroomRepository.save(new Classroom(null,"L4"));
			Classroom m2 = classroomRepository.save(new Classroom(null,"L5"));

			Teacher teacher1 = teacherRepository.save(new Teacher(null, "Franc", "Albert", "franc@school.fr", "004411122", "Patte d'oie", Gender.MAN));
			Teacher teacher2 = teacherRepository.save(new Teacher(null, "Marc", "Misky", "marc@school.fr", "005558877", "Paris", Gender.MAN));
			Teacher teacher3 = teacherRepository.save(new Teacher(null, "Ousmane", "Ndiaye", "ndiaye@school.fr", "009995511", "Dakar", Gender.MAN));
			Teacher teacher4 = teacherRepository.save(new Teacher(null, "Amy", "Fall", "amy@school.fr", "005588744", "Dakar", Gender.WOMAN));
			Teacher teacher5 = teacherRepository.save(new Teacher(null, "Khady", "Coly", "khady@school.fr", "003332266", "Dakar", Gender.WOMAN));

			Course course1 = courseRepository.save( Course.builder().id(null).title("Francais").teacher(teacher1).build());
			Course course2 = courseRepository.save( Course.builder().id(null).title("Maths").teacher(teacher2).build());
			Course course3 = courseRepository.save( Course.builder().id(null).title("Forensic").teacher(teacher3).build());
			Course course4 = courseRepository.save( Course.builder().id(null).title("Crypto").teacher(teacher4).build());
			Course course5 = courseRepository.save( Course.builder().id(null).title("Securité").teacher(teacher5).build());

			Student student1 = studentRepository.save(Student.builder().id(null).firstName("Ahmeth").lastName("Gueye").parentFirstName("Omar").parentLastName("Amina").parentPhone("001745986").address( "Yoff").gender(Gender.MAN).build());
			Student student2 = studentRepository.save(Student.builder().id(null).firstName("Omar").lastName("Sall").parentFirstName("Assane").parentLastName("Aicha").parentPhone("001475625").address( "Dakar").gender(Gender.MAN).build());
			Student student3 = studentRepository.save(Student.builder().id(null).firstName("Ahmeth").lastName("Gueye").parentFirstName("Omar").parentLastName("Amina").parentPhone("001745986").address( "Medina").gender(Gender.MAN).build());
			Student student4 = studentRepository.save(Student.builder().id(null).firstName("Ahmeth").lastName("Gueye").parentFirstName("Omar").parentLastName("Khady").parentPhone("001745986").address( "Yoff").gender(Gender.MAN).build());
			Student student5 = studentRepository.save(Student.builder().id(null).firstName("Ahmeth").lastName("Wade").parentFirstName("Omar").parentLastName("Amina").parentPhone("001745986").address( "Yoff").gender(Gender.MAN).build());
			Student student6 = studentRepository.save(Student.builder().id(null).firstName("Ahmeth").lastName("Gueye").parentFirstName("Omar").parentLastName("Amina").parentPhone("001745986").address( "Yoff").gender(Gender.MAN).build());
			Student student7 = studentRepository.save(Student.builder().id(null).firstName("Ahmeth").lastName("Gueye").parentFirstName("Omar").parentLastName("Amina").parentPhone("001745986").address( "Yoff").gender(Gender.MAN).build());
			Student student8 = studentRepository.save(Student.builder().id(null).firstName("Ahmeth").lastName("Gueye").parentFirstName("Omar").parentLastName("Amina").parentPhone("001745986").address( "Yoff").gender(Gender.MAN).build());

			examRepository.save( Exam.builder().id(null).student(student1).course(course1).mark(15).examType(ExamType.EXAM).build());
			examRepository.save( Exam.builder().id(null).student(student2).course(course1).mark(12).examType(ExamType.EXAM).build());
			examRepository.save( Exam.builder().id(null).student(student3).course(course2).mark(13).examType(ExamType.DEVOIR).build());
			examRepository.save( Exam.builder().id(null).student(student3).course(course3).mark(14).examType(ExamType.DEVOIR).build());
			examRepository.save( Exam.builder().id(null).student(student5).course(course4).mark(19).examType(ExamType.TPE).build());
			examRepository.save( Exam.builder().id(null).student(student1).course(course5).mark(16).examType(ExamType.TPE).build());

			roomRepository.save(new Room(null, 1));
			roomRepository.save(new Room(null, 2));
			roomRepository.save(new Room(null, 3));
			roomRepository.save(new Room(null, 4));
			roomRepository.save(new Room(null, 5));


		};
	}

}
