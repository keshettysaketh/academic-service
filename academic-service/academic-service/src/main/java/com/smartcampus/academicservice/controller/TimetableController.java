
package com.smartcampus.academicservice.controller;

import com.smartcampus.academicservice.entity.Timetable;
import com.smartcampus.academicservice.service.TimetableService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
@CrossOrigin(origins = "http://localhost:5173")
public class TimetableController {

    private final TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    // Get all timetable records
    @GetMapping
    public List<Timetable> getAllTimetables() {
        return timetableService.getAllTimetables();
    }

    // Get timetable by ID
    @GetMapping("/{id}")
    public Timetable getTimetableById(@PathVariable Long id) {
        return timetableService.getTimetableById(id);
    }

    // Get timetable by course code
    @GetMapping("/course/{courseCode}")
    public List<Timetable> getTimetableByCourseCode(
            @PathVariable String courseCode) {
        return timetableService.getTimetableByCourseCode(courseCode);
    }

    // Get timetable by day
    @GetMapping("/day/{dayOfWeek}")
    public List<Timetable> getTimetableByDay(
            @PathVariable String dayOfWeek) {
        return timetableService.getTimetableByDay(dayOfWeek);
    }

    // Get timetable by faculty
    @GetMapping("/faculty/{facultyName}")
    public List<Timetable> getTimetableByFaculty(
            @PathVariable String facultyName) {
        return timetableService.getTimetableByFaculty(facultyName);
    }

    // Get timetable by course and day
    @GetMapping("/course/{courseCode}/day/{dayOfWeek}")
    public List<Timetable> getTimetableByCourseAndDay(
            @PathVariable String courseCode,
            @PathVariable String dayOfWeek) {
        return timetableService.getTimetableByCourseAndDay(
                courseCode, dayOfWeek);
    }

    // Add timetable
    @PostMapping
    public Timetable createTimetable(@RequestBody Timetable timetable) {
        return timetableService.createTimetable(timetable);
    }

    // Update timetable
    @PutMapping("/{id}")
    public Timetable updateTimetable(
            @PathVariable Long id,
            @RequestBody Timetable timetable) {
        return timetableService.updateTimetable(id, timetable);
    }

    // Delete timetable
    @DeleteMapping("/{id}")
    public String deleteTimetable(@PathVariable Long id) {
        timetableService.deleteTimetable(id);
        return "Timetable deleted successfully";
    }
}
