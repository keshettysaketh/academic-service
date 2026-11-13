
package com.smartcampus.academicservice.controller;

import com.smartcampus.academicservice.entity.Exam;
import com.smartcampus.academicservice.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin(origins = "http://localhost:5173")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    @GetMapping("/course/{courseCode}")
    public List<Exam> getExamsByCourseCode(
            @PathVariable String courseCode) {
        return examService.getExamsByCourseCode(courseCode);
    }

    @GetMapping("/name/{examName}")
    public List<Exam> getExamsByName(
            @PathVariable String examName) {
        return examService.getExamsByName(examName);
    }

    @GetMapping("/faculty/{facultyName}")
    public List<Exam> getExamsByFacultyName(
            @PathVariable String facultyName) {
        return examService.getExamsByFacultyName(facultyName);
    }

    @PutMapping("/{id}")
    public Exam updateExam(
            @PathVariable Long id,
            @RequestBody Exam exam) {
        return examService.updateExam(id, exam);
    }

    @DeleteMapping("/{id}")
    public String deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return "Exam deleted successfully";
    }
}
