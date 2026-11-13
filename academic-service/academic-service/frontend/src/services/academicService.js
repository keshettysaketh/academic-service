const BASE_URL = import.meta.env.VITE_API_URL || "http://localhost:8081/api";

async function request(path, options = {}) {
  let response;
  try {
    response = await fetch(`${BASE_URL}${path}`, {
      ...options,
      headers: { "Content-Type": "application/json", ...options.headers },
      body: options.body ? JSON.stringify(options.body) : undefined,
    });
  } catch {
    throw new Error("Can’t reach the academic service. Make sure the backend is running on port 8081.");
  }
  if (!response.ok) {
    const detail = await response.text().catch(() => "");
    throw new Error(detail || `Request failed (${response.status}). Please try again.`);
  }
  if (response.status === 204) return null;
  const text = await response.text();
  if (!text) return null;
  try { return JSON.parse(text); } catch { return text; }
}

const collection = path => ({
  getAll: () => request(`/${path}`),
  create: data => request(`/${path}`, { method:"POST", body:data }),
  update: (id,data) => request(`/${path}/${id}`, { method:"PUT", body:data }),
  remove: id => request(`/${path}/${id}`, { method:"DELETE" }),
});

const courses = collection("courses");
const attendance = collection("attendance");
const timetable = collection("timetable");
const assignments = collection("assignments");
const exams = collection("exams");
const results = collection("results");

const academicService = {
  getCourses: courses.getAll, createCourse: courses.create, updateCourse:courses.update, deleteCourse:courses.remove,
  getAttendance: attendance.getAll, createAttendance:attendance.create, updateAttendance:attendance.update, deleteAttendance:attendance.remove,
  getAttendanceByStudent: studentId => request(`/attendance/student/${encodeURIComponent(studentId)}`),
  getTimetable: timetable.getAll, createTimetable:timetable.create, updateTimetable:timetable.update, deleteTimetable:timetable.remove,
  getAssignments: assignments.getAll, createAssignment:assignments.create, updateAssignment:assignments.update, deleteAssignment:assignments.remove,
  getExams: exams.getAll, createExam:exams.create, updateExam:exams.update, deleteExam:exams.remove,
  getResults: results.getAll, createResult:results.create, updateResult:results.update, deleteResult:results.remove,
  getResultsByStudent: studentId => request(`/results/student/${encodeURIComponent(studentId)}`),
};

export const getCourses=academicService.getCourses;
export const getAttendance=academicService.getAttendance;
export const getAssignments=academicService.getAssignments;
export const getResults=academicService.getResults;
export const getTimetable=academicService.getTimetable;
export const getExams=academicService.getExams;
export const getAttendanceByStudent=academicService.getAttendanceByStudent;
export const getResultsByStudent=academicService.getResultsByStudent;
export default academicService;
