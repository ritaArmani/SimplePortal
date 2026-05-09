package com.example.simpleportal.Controller;
import com.example.simpleportal.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping("/portal")
    public ResponseEntity<Map<String,Object>> getStudentDashboard(@RequestParam String name,@RequestParam int semester ,@RequestParam String faculty){
        Map<String, Object> data = service.processStudentData(name, semester, faculty);
        return ResponseEntity.ok(data);
    }

}