package com.example.pp_sprinf_bootstrap_3_1_3.controller;

import com.example.pp_sprinf_bootstrap_3_1_3.model.Role;
import com.example.pp_sprinf_bootstrap_3_1_3.model.User;
import com.example.pp_sprinf_bootstrap_3_1_3.service.RoleService;
import com.example.pp_sprinf_bootstrap_3_1_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAll();
    }

    @GetMapping("users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @PatchMapping("users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        user.setId(id);
        userService.update(user);
        return userService.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}
