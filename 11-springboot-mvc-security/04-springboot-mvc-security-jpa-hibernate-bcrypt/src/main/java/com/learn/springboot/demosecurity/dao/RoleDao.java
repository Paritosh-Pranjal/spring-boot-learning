package com.learn.springboot.demosecurity.dao;

import com.learn.springboot.demosecurity.entity.Roles;

public interface RoleDao {
    Roles findRoleByName(String theRoleName);
}
