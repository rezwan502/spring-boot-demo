package com.example.springcore.dao;

import com.example.springcore.entity.Student;

import java.util.List;

public interface StudentDAO {
    Student save(Student theStudent);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(Integer id);
    int deleteAll();
}
