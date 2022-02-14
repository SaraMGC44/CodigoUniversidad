package com.crud.questions.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.questions.models.Student;
import com.crud.questions.service.StudentServiceInterface;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceInterface service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Student> a = service.findById(id);
		if(a.isEmpty()) {
			ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(a);
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Student student){
		Student studentBD = service.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentBD);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Student student , @PathVariable Long id){
		Optional<Student> o = service.findById(id);
		
		if(o.isPresent() == false) {
			ResponseEntity.notFound().build();
		}
		Student studentBD = o.get();
		studentBD.setname(student.getname());
		studentBD.setLastname(student.getLastname());
		studentBD.setId(student.getId());
		studentBD.setDate(student.getDate());
		studentBD.setEmail(student.getEmail());
		studentBD.setAge(student.getAge());
		studentBD.setPhone(student.getPhone());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentBD));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
