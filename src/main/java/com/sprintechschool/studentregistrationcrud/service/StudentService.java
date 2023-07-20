package com.sprintechschool.studentregistrationcrud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprintechschool.studentregistrationcrud.domain.Student;
import com.sprintechschool.studentregistrationcrud.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> listAll(){
        return repo.findAll();
    }

    public void save(Student student){
        repo.save(student);
    }

    public Student get(long id){
        return repo.findById(id).get();
    }
    
    public void delete(long id){
        repo.deleteById(id);
    }
}
