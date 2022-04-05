package com.ecole.MySchoo.repository.domain;

import com.ecole.MySchoo.model.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName( String name);
}
