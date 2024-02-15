package com.wildcodeschool.webook.auth.domain.service;

import com.wildcodeschool.webook.auth.domain.dto.UserDTO;
import com.wildcodeschool.webook.auth.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO transformUserEntityInUserDto(User user, Boolean isForResponse) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEnabled(true);
        userDTO.setRoles(user.getRoles());
        userDTO.setPassword(isForResponse ? "" : user.getPassword());

        return userDTO;
    }
}
