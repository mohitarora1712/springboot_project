package com.lpu.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.Service;

import com.lpu.test2.entity.Student;
import com.lpu.test2.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @PreAuthorize("hasRole('ADMIN')")
    public Student create(Student s){
        return repo.save(s);
    }

    @Cacheable(value="students", key="#id")
    @PostAuthorize("hasRole('ADMIN') or returnObject.email == authentication.name")
    public Student getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Page<Student> getAll(Pageable pageable){
        return repo.findAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Student update(Long id, Student s){

        Student st = repo.findById(id).orElseThrow();

        st.setName(s.getName());
        st.setEmail(s.getEmail());
        st.setCourse(s.getCourse());
        st.setMarks(s.getMarks());

        return repo.save(st);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id){
        repo.deleteById(id);
    }
}