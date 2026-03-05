package com.lpu.boot1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.boot1.entity.College;
import com.lpu.boot1.entity.Student;
import com.lpu.boot1.repository.CollegeRepository;
import com.lpu.boot1.repository.StudentRepository;

@Service
public class CollegeService {

	@Autowired
    private final CollegeRepository repository;

    // Constructor Injection
    public CollegeService(CollegeRepository repository) {
        this.repository = repository;
    }

    // Save Student
    public College saveCollege(College college) {
        return repository.save(college);
    }
    
    public College findCollegeById(int id) {
    	//Optional<Student> optional = repository.findById(id);
    	//return optional.get();
    	return repository.findById(id).orElse(null);
    }
    public void deleteCollege(College college) {
    	repository.delete(college);
    }
    
    public void deleteById(int id) {
    	repository.deleteById(id);
    }
    
}
