package com.example.pp_sprinf_bootstrap_3_1_3.service;

import com.example.pp_sprinf_bootstrap_3_1_3.dao.UserDao;
import com.example.pp_sprinf_bootstrap_3_1_3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getByName(s);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

}
