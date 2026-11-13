
package com.smartcampus.academicservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assignmentTitle;

    private String courseCode;

    @Column(length = 1000)
    private String description;

    private LocalDate dueDate;

    private String facultyName;

    // Default constructor
    public Assignment() {
    }

    // Parameterized constructor
    public Assignment(String assignmentTitle, String courseCode,
                      String description, LocalDate dueDate,
                      String facultyName) {
        this.assignmentTitle = assignmentTitle;
        this.courseCode = courseCode;
        this.description = description;
        this.dueDate = dueDate;
        this.facultyName = facultyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
