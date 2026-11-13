
package com.smartcampus.academicservice.service;

import com.smartcampus.academicservice.entity.Timetable;
import com.smartcampus.academicservice.repository.TimetableRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    // Get all timetable records
    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }

    // Get timetable by ID
    public Timetable getTimetableById(Long id) {
        return timetableRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Timetable not found with ID: " + id));
    }

    // Get timetable by course code
    public List<Timetable> getTimetableByCourseCode(String courseCode) {
        return timetableRepository.findByCourseCode(courseCode);
    }

    // Get timetable by day
    public List<Timetable> getTimetableByDay(String dayOfWeek) {
        return timetableRepository.findByDayOfWeek(dayOfWeek);
    }

    // Get timetable by faculty
    public List<Timetable> getTimetableByFaculty(String facultyName) {
        return timetableRepository.findByFacultyName(facultyName);
    }

    // Get timetable by course code and day
    public List<Timetable> getTimetableByCourseAndDay(
            String courseCode, String dayOfWeek) {

        return timetableRepository.findByCourseCodeAndDayOfWeek(
                courseCode, dayOfWeek);
    }

    // Add timetable
    public Timetable createTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    // Update timetable
    public Timetable updateTimetable(Long id, Timetable updatedTimetable) {

        Timetable existingTimetable = getTimetableById(id);

        updatedTimetable.setId(existingTimetable.getId());

        return timetableRepository.save(updatedTimetable);
    }

    // Delete timetable
    public void deleteTimetable(Long id) {
        Timetable timetable = getTimetableById(id);
        timetableRepository.delete(timetable);
    }
}
