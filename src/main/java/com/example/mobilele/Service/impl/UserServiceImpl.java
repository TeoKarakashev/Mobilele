package com.example.mobilele.Service.impl;

import com.example.mobilele.Model.Entities.UserEntity;
import com.example.mobilele.Model.Entities.UserRoleEntity;
import com.example.mobilele.Model.Enums.Role;
import com.example.mobilele.Service.UserService;
import com.example.mobilele.repositories.UserRepository;
import com.example.mobilele.security.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        if(userEntityOptional.isEmpty()){

            return false;
        }else{
                return passwordEncoder.matches(password, userEntityOptional.get().getPassword());
        }
    }

    @Override
    public void loginUser(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow();

        List<Role> userRoles = userEntity.getUserRoles().stream().map(UserRoleEntity::getRole).collect(Collectors.toList());

        currentUser.setAnonymous(false);
        currentUser.setName(userEntity.getUsername());
        currentUser.setUserRoles(userRoles);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }
}
