package com.lpu.test2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.test2.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}