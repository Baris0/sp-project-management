package com.projectmanagement.dto.request;

import com.projectmanagement.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UserCreateRequest {

    @NotNull
    private String fullName;

    private String userName;

    @Email
    private String mail;

    @NotNull
    private UserType userType;

}
