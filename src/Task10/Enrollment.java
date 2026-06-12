package Task10;

import java.time.LocalDate;

public class Enrollment {
    private Integer enrollmentId;
    private Integer studentId;
    private Integer courseId;
    private LocalDate admissionDate;

    public Enrollment(Integer enrollmentId,
                      Integer studentId,
                      Integer courseId,
                      LocalDate admissionDate) {

        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.admissionDate = admissionDate;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", admissionDate=" + admissionDate +
                '}';
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
}
