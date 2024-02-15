package com.wildcodeschool.webook.auth.domain.service;

import com.wildcodeschool.webook.auth.domain.dto.UserDTO;
import com.wildcodeschool.webook.auth.domain.entity.User;
import com.wildcodeschool.webook.auth.infrastructure.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    private UserMapper userMapper;

    public UserRegistrationService(
            UserRepository userRepository,
            BCryptPasswordEncoder bcryptPasswordEncoder,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
        this.userMapper = userMapper;
    }

    public UserDTO UserRegistration(User userData) throws Exception {
        userData.setPassword(GenerateHashedPassword(userData.getPassword()));
        try {
            return userMapper.transformUserEntityInUserDto(userRepository.save(userData), true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String GenerateHashedPassword(String password) {
        return bcryptPasswordEncoder.encode(password);
    }
}
