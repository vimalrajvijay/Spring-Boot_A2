package com.example.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.exception.InvalidAgeException;
import com.example.student_management_system.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		if(student.getAge()<18)
			throw new InvalidAgeException("Age is less than 18");
		return studentRepository.save(student);
	}
	
	public Student readStudent(int id) {
		return studentRepository.findById(id).get();
//		Optional<Student> optional = studentRepository.findById(id);
//		if(optional.isPresent())
//		else
//			
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Student student, int id) {
		Student existingStudent = studentRepository.findById(id).get();
		
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setAge(student.getAge());
		existingStudent.setPassword(student.getPassword());
		
		return studentRepository.save(existingStudent);
	}
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
