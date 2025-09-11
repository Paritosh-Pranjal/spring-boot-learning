package com.jpa.demo.dao.impl;

import com.jpa.demo.dao.StudentDAO;
import com.jpa.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //    define field for entity manager
    private final EntityManager entityManager;

    //    inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //            implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //  create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //return query result
        return theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String lastName) {
//        create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student  where lastName = :theData", Student.class);

//        define parameter
        theQuery.setParameter("theData", lastName);

//        return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
//        retrieve the student
        Student student = entityManager.find(Student.class, id);
//        delete student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }
}
