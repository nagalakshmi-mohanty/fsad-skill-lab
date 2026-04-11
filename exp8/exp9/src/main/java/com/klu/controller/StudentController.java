package com.klu.controller;

import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {

        if (id <= 0) {
            throw new InvalidInputException("Invalid student ID");
        }

        if (id > 5) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return "Student details for ID: " + id;
    }
}