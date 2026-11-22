package com.example.student_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_management_system.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByName(String name);
}
