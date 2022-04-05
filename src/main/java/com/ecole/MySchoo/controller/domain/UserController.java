package com.ecole.MySchoo.controller.domain;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ecole.MySchoo.model.domain.Role;
import com.ecole.MySchoo.model.domain.User;
import com.ecole.MySchoo.service.domain.RoleToUser;
import com.ecole.MySchoo.service.domain.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;


    @GetMapping("/users/all")
    ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/save")
    ResponseEntity<User> saveUser(@RequestBody User user) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/save").toUriString());
    return ResponseEntity.created(uri).body(userService.createUser(user));
    }

    @PostMapping("/users/role/save")
    ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/users/addRole")
    ResponseEntity<?> saveRole(@RequestBody RoleToUser roleToUser) {
        userService.addRoleToUser(roleToUser.getUsername(), roleToUser.getRolename());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/{username}")
    ResponseEntity<User> getUserByName(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String autorization = request.getHeader(AUTHORIZATION);
        if (autorization != null && autorization.startsWith("Bearer ")) {

            try {
                String refresh_token = autorization.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("3é#&_-gSecERt==)9".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date( System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURI())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);


            } catch ( Exception exception) {
                response.setHeader("error", exception.getMessage());
                log.info("Erreur connection : {}", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        } else  {
            log.info("pas de refresh token");
            throw new RuntimeException("pas de refresh token");
        }
    }
}


