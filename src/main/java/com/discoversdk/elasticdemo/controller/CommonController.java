package com.discoversdk.elasticdemo.controller;

import com.discoversdk.elasticdemo.service.StudentService;
import com.discoversdk.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommonController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentService.getALlStudents();
    }

    @RequestMapping(value = "/insert/student", method = RequestMethod.POST)
    public Student insertStudent(@RequestBody Student student){
        return studentService.insertStudent(student);
    }

    @RequestMapping(value = "/delete/student/{id}", method = RequestMethod.GET)
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }
}
