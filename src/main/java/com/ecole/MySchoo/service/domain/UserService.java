package com.ecole.MySchoo.service.domain;

import com.ecole.MySchoo.model.domain.Role;
import com.ecole.MySchoo.model.domain.User;

import java.util.List;

public interface UserService {

    User createUser (User user);
    Role saveRole( Role role );
    void addRoleToUser( String username, String role);
    User getUser( String username );
    List<User> getUsers();
}
