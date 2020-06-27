package com.wangyicourse.service.impl;

import com.wangyicourse.entity.Course;
import com.wangyicourse.entity.CourseExample;
import com.wangyicourse.mappers.CourseMapper;
import com.wangyicourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> findAllCourse() {
        return courseMapper.findAllChaptersById();
    }

    @Override
    public Course findCourseDetails(int courseid) {

        return courseMapper.findCourseDetails(courseid);
    }


    @Override
    public boolean addSubscribe(int courseid) {
        Course course = courseMapper.selectByPrimaryKey(courseid);
        course.setSubscribenum(course.getSubscribenum()+1);
        CourseExample courseExample=new CourseExample();
        courseExample.createCriteria().andIdEqualTo(courseid);
        return courseMapper.updateByExampleSelective(course,courseExample)>0;
    }
}
