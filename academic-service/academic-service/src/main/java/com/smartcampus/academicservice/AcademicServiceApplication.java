package com.smartcampus.academicservice;

import com.smartcampus.academicservice.entity.*;
import com.smartcampus.academicservice.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class AcademicServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademicServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner loadSampleData(
            CourseRepository courses,
            AttendanceRepository attendance,
            TimetableRepository timetable,
            AssignmentRepository assignments,
            ExamRepository exams,
            ResultRepository results) {
        return args -> {
            LocalDate today = LocalDate.now();

            if (courses.count() == 0) {
                courses.saveAll(List.of(
                        new Course("Introduction to Computer Science", "CS101", 4),
                        new Course("Data Structures and Algorithms", "CS202", 4),
                        new Course("Database Management Systems", "CS305", 3),
                        new Course("Applied Mathematics", "MA201", 3),
                        new Course("Communication Skills", "HU110", 2)
                ));
            }

            if (attendance.count() == 0) {
                attendance.saveAll(List.of(
                        new Attendance(101L, "CS101", today.minusDays(14), "Present"),
                        new Attendance(101L, "CS202", today.minusDays(13), "Present"),
                        new Attendance(101L, "CS305", today.minusDays(12), "Present"),
                        new Attendance(101L, "MA201", today.minusDays(11), "Absent"),
                        new Attendance(101L, "HU110", today.minusDays(10), "Present"),
                        new Attendance(101L, "CS101", today.minusDays(9), "Present"),
                        new Attendance(101L, "CS202", today.minusDays(8), "Late"),
                        new Attendance(101L, "CS305", today.minusDays(7), "Present"),
                        new Attendance(101L, "MA201", today.minusDays(6), "Present"),
                        new Attendance(101L, "HU110", today.minusDays(5), "Present"),
                        new Attendance(101L, "CS101", today.minusDays(4), "Present"),
                        new Attendance(101L, "CS202", today.minusDays(3), "Present")
                ));
            }

            if (timetable.count() == 0) {
                timetable.saveAll(List.of(
                        classSlot("CS101", "Introduction to Computer Science", "Monday", "09:00", "10:30", "A-201", "Dr. Ananya Rao"),
                        classSlot("MA201", "Applied Mathematics", "Monday", "11:00", "12:30", "B-105", "Prof. Arjun Mehta"),
                        classSlot("CS202", "Data Structures and Algorithms", "Tuesday", "09:00", "10:30", "A-304", "Dr. Kavita Shah"),
                        classSlot("CS305", "Database Management Systems", "Tuesday", "11:00", "12:30", "C-210", "Prof. Rohan Iyer"),
                        classSlot("HU110", "Communication Skills", "Wednesday", "10:00", "11:00", "D-102", "Ms. Mira Nair"),
                        classSlot("CS101", "Introduction to Computer Science", "Wednesday", "13:00", "14:30", "A-201", "Dr. Ananya Rao"),
                        classSlot("CS305", "Database Management Systems", "Thursday", "09:00", "10:30", "C-210", "Prof. Rohan Iyer"),
                        classSlot("MA201", "Applied Mathematics", "Thursday", "11:00", "12:30", "B-105", "Prof. Arjun Mehta"),
                        classSlot("CS202", "Data Structures and Algorithms", "Friday", "09:00", "10:30", "A-304", "Dr. Kavita Shah"),
                        classSlot("HU110", "Communication Skills", "Friday", "13:00", "14:00", "D-102", "Ms. Mira Nair")
                ));
            }

            if (assignments.count() == 0) {
                assignments.saveAll(List.of(
                        new Assignment("Build a responsive course page", "CS101", "Create an accessible course overview using semantic HTML and responsive CSS.", today.plusDays(2), "Dr. Ananya Rao"),
                        new Assignment("Linked list implementation", "CS202", "Implement and analyse singly and doubly linked list operations.", today.plusDays(4), "Dr. Kavita Shah"),
                        new Assignment("Campus database schema", "CS305", "Design an ER diagram and normalized schema for a campus service.", today.plusDays(8), "Prof. Rohan Iyer"),
                        new Assignment("Applied statistics worksheet", "MA201", "Solve the probability and descriptive statistics problem set.", today.plusDays(11), "Prof. Arjun Mehta")
                ));
            }

            if (exams.count() == 0) {
                exams.saveAll(List.of(
                        new Exam("Data Structures Midterm", "CS202", today.plusDays(7), LocalTime.of(10, 0), 90, 50, "Dr. Kavita Shah"),
                        new Exam("Database Systems Quiz", "CS305", today.plusDays(12), LocalTime.of(14, 0), 60, 30, "Prof. Rohan Iyer"),
                        new Exam("Mathematics Unit Test", "MA201", today.plusDays(16), LocalTime.of(9, 30), 90, 50, "Prof. Arjun Mehta")
                ));
            }

            if (results.count() == 0) {
                results.saveAll(List.of(
                        new Result(101L, "Student 101", "CS101", "Programming Fundamentals Quiz", 18, 20, "A", today.minusDays(8)),
                        new Result(101L, "Student 101", "MA201", "Algebra Assignment", 42, 50, "A-", today.minusDays(5)),
                        new Result(101L, "Student 101", "HU110", "Presentation Skills", 24, 30, "B+", today.minusDays(2))
                ));
            }
        };
    }

    private static Timetable classSlot(String courseCode, String courseName,
                                       String day, String start, String end,
                                       String room, String faculty) {
        Timetable slot = new Timetable();
        slot.setCourseCode(courseCode);
        slot.setCourseName(courseName);
        slot.setDayOfWeek(day);
        slot.setStartTime(LocalTime.parse(start));
        slot.setEndTime(LocalTime.parse(end));
        slot.setRoomNumber(room);
        slot.setFacultyName(faculty);
        return slot;
    }

}
