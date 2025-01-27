package com.example.springcore.service;

import com.example.springcore.dao.StudentDAO;
import com.example.springcore.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO)  {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public Student save(Student theStudent) {
        return studentDAO.save(theStudent);
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentDAO.findByLastName(lastName);
    }

    @Override
    @Transactional
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        studentDAO.delete(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return studentDAO.deleteAll();
    }
}
