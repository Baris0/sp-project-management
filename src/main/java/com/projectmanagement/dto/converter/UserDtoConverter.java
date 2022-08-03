package com.projectmanagement.dto.converter;

import com.projectmanagement.dto.UserDto;
import com.projectmanagement.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDto convert(User user) {
        return new UserDto(user.getFullName(),
                user.getUserName(),
                user.getMail(),
                user.getUserType(),
                user.isActive());
    }

    public List<UserDto> convert(List<User> users) {
        return users.stream().map(this::convert).collect(Collectors.toList());
    }
}
