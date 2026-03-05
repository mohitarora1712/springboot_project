//package com.lpu.boot1.controller;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lpu.boot1.entity.College;
//
//import com.lpu.boot1.service.CollegeService;
//
//
//@RestController
//public class CollegeController {
//	
//	@Autowired
//    private final CollegeService service;
//
//    // Constructor Injection
//    public CollegeController(CollegeService service) {
//        this.service = service;
//    }
//
//    // POST API
//    @PostMapping("/student")
//    public College saveStudent(@RequestBody College student) {
//        return service.saveCollege(student);
//    }
//    
//    @GetMapping("/student/{id}")
//    public College fetchCollegeById(@PathVariable int id) {
//    	return service.findCollegeById(id);
//    }
//    @DeleteMapping("/student")
//    public String deleteCollege(@RequestBody College college) {
//    	service.deleteCollege(college);
//    	return "College Deleted";
//    }
//   
//
//}
