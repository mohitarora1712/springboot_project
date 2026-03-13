package com.lpu.test2.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.test2.entity.Student;
import com.lpu.test2.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student create(@RequestBody Student s){
        return service.create(s);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping
    public Page<Student> getAll(
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="5") int size,
            @RequestParam(defaultValue="id") String sort){

        return service.getAll(PageRequest.of(page,size,Sort.by(sort)));
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,@RequestBody Student s){
        return service.update(id,s);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Deleted";
    }

    @PostMapping("/{id}/profile")
    public String uploadProfile(@PathVariable Long id,
                                @RequestParam MultipartFile fil)
            throws IOException {

        Student s = service.getById(id);
        s.setProfileImage(fil.getBytes());
        service.update(id,s);

        return "Profile uploaded";
    }

    @GetMapping("/{id}/profile")
    public byte[] downloadProfile(@PathVariable Long id){
        return service.getById(id).getProfileImage();
    }
}