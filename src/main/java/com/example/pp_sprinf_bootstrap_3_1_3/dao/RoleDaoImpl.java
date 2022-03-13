package com.example.pp_sprinf_bootstrap_3_1_3.dao;

import com.example.pp_sprinf_bootstrap_3_1_3.model.Role;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    EntityManager em;

    public RoleDaoImpl() {
    }

    @Override
    public List<Role> getAll() {
        TypedQuery<Role> query = em
                .createQuery("select r from Role r", Role.class);
        return query.getResultList();
    }

    @Override
    public Role getById(Long id) {
        TypedQuery<Role> query = em
                .createQuery("select r from Role r WHERE r.id =:id", Role.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Role role) {
        em.persist(role);
    }

    @Override
    public void deleteById(Long id) {
        Role role = em.find(Role.class, id);
        if(role != null) {
            em.remove(role);
        }
    }

    @Override
    public List<Role> getByName(List<String> name) {
        TypedQuery<Role> query = em
                .createQuery("select r from Role r WHERE r.name in (:name)", Role.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
