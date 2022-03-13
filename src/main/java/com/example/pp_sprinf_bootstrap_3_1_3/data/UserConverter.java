package com.example.pp_sprinf_bootstrap_3_1_3.data;

import com.example.pp_sprinf_bootstrap_3_1_3.model.User;
import com.example.pp_sprinf_bootstrap_3_1_3.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private RoleService roleService;

    public User convert (UserData userData) {
        User user = new User();

        user.setName(userData.getName());
        user.setLastName(userData.getLastName());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRoles(roleService.getByName(userData.getRoles()));
        return user;
    }
}
