package com.example.pp_sprinf_bootstrap_3_1_3.service;

import com.example.pp_sprinf_bootstrap_3_1_3.dao.RoleDao;
import com.example.pp_sprinf_bootstrap_3_1_3.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public List<Role> getByName(List<String> name) {
        return roleDao.getByName(name);
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        roleDao.deleteById(id);
    }
}
