package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;



    // CREATE
    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Course c)
    {
        service.addCourse(c);

        return new ResponseEntity<>("Course Added", HttpStatus.CREATED);
    }



    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getCourses()
    {
        return new ResponseEntity<>(service.getCourses(), HttpStatus.OK);
    }



    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id)
    {
        Course c = service.getCourse(id);

        if(c != null)
            return new ResponseEntity<>(c, HttpStatus.OK);

        return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
    }



    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                                         @RequestBody Course c)
    {
        String msg = service.updateCourse(id, c);

        if(msg.equals("Course Updated Successfully"))
            return new ResponseEntity<>(msg, HttpStatus.OK);

        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }



    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id)
    {
        String msg = service.deleteCourse(id);

        if(msg.equals("Course Deleted Successfully"))
            return new ResponseEntity<>(msg, HttpStatus.OK);

        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }



    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<?> search(@PathVariable String title)
    {
        List<Course> list = service.search(title);

        if(list.isEmpty())
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}