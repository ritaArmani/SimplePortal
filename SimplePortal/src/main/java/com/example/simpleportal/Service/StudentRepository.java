package com.example.simpleportal.Service;

import com.example.simpleportal.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmailIgnoreCase(String email);

    Optional<Student> findFirstByOrderByIdAsc();
    @Query("select s from Student s where lower(s.email) = lower(:email) and s.password = :password")
    Optional<Student> login(@Param("email") String email, @Param("password") String password);


    List<Student> findByRoleIgnoreCaseOrderByNameAsc(String role);
}



