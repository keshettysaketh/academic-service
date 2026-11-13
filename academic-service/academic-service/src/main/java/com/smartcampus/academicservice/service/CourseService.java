
package com.smartcampus.academicservice.service;

import com.smartcampus.academicservice.entity.Course;
import com.smartcampus.academicservice.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    // Constructor injection
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Add a new course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get course by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found with ID: " + id));
    }

    // Update course
    public Course updateCourse(Long id, Course updatedCourse) {

        Course existingCourse = getCourseById(id);

        existingCourse.setCourseName(updatedCourse.getCourseName());
        existingCourse.setCourseCode(updatedCourse.getCourseCode());
        existingCourse.setCredits(updatedCourse.getCredits());

        return courseRepository.save(existingCourse);
    }

    // Delete course
    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
}
