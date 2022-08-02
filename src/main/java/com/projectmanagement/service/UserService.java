package com.projectmanagement.service;

import com.projectmanagement.dto.UserDto;
import com.projectmanagement.dto.converter.UserDtoConverter;
import com.projectmanagement.dto.request.UserCreateRequest;
import com.projectmanagement.exception.UserNoFoundException;
import com.projectmanagement.model.User;
import com.projectmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public UserDto getByUserName(String userName) {
        return userDtoConverter.convert(userRepository.findUserByUserName(userName));
    }

    protected User getUser(String mail) {
        return userRepository.findUserByMail(mail);
    }

}
