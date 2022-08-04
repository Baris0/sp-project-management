package com.projectmanagement.dto.request;

import com.projectmanagement.model.UserType;
import lombok.Data;

@Data
public class UpdateUserRequest {

    private String fullName;
    private String userName;
    private UserType userType;
    private boolean isActive;
}
