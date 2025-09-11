package com.jpa.demo;

import com.jpa.demo.dao.StudentDAO;
import com.jpa.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForFindStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new Student object...");
        Student tempStudent = new Student("Paul", "Doe", "paul.doe@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display the id of saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create the multiple student object
        System.out.println("Creating 3 Student object...");
        Student tempStudent1 = new Student("john", "Doe", "john.doe@gmail.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");
        Student tempStudent3 = new Student("Bonita", "apple", "bonita@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        // display the id of saved student
        System.out.println("Saved student 1. Generated id: " + tempStudent1.getId());
        System.out.println("Saved student 2. Generated id: " + tempStudent2.getId());
        System.out.println("Saved student 3. Generated id: " + tempStudent3.getId());
    }

    private void readStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new Student object...");
        Student tempStudent = new Student("Daffy", "buck", "daffy@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display the id of saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student based on id: primary key
        System.out.println("Retrieve student by id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found student: " + myStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {

//        get list of student
        List<Student> students = studentDAO.findAll();
//        display list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForFindStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Doe");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student id with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        // change first name to "John"
        System.out.println("Updating student...");
        student.setFirstName("John");

        // update the student
        studentDAO.update(student);

        // display the updated student
        System.out.println("Updated student..." + student);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student with id " + studentId);

        studentDAO.delete(studentId);
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted " + numRowsDeleted + " students");
    }

}
