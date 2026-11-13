
import React, { useEffect, useState } from "react";
import { getAttendanceByStudent } from "../services/academicService";

function Attendance({ studentId }) {
  const [attendance, setAttendance] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function loadAttendance() {
      try {
        const data = await getAttendanceByStudent(studentId);
        setAttendance(data);
      } catch (err) {
        setError("Unable to load attendance records.");
      } finally {
        setLoading(false);
      }
    }

    loadAttendance();
  }, [studentId]);

  if (loading) return <p>Loading attendance...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div className="content-card">
      <h1>Attendance</h1>

      {attendance.length === 0 ? (
        <p>No attendance records found.</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Course Code</th>
              <th>Date</th>
              <th>Status</th>
            </tr>
          </thead>

          <tbody>
            {attendance.map((record) => (
              <tr key={record.id}>
                <td>{record.courseCode}</td>
                <td>{record.attendanceDate}</td>
                <td>{record.status}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default Attendance;
