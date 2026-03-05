package com.lpu.emp.controller;

import java.io.IOException;
import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.emp.entity.FileData;
import com.lpu.emp.repository.FileDataRepository;

@RestController
@RequestMapping("/api")
public class FileDataController {
	
	@Autowired
	private FileDataRepository repo;
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		FileData f=new FileData();
		f.setFileName(file.getOriginalFilename());
		f.setFieldName(file.getContentType());
		f.setData(file.getBytes());
		
		FileData saved=repo.save(f);
		return "Saved Id: "+saved.getId();
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable long id) {
		FileData f=repo.findById(id).orElseThrow(()-> new RuntimeException("File Not Found Id: "+id));
		return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"" +f.getFileName())
				.header(org.springframework.http.HttpHeaders.CONTENT_TYPE,f.getFieldName()).body(f.getData());
	}

}
