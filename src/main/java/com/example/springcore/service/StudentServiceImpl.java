package com.example.springcore.service;

import com.example.springcore.dao.StudentDAO;
import com.example.springcore.dao.StudentJpaRepository;
import com.example.springcore.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    StudentJpaRepository studentJpaRepository;
    
    @Autowired
    public StudentServiceImpl(StudentJpaRepository studentJpaRepository)  {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public Student save(Student theStudent) {
        return studentJpaRepository.save(theStudent);
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result = studentJpaRepository.findById(id);
        Student student = null;
        if (result.isPresent()) {
            student = result.get();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentJpaRepository.findByLastName(lastName);
    }

    @Override
    public Student update(Student student) {
        return studentJpaRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        Student student = findById(id);
        studentJpaRepository.delete(student);
    }

    @Override
    public void deleteAll() {
        studentJpaRepository.deleteAll();
    }
}
