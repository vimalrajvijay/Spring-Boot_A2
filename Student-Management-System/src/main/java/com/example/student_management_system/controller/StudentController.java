package com.example.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student savedStudent = studentService.saveStudent(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id){
		Student student = studentService.readStudent(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student ,@PathVariable int id){
		Student updatedStudent = studentService.updateStudent(student, id);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		studentService.deleteStudent(id);
		return new ResponseEntity<>("Student is Deleted", HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping
	public ResponseEntity<String> test() {
		return ResponseEntity.noContent().build();
	}
}
