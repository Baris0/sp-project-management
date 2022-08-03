package com.projectmanagement.controller;

import com.projectmanagement.dto.UserDto;
import com.projectmanagement.dto.request.UserCreateRequest;
import com.projectmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserCreateRequest request) {
        return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
    }

    @DeleteMapping("{mail}")
    public ResponseEntity<?> deleteByMail(@PathVariable("mail") String mail) {
        userService.deleteByMail(mail);
        return new ResponseEntity<>(mail, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{userName}")
    public ResponseEntity<UserDto> getByUserName(@PathVariable("userName") String userName) {
        return new ResponseEntity<>(userService.getByUser(userName), HttpStatus.OK);
    }

}
