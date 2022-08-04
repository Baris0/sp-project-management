package com.projectmanagement.service;

import com.projectmanagement.dto.UserDto;
import com.projectmanagement.dto.converter.UserDtoConverter;
import com.projectmanagement.dto.request.UpdateUserRequest;
import com.projectmanagement.dto.request.UserCreateRequest;
import com.projectmanagement.model.User;
import com.projectmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserDtoConverter userDtoConverter;

    public UserDto save(UserCreateRequest request) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setCreateDate(LocalDate.now());
        user.setUserName(request.getUserName());
        user.setMail(request.getMail());
        user.setFullName(request.getFullName());
        user.setUserType(request.getUserType());
        user.setActive(true);

        userRepository.save(user);

        return userDtoConverter.convert(user);
    }

    public List<UserDto> getAll() {
        return userDtoConverter.convert(userRepository.findAll());
    }

    public void deleteByMail(String mail) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByMail(mail));

        userRepository.deleteById(user.get().getId());
    }

    public UserDto getByUser(String userName) {
        return userDtoConverter.convert(userRepository.findUserByUserName(userName));
    }

    public boolean getActiveStatus(String userName) {
        User user = userRepository.findUserByUserName(userName);
        return user.isActive();
    }

    public UserDto update(String mail, UpdateUserRequest request) {
        User user = userRepository.findUserByMail(mail);

        User updatedUser = new User();
        updatedUser.setUpdateDate(LocalDate.now());
        updatedUser.setUserName(request.getUserName());
        updatedUser.setFullName(request.getFullName());
        updatedUser.setUserType(request.getUserType());
        updatedUser.setActive(request.isActive());
        updatedUser.setId(user.getId());
        updatedUser.setCreateDate(user.getCreateDate());
        updatedUser.setMail(user.getMail());

        return userDtoConverter.convert(userRepository.save(updatedUser));
    }
}
