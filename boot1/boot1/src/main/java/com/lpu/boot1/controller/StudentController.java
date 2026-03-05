package com.lpu.boot1.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.boot1.entity.Student;
import com.lpu.boot1.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
    private final StudentService service;

    // Constructor Injection
    public StudentController(StudentService service) {
        this.service = service;
    }

    // POST API
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }
    
    @GetMapping("/student/{id}")
    public Student fetchStudentById(@PathVariable int id) {
    	return service.findStudentById(id);
    }
    @DeleteMapping("/student")
    public String deleteStudent(@RequestBody Student student) {
    	service.deleteStudent(student);
    	return "Student Deleted";
    }
    @GetMapping("/student")
    public List<Student> findAllStudent(){
    	return service.findAllStudent();
    }
    @DeleteMapping("/studentId")
    public String deleteStudentById(@RequestParam int id) {
    	service.deleteById(id);
    	return "Student with id "+id+" Deleted";
    }
    @PostMapping("/saveAll")
    public List<Student> saveAllStudent(@RequestBody List<Student> students) {
        return service.saveAllStudent(students);
    }
    @GetMapping("/getAll/{name}")
    public List<Student> getAll(@PathVariable String name){
    	return service.findByName(name);
    }
}