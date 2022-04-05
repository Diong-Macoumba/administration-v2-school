package com.ecole.MySchoo.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;


@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table( name = "user_school")
public class User {

    @Id @GeneratedValue( strategy = AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    @ManyToMany( fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
