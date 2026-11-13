
package com.smartcampus.academicservice.service;

import com.smartcampus.academicservice.entity.Exam;
import com.smartcampus.academicservice.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    // Constructor injection
    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    // Create a new exam
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    // Get all exams
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    // Get exam by ID
    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Exam not found with ID: " + id));
    }

    // Get exams by course code
    public List<Exam> getExamsByCourseCode(String courseCode) {
        return examRepository.findByCourseCode(courseCode);
    }

    // Get exams by exam name
    public List<Exam> getExamsByName(String examName) {
        return examRepository.findByExamName(examName);
    }

    // Get exams by faculty name
    public List<Exam> getExamsByFacultyName(String facultyName) {
        return examRepository.findByFacultyName(facultyName);
    }

    // Update exam
    public Exam updateExam(Long id, Exam updatedExam) {

        Exam existingExam = getExamById(id);

        updatedExam.setId(existingExam.getId());

        return examRepository.save(updatedExam);
    }

    // Delete exam
    public void deleteExam(Long id) {
        Exam exam = getExamById(id);
        examRepository.delete(exam);
    }
}
