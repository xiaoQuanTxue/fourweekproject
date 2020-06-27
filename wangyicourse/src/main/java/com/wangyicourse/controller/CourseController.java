package com.wangyicourse.controller;


import com.wangyicourse.entity.Course;
import com.wangyicourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/allCourses")
    @ResponseBody
    @CrossOrigin(value = "*")
   public List<Course> allCourses(){
       return courseService.findAllCourse();
    }
}
