package com.thing.demo.controller;

import com.thing.demo.entity.Student;
import com.thing.demo.service.StudentService;
import com.thing.demo.utils.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/student")
@RestController()
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/insert")
    public ResponseResult insertStudent(@RequestBody Student student) {
        studentService.insert(student);
        return ResponseResult.okResult();
    }
}
