package com.example.pp_sprinf_bootstrap_3_1_3.service;

import com.example.pp_sprinf_bootstrap_3_1_3.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getById(Long id);
    List<Role> getByName(List<String> name);
    void save(Role role);
    void deleteById(Long id);
}
