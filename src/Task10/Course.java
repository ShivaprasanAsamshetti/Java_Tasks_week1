package Task10;

public class Course {
    private Integer courseId;
    private String courseName;
    private Double fee;
    private String trainerName;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", fee=" + fee +
                ", trainerName='" + trainerName + '\'' +
                '}';
    }

    public Course(Integer courseId, String courseName, Double fee, String trainerName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
        this.trainerName = trainerName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Double getFee() {
        return fee;
    }

    public String getTrainerName() {
        return trainerName;
    }
}
