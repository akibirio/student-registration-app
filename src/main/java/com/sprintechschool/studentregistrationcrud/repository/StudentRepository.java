package com.sprintechschool.studentregistrationcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sprintechschool.studentregistrationcrud.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
