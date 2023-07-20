package com.sprintechschool.studentregistrationcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprintechschool.studentregistrationcrud.domain.Student;
import com.sprintechschool.studentregistrationcrud.repository.StudentRepository;

@RestController
public class StudentRestController {
    private final StudentRepository studentRepository;

    StudentRestController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //listing all students:
    @GetMapping("/students")
    List<Student> all(){
        return studentRepository.findAll();
    }

    //add new Students
    @PostMapping("/students")
    Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //get one student:
    @GetMapping("/students/{id}")
    Optional<Student> getOneStudent(@PathVariable Long id){
        return studentRepository.findById(id);
        }
    
    //Update a student..
    @PutMapping("/students/{id}")
    Optional<Object> updateStudent(@RequestBody Student newStudent,@PathVariable Long id){
        return studentRepository.findById(id).map(student ->{
            student.setStudentName(newStudent.getStudentName());
            student.setCourse(newStudent.getCourse());
            student.setFee(newStudent.getFee());

            return studentRepository.save(student);
        });
    }

    //Delete student id
    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }
}
