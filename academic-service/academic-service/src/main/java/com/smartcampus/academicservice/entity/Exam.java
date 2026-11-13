
package com.smartcampus.academicservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examName;

    private String courseCode;

    private LocalDate examDate;

    private LocalTime startTime;

    private Integer durationMinutes;

    private Integer totalMarks;

    private String facultyName;

    // Default constructor
    public Exam() {
    }

    // Parameterized constructor
    public Exam(String examName, String courseCode,
                LocalDate examDate, LocalTime startTime,
                Integer durationMinutes, Integer totalMarks,
                String facultyName) {

        this.examName = examName;
        this.courseCode = courseCode;
        this.examDate = examDate;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.totalMarks = totalMarks;
        this.facultyName = facultyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
