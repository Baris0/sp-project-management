package com.projectmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String fullName;

    private String userName;

    private String mail;

    private UserType userType;

    private LocalDate createDate;

    private boolean isActive = true;
}
