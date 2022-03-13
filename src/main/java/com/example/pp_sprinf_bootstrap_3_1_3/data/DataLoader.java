package com.example.pp_sprinf_bootstrap_3_1_3.data;

import com.example.pp_sprinf_bootstrap_3_1_3.model.Role;
import com.example.pp_sprinf_bootstrap_3_1_3.model.User;
import com.example.pp_sprinf_bootstrap_3_1_3.service.RoleService;
import com.example.pp_sprinf_bootstrap_3_1_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private RoleService roleService;
    private UserService userService;

    @Autowired
    public DataLoader(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    private void saveRole(){
        Role roleAdmin = new Role("ROLE_ADMIN", "ADMIN");
        Role roleUser = new Role( "ROLE_USER", "USER");
        roleService.save(roleAdmin);
        roleService.save(roleUser);
    }

    private void saveUser(){
        User user1 = new User("maga","abdulov",
                "maga","maga@mail.ru", List.of(roleService.getById(1L)));
        User user2 = new User("xasik", "abdulov",
                "xasik", "xasik@mail.ru", List.of(roleService.getById(2L)));
        userService.save(user1);
        userService.save(user2);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveRole();
        saveUser();
    }
}
