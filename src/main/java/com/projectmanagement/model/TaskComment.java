package com.projectmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TaskComment {

    @Id
    private String id;

    private String body;

    private LocalDate createDate;

    private LocalDate updateDate;

    private User commentBy;

    private Integer taskCode;

    private LocalDate startDate;

    private LocalDate endDate;
}
