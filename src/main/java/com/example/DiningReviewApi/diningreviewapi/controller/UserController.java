package com.example.DiningReviewApi.diningreviewapi.controller;

import com.example.DiningReviewApi.diningreviewapi.model.User;
import com.example.DiningReviewApi.diningreviewapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{userId}")
    public Optional<User> getUser(@PathVariable(value = "userId") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteStudent(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long studentId,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String postCode)
    {
        userService.updateUser(studentId, userName, city, state, postCode);
    }
}
