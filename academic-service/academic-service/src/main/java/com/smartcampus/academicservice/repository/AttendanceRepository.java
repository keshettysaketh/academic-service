
package com.smartcampus.academicservice.repository;

import com.smartcampus.academicservice.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    // Find attendance records of a particular student
    List<Attendance> findByStudentId(Long studentId);

    // Find attendance records for a particular course
    List<Attendance> findByCourseCode(String courseCode);

    // Find attendance records of a student for a particular course
    List<Attendance> findByStudentIdAndCourseCode(
            Long studentId, String courseCode);
}
