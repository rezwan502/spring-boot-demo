package com.example.springcore.dao;

import com.example.springcore.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM Student", nativeQuery = true)
    List<Student> findByLastName(String userId);
}
