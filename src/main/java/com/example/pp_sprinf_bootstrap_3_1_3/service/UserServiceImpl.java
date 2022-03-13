package com.example.pp_sprinf_bootstrap_3_1_3.service;


import com.example.pp_sprinf_bootstrap_3_1_3.dao.UserDao;
import com.example.pp_sprinf_bootstrap_3_1_3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User getByName(String name) {
        return userDao.getByName(name);
    }

    @Transactional
    @Override
    public void save(User user) {
    if (user.getRoles() != null)
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(User updatedUser) {
        if (updatedUser.getRoles() != null)
            userDao.update(updatedUser);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
