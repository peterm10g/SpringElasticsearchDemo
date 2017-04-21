package com.discoversdk.elasticdemo.service;

import com.discoversdk.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getALlStudents();

    Student insertStudent(Student student);

    void deleteStudent(int student);
}
