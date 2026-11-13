
package com.smartcampus.academicservice.repository;

import com.smartcampus.academicservice.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository
        extends JpaRepository<Assignment, Long> {

    // Find assignments by course code
    List<Assignment> findByCourseCode(String courseCode);

    // Find assignments by faculty name
    List<Assignment> findByFacultyName(String facultyName);
}
