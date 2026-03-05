package com.lpu.boot1.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.boot1.entity.Student;
import com.lpu.boot1.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private final StudentRepository repository;

    // Constructor Injection
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // Save Student
    public Student saveStudent(Student student) {
        return repository.save(student);
    }
    
    public Student findStudentById(int id) {
    	//Optional<Student> optional = repository.findById(id);
    	//return optional.get();
    	return repository.findById(id).orElse(null);
    }
    public void deleteStudent(Student student) {
    	repository.delete(student);
    }
    public List<Student> findAllStudent(){
    	return repository.findAll();
    }
    public void deleteById(int id) {
    	repository.deleteById(id);
    }
    public List<Student> saveAllStudent(List<Student> student){
    	return repository.saveAll(student);
    }
    
    public List<Student> findByName(String name) {
    	return repository.findByName(name);
    }
}
