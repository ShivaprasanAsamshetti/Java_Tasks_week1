package Task2;

public class course {
    private Integer courseId;
    private String courseName;
    private String technology;
    private String level;
    private Double fee;

    public Integer getCourseId() {
        return courseId;
    }

    public course(Integer courseId, String courseName, String level, String technology, Double fee, String duration, Double rating) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.level = level;
        this.technology = technology;
        this.fee = fee;
        this.duration = duration;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", technology='" + technology + '\'' +
                ", level='" + level + '\'' +
                ", fee=" + fee +
                ", duration='" + duration + '\'' +
                ", rating=" + rating +
                '}';
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    private String duration;
    private Double rating;
}
