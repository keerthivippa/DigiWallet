package com.orion.DigiWallet.controller;



import com.orion.DigiWallet.model.User;
import com.orion.DigiWallet.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("GET /api/users called");
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        logger.info("GET /api/users/{} called", id);
        return userService.getUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("POST /api/users called");
        return userService.createUser(user);
    }

    //TODO: 4.1
    // UPDATE USER STATUS FROM ACTIVE TO INACTIVE OR VICE VERSA
    // -------------------------
    // http://localhost:8080/api/users/{id}
    // PUT METHOD
    // METHOD NAME: updateUserStatus
    // status (ACTIVE/INACTIVE)
    // RESPONSE BODY: Updated User JSON

    @PutMapping("/{id}")
    public User updateUserStatus(@PathVariable long id){
        return userService.updateUserStatus(id);
    }

}

