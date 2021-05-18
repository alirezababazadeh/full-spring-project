package edu.home.user.controller;

import edu.home.user.dto.UserDTO;
import edu.home.user.model.User;
import edu.home.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public UserDTO save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("read")
    public User find(@RequestBody User user) {
        return userService.findByUsername(user.getUsername());
    }


}
