
package com.smartcampus.academicservice.service;

import com.smartcampus.academicservice.entity.Attendance;
import com.smartcampus.academicservice.repository.AttendanceRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    // Constructor injection
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // Add attendance
    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Get all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get attendance by ID
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Attendance not found with ID: " + id));
    }

    // Get attendance by student ID
    public List<Attendance> getAttendanceByStudentId(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    // Get attendance by course code
    public List<Attendance> getAttendanceByCourseCode(String courseCode) {
        return attendanceRepository.findByCourseCode(courseCode);
    }

    // Update attendance
    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {

        Attendance existingAttendance = getAttendanceById(id);

        existingAttendance.setStudentId(updatedAttendance.getStudentId());
        existingAttendance.setCourseCode(updatedAttendance.getCourseCode());
        existingAttendance.setAttendanceDate(updatedAttendance.getAttendanceDate());
        existingAttendance.setStatus(updatedAttendance.getStatus());

        return attendanceRepository.save(existingAttendance);
    }

    // Delete attendance
    public void deleteAttendance(Long id) {
        Attendance attendance = getAttendanceById(id);
        attendanceRepository.delete(attendance);
    }
}
