
package com.smartcampus.academicservice.repository;

import com.smartcampus.academicservice.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository
        extends JpaRepository<Timetable, Long> {

    // Find timetable by course code
    List<Timetable> findByCourseCode(String courseCode);

    // Find timetable by day
    List<Timetable> findByDayOfWeek(String dayOfWeek);

    // Find timetable by faculty
    List<Timetable> findByFacultyName(String facultyName);

    // Find timetable by course and day
    List<Timetable> findByCourseCodeAndDayOfWeek(
            String courseCode, String dayOfWeek);
}
