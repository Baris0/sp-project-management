package com.projectmanagement.dto;

import com.projectmanagement.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String fullName;

    private String userName;

    private String mail;

    private UserType userType;
}
