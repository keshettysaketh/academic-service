
import { useEffect, useState } from "react";
import academicService from "../services/academicService";

function Courses() {
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    academicService
      .getCourses()
      .then((data) => {
        setCourses(data);
      })
      .catch((err) => {
        setError(err.message);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <h2>Loading courses...</h2>;
  }

  if (error) {
    return <h2>Error: {error}</h2>;
  }

  return (
    <div className="page-content">
      <h1>Courses</h1>

      {courses.length === 0 ? (
        <p>No courses available.</p>
      ) : (
        <div className="course-grid">
          {courses.map((course) => (
            <div className="course-card" key={course.id}>
              <h2>{course.courseName}</h2>
              <p>Course Code: {course.courseCode}</p>
              <p>Credits: {course.credits}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default Courses;
