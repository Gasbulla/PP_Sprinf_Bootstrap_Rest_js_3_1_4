package com.example.pp_sprinf_bootstrap_3_1_3.dao;

import com.example.pp_sprinf_bootstrap_3_1_3.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getById(Long id);
    User getByName(String name);
    void save(User user);
    void update(User updatedUser);
    void deleteById(Long id);
}
