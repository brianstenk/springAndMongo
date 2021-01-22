package com.crystal.springmongodbproject.service;

import com.crystal.springmongodbproject.model.Student;
import com.crystal.springmongodbproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(Long.valueOf(id));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        //This save() is eq to save or Update
        if (student.getId() < 0)
            return studentRepository.save(student);
        else{
            studentRepository.delete(student);
            return studentRepository.save(student);
        }
        //return (student.getId < 0) ?
    }

    public Optional<Student> deleteStudent(String id) {
        Optional<Student> student = studentRepository.findById(Long.valueOf(id));
        studentRepository.deleteById(Long.valueOf(id));
        return student;
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student getByNameAndByMail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> allWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return studentRepository.findAll(sort);
    }

    public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getByDepartmentName(String deptName) {
        return studentRepository.findByDepartmentName(deptName);
    }
}

