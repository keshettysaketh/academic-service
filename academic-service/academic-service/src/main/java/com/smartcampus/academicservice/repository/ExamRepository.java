
package com.smartcampus.academicservice.repository;

import com.smartcampus.academicservice.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    // Find exams by course code
    List<Exam> findByCourseCode(String courseCode);

    // Find exams by exam name
    List<Exam> findByExamName(String examName);

    // Find exams conducted by a faculty member
    List<Exam> findByFacultyName(String facultyName);
}
