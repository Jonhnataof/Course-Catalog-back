package com.joota.service;

import com.joota.model.Course;
import com.joota.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public Course create(Course course){
       return courseRepository.save(course);
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    public Optional<Course> update(Long id, Course course){
        return courseRepository.findById(id)
                .map(existCourse -> {
                    existCourse.setName(course.getName());
                    existCourse.setCategory(course.getCategory());
                    return courseRepository.save(existCourse);
                });
    }

    public Optional<Course> delete(Long id){
        return courseRepository.findById(id)
                .map(course -> {
                    courseRepository.delete(course);
                    return course;
                });
    }
}
