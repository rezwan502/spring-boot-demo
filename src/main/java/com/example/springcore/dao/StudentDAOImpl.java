package com.example.springcore.dao;

import com.example.springcore.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student save(Student theStudent) {
        return entityManager.merge(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "From Student order by lastName desc", Student.class
        );
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "From Student where lastName=:theData", Student.class
        );
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student ").executeUpdate();
    }
}
