package com.learn.springboot.demosecurity.dao;

import com.learn.springboot.demosecurity.entity.Roles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Roles findRoleByName(String theRoleName) {
        TypedQuery<Roles> theQuery = entityManager.createQuery(
                "from Roles where name=:roleName", Roles.class
        );
        theQuery.setParameter("roleName", theRoleName);

        Roles theRole = null;

        try {
            theRole = theQuery.getSingleResult();
        } catch (Exception e) {
            theRole = null;
        }
        return theRole;
    }
}
