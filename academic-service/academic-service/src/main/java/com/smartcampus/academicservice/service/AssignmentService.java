
package com.smartcampus.academicservice.service;

import com.smartcampus.academicservice.entity.Assignment;
import com.smartcampus.academicservice.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    // Create assignment
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    // Get all assignments
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    // Get assignment by ID
    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Assignment not found with ID: " + id));
    }

    // Get assignments by course code
    public List<Assignment> getAssignmentsByCourseCode(String courseCode) {
        return assignmentRepository.findByCourseCode(courseCode);
    }

    // Get assignments by faculty name
    public List<Assignment> getAssignmentsByFacultyName(String facultyName) {
        return assignmentRepository.findByFacultyName(facultyName);
    }

    // Update assignment
    public Assignment updateAssignment(Long id, Assignment updatedAssignment) {
        Assignment existingAssignment = getAssignmentById(id);

        updatedAssignment.setId(existingAssignment.getId());

        return assignmentRepository.save(updatedAssignment);
    }

    // Delete assignment
    public void deleteAssignment(Long id) {
        Assignment assignment = getAssignmentById(id);
        assignmentRepository.delete(assignment);
    }
}
