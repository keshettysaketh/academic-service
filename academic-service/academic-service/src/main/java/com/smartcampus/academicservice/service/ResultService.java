
package com.smartcampus.academicservice.service;

import com.smartcampus.academicservice.entity.Result;
import com.smartcampus.academicservice.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    // Add a new result
    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    // Get all results
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    // Get result by ID
    public Result getResultById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Result not found with ID: " + id));
    }

    // Get results by student ID
    public List<Result> getResultsByStudentId(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }

    // Get results by course code
    public List<Result> getResultsByCourseCode(String courseCode) {
        return resultRepository.findByCourseCode(courseCode);
    }

    // Get results by exam name
    public List<Result> getResultsByExamName(String examName) {
        return resultRepository.findByExamName(examName);
    }

    // Get results by grade
    public List<Result> getResultsByGrade(String grade) {
        return resultRepository.findByGrade(grade);
    }

    // Get results by student ID and course code
    public List<Result> getResultsByStudentAndCourse(
            Long studentId, String courseCode) {
        return resultRepository.findByStudentIdAndCourseCode(
                studentId, courseCode);
    }

    // Update result
    public Result updateResult(Long id, Result updatedResult) {
        Result existingResult = getResultById(id);
        updatedResult.setId(existingResult.getId());
        return resultRepository.save(updatedResult);
    }

    // Delete result
    public void deleteResult(Long id) {
        Result result = getResultById(id);
        resultRepository.delete(result);
    }
}
