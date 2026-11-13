
package com.smartcampus.academicservice.controller;

import com.smartcampus.academicservice.entity.Result;
import com.smartcampus.academicservice.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "http://localhost:5173")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    // Create result
    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultService.createResult(result);
    }

    // Get all results
    @GetMapping
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    // Get result by ID
    @GetMapping("/{id}")
    public Result getResultById(@PathVariable Long id) {
        return resultService.getResultById(id);
    }

    // Get results by student ID
    @GetMapping("/student/{studentId}")
    public List<Result> getResultsByStudentId(
            @PathVariable Long studentId) {
        return resultService.getResultsByStudentId(studentId);
    }

    // Get results by course code
    @GetMapping("/course/{courseCode}")
    public List<Result> getResultsByCourseCode(
            @PathVariable String courseCode) {
        return resultService.getResultsByCourseCode(courseCode);
    }

    // Get results by exam name
    @GetMapping("/exam/{examName}")
    public List<Result> getResultsByExamName(
            @PathVariable String examName) {
        return resultService.getResultsByExamName(examName);
    }

    // Get results by grade
    @GetMapping("/grade/{grade}")
    public List<Result> getResultsByGrade(
            @PathVariable String grade) {
        return resultService.getResultsByGrade(grade);
    }

    // Get result by student and course
    @GetMapping("/student/{studentId}/course/{courseCode}")
    public List<Result> getResultsByStudentAndCourse(
            @PathVariable Long studentId,
            @PathVariable String courseCode) {
        return resultService.getResultsByStudentAndCourse(
                studentId, courseCode);
    }

    // Update result
    @PutMapping("/{id}")
    public Result updateResult(
            @PathVariable Long id,
            @RequestBody Result result) {
        return resultService.updateResult(id, result);
    }

    // Delete result
    @DeleteMapping("/{id}")
    public String deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return "Result deleted successfully";
    }
}
