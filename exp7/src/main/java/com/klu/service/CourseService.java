package com.klu.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.klu.model.Course;

@Service
public class CourseService {

    List<Course> list = new ArrayList<>();


    // CREATE
    public String addCourse(Course c)
    {
        list.add(c);
        return "Course Added Successfully";
    }


    // READ ALL
    public List<Course> getCourses()
    {
        return list;
    }


    // READ BY ID
    public Course getCourse(int id)
    {
        for(Course c : list)
        {
            if(c.getCourseId() == id)
                return c;
        }
        return null;
    }


    // UPDATE
    public String updateCourse(int id, Course newCourse)
    {
        for(Course c : list)
        {
            if(c.getCourseId() == id)
            {
                c.setTitle(newCourse.getTitle());
                c.setDuration(newCourse.getDuration());
                c.setFee(newCourse.getFee());

                return "Course Updated Successfully";
            }
        }

        return "Course Not Found";
    }


    // DELETE
    public String deleteCourse(int id)
    {
        Iterator<Course> i = list.iterator();

        while(i.hasNext())
        {
            Course c = i.next();

            if(c.getCourseId() == id)
            {
                i.remove();
                return "Course Deleted Successfully";
            }
        }

        return "Course Not Found";
    }


    // SEARCH BY TITLE
    public List<Course> search(String title)
    {
        List<Course> result = new ArrayList<>();

        for(Course c : list)
        {
            if(c.getTitle().equalsIgnoreCase(title))
                result.add(c);
        }

        return result;
    }

}