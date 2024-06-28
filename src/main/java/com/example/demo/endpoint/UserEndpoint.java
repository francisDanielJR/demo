package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @PostMapping("/users/create")
    public Object createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

    @GetMapping("/users/{id}")
    public Object getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users/{id}/update")
    public Object updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PostMapping("/users/{id}/delete")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
