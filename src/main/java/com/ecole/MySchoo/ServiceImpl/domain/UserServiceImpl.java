package com.ecole.MySchoo.ServiceImpl.domain;

import com.ecole.MySchoo.model.domain.Role;
import com.ecole.MySchoo.model.domain.User;
import com.ecole.MySchoo.repository.domain.RoleRepository;
import com.ecole.MySchoo.repository.domain.UserRepository;
import com.ecole.MySchoo.service.domain.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null ) {
            log.info("L'utilisateur n'existe pas");
            throw new UsernameNotFoundException("L'utilisateur n'existe pas");
        } else {
            log.info("l'utilisateur {} existe", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach( role -> {
            authorities.add( new SimpleGrantedAuthority( role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User createUser(User user) {
        final User userExisting = userRepository.findByUsername(user.getUsername());
        if (userExisting == null ) {
            log.info("Enregistrement du nouvel utitlisateur");
            user.setPassword(encoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("L'utilisateur existe deja");
        }

    }

    @Override
    public Role saveRole(Role role) {

        final Role roleExisting = roleRepository.findByName(role.getName());
        if(roleExisting == null ) {
            log.info("Enregistrement du nouvel role");
            return roleRepository.save(role);
        } else {
            throw new IllegalArgumentException("Le role existe deja");
        }
    }

    @Override
    public void addRoleToUser(String username, String name) {
        final User userExisting = userRepository.findByUsername(username);
        final Role roleExisting = roleRepository.findByName(name);
        log.info("L'ajout du role {} pour l'utilisateur {} ", name, username);
        userExisting.getRoles().add(roleExisting);
    }

    @Override
    public User getUser(String username) {
        log.info("Recuperation de l'utitlisateur {} ", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Recuperation des utitlisateurs ");
        return userRepository.findAll();
    }


}
