package com.example.pp_sprinf_bootstrap_3_1_3.controller;

import com.example.pp_sprinf_bootstrap_3_1_3.model.User;
import com.example.pp_sprinf_bootstrap_3_1_3.service.RoleService;
import com.example.pp_sprinf_bootstrap_3_1_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class        UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showUser(Principal principal, ModelMap modelMap) {
        User userBd = userService.getByName(principal.getName());
        modelMap.addAttribute("user", userBd);
        modelMap.addAttribute("authorise_user", userService.getByName(principal.getName()));
        modelMap.addAttribute("allUsers", roleService.getAll());
        modelMap.addAttribute("allRoles", roleService.getClass());
        return "user";
    }


}