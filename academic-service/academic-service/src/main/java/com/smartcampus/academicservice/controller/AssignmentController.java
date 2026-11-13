
package com.smartcampus.academicservice.controller;

import com.smartcampus.academicservice.entity.Assignment;
import com.smartcampus.academicservice.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "http://localhost:5173")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    // Create assignment
    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    // Get all assignments
    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    // Get assignment by ID
    @GetMapping("/{id}")
    public Assignment getAssignmentById(@PathVariable Long id) {
        return assignmentService.getAssignmentById(id);
    }

    // Get assignments by course code
    @GetMapping("/course/{courseCode}")
    public List<Assignment> getAssignmentsByCourseCode(
            @PathVariable String courseCode) {
        return assignmentService.getAssignmentsByCourseCode(courseCode);
    }

    // Get assignments by faculty name
    @GetMapping("/faculty/{facultyName}")
    public List<Assignment> getAssignmentsByFacultyName(
            @PathVariable String facultyName) {
        return assignmentService.getAssignmentsByFacultyName(facultyName);
    }

    // Update assignment
    @PutMapping("/{id}")
    public Assignment updateAssignment(
            @PathVariable Long id,
            @RequestBody Assignment assignment) {
        return assignmentService.updateAssignment(id, assignment);
    }

    // Delete assignment
    @DeleteMapping("/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return "Assignment deleted successfully";
    }
}
