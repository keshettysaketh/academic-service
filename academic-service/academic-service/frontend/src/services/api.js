
import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8081/api",
  headers: {
    "Content-Type": "application/json",
  },
});

// ================= COURSES =================
export const courseAPI = {
  getAll: () => api.get("/courses"),
  getById: (id) => api.get(`/courses/${id}`),
  create: (data) => api.post("/courses", data),
  update: (id, data) => api.put(`/courses/${id}`, data),
  delete: (id) => api.delete(`/courses/${id}`),
};

// ================= ATTENDANCE =================
export const attendanceAPI = {
  getAll: () => api.get("/attendance"),
  getById: (id) => api.get(`/attendance/${id}`),
  getByStudent: (studentId) =>
    api.get(`/attendance/student/${studentId}`),
  getByCourse: (courseCode) =>
    api.get(`/attendance/course/${courseCode}`),
  create: (data) => api.post("/attendance", data),
  update: (id, data) => api.put(`/attendance/${id}`, data),
  delete: (id) => api.delete(`/attendance/${id}`),
};

// ================= TIMETABLE =================
export const timetableAPI = {
  getAll: () => api.get("/timetable"),
  getById: (id) => api.get(`/timetable/${id}`),
  getByCourse: (courseCode) =>
    api.get(`/timetable/course/${courseCode}`),
  getByDay: (day) => api.get(`/timetable/day/${day}`),
  getByFaculty: (facultyName) =>
    api.get(`/timetable/faculty/${facultyName}`),
  create: (data) => api.post("/timetable", data),
  update: (id, data) => api.put(`/timetable/${id}`, data),
  delete: (id) => api.delete(`/timetable/${id}`),
};

// ================= ASSIGNMENTS =================
export const assignmentAPI = {
  getAll: () => api.get("/assignments"),
  getById: (id) => api.get(`/assignments/${id}`),
  getByCourse: (courseCode) =>
    api.get(`/assignments/course/${courseCode}`),
  getByFaculty: (facultyName) =>
    api.get(`/assignments/faculty/${encodeURIComponent(facultyName)}`),
  create: (data) => api.post("/assignments", data),
  update: (id, data) => api.put(`/assignments/${id}`, data),
  delete: (id) => api.delete(`/assignments/${id}`),
};

// ================= EXAMS =================
export const examAPI = {
  getAll: () => api.get("/exams"),
  getById: (id) => api.get(`/exams/${id}`),
  getByCourse: (courseCode) =>
    api.get(`/exams/course/${courseCode}`),
  getByName: (examName) =>
    api.get(`/exams/name/${encodeURIComponent(examName)}`),
  getByFaculty: (facultyName) =>
    api.get(`/exams/faculty/${encodeURIComponent(facultyName)}`),
  create: (data) => api.post("/exams", data),
  update: (id, data) => api.put(`/exams/${id}`, data),
  delete: (id) => api.delete(`/exams/${id}`),
};

// ================= RESULTS =================
export const resultAPI = {
  getAll: () => api.get("/results"),
  getById: (id) => api.get(`/results/${id}`),
  getByStudent: (studentId) =>
    api.get(`/results/student/${studentId}`),
  getByCourse: (courseCode) =>
    api.get(`/results/course/${courseCode}`),
  create: (data) => api.post("/results", data),
  update: (id, data) => api.put(`/results/${id}`, data),
  delete: (id) => api.delete(`/results/${id}`),
};

// Export default Axios instance
export default api;
