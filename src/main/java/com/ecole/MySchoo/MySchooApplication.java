package com.ecole.MySchoo;

import com.ecole.MySchoo.model.domain.Role;
import com.ecole.MySchoo.model.domain.User;
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
	CommandLineRunner run(UserService userService) {
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


		};
	}

}
