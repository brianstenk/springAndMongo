package com.crystal.springmongodbproject.repository;

import com.crystal.springmongodbproject.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {
    Student findByName(String name);
    Student findByNameAndEmail(String name, String email);
    List<Student> findByDepartmentName(String departmentName);
}
