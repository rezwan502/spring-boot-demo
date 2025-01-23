package com.example.springcore;

import com.example.springcore.dao.StudentDAO;
import com.example.springcore.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int count = studentDAO.deleteAll();
		System.out.println("deleteAllStudent = " + count);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("updateStudent");
		Student student = studentDAO.findById(1);
		System.out.println(student);
		student.setFirstName("rezwan");
		studentDAO.update(student);
		System.out.println("updated = " + studentDAO.findById(1));
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("queryForStudentsByLastName");
		List<Student> studentList = studentDAO.findByLastName("haque");
		for (Student student: studentList) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("queryForStudents");
		List<Student> studentList = studentDAO.findAll();
		for (Student student: studentList) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("rezwan", "sec", "rezwan.sec@gmail.com");
		Student student1 = new Student("sanjida", "haque", "sanjida.haque@gmail.com");
		Student student2 = new Student("rukaiya", "mariyam", "rukaiya.mariyam@gmail.com");
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);
		System.out.println("student id = " + student.getId());
	}
}
