
package com.smartcampus.academicservice.repository;

import com.smartcampus.academicservice.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByStudentId(Long studentId);

    List<Result> findByCourseCode(String courseCode);

    List<Result> findByExamName(String examName);

    List<Result> findByGrade(String grade);

    List<Result> findByStudentIdAndCourseCode(
            Long studentId, String courseCode);
}
