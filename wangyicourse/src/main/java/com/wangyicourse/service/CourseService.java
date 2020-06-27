package com.wangyicourse.service;


import com.wangyicourse.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> findAllCourse();

    //获取课程及课程详情
    Course findCourseDetails(int courseid);
    //xinzeng
    boolean addSubscribe(int courseid);
}
