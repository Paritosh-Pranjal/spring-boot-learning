package com.jpa.demo.dao;

import com.jpa.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String name);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
