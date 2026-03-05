package com.lpu.boot1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot1.entity.Student;

@RestController
public class MyController {
	
	@GetMapping("/hi")
	public String takeReq() {
		return "Bye";
		
	}
	
	//http://localhost:8080/takeData?id=1&name=Salgota
	@GetMapping("/takeData")
	public String takeData(@RequestParam int id, @RequestParam String name) {
		return "ID "+id+" name "+name;
		
	}
	
	@GetMapping("/College")
	public String college(@RequestParam int id, @RequestParam String name, @RequestParam String loc) {
		return "ID: "+id+"\nName: "+name+"\nLoc: "+loc;
		
	}
	
	//http://localhost:8080/takeData2/1/Mohit
	@GetMapping("/takeData2/{id}/{name}")
	public String takeData2(@PathVariable int id, @PathVariable String name) {
		return "ID "+id+" name "+name;
		
	}
	
	//http://localhost:8080/student/1/college/101?student=Mohit&college=LPU
	@GetMapping("/student/{sid}/college/{cid}")
	public String takeData3(@RequestParam String student, @PathVariable int sid, @RequestParam String college, @PathVariable int cid) {
		return "Student: "+student+"\nSId: "+sid+"\nCollege: "+college+ "\nCId: "+cid;
		
	}
	
	//http://localhost:8080/takeData4
	@GetMapping("/takeData4")
	public String takeData4(@RequestHeader int id, @RequestHeader String name, @RequestHeader String loc) {
		return "ID: "+id+"\nName: "+name+"\nLoc: "+loc;
		
	}
	
	@GetMapping("/student1")
	public String getStudent(@RequestBody Student s) {
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getPhone());
		return s.getName() +"  is recieved  Oh yess ohh";
		
	}
	
	@GetMapping("/student2")
	public Student getStudent2(@RequestBody Student s) {
		return s;
		
	}
	
	
	
	

}
