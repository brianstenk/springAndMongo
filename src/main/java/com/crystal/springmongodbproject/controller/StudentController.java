package com.crystal.springmongodbproject.controller;

import com.crystal.springmongodbproject.model.Student;
import com.crystal.springmongodbproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/test")
    public String test(){
        return "working well";
    }
    @GetMapping("/getById/{id}")
    public Optional<Student> getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public Optional<Student> deleteStudentById(@PathVariable String id){
       return studentService.deleteStudent(id);
    }
    @GetMapping("/getStudentByName/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }
    //localhost:8080/api/student/studentByNameAndMail?name=XY&email=WZ@gmail.com
    @GetMapping("/studentByNameAndMail")
    public Student getByNameAndEmail(@RequestParam String name, @RequestParam String email){
        return studentService.getByNameAndByMail(name, email);
    }

    @GetMapping("/sortedList")
    public List<Student> allWithSorting(){
        return studentService.allWithSorting();
    }

    @GetMapping("/allWithPagination")
    //Skip = (PageNo-1) * PageSize
    public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getAllStudentsWithPagination(pageNo, pageSize);
    }

    //localhost:8080/api/student/getByDepartmentName?deptName=Computer Science
    @GetMapping("/getByDepartmentName/")
    public List<Student> getByDepartmentName(@RequestParam String deptName){
        return studentService.getByDepartmentName(deptName);
    }
}
