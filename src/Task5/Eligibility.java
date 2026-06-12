package Task5;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Eligibility {

    public static void main(String[] args) {

        Student s1 = new Student(
                1, "Ravi", "Java Fullstack",
                2024, 75.0, 0, 4.8,
                Arrays.asList("java", "sql"),
                true, true);

        Student s2 = new Student(
                2, "Sneha", "Python Fullstack",
                2023, 82.0, 0, 4.6,
                Arrays.asList("python", "django"),
                true, true);

        Student s3 = new Student(
                3, "Kiran", "Java Fullstack",
                2021, 58.0, 2, 3.5,
                Arrays.asList("c", "cpp"),
                false, true);

        List<Student> students = Arrays.asList(s1, s2, s3);

        // Predicates

        Predicate<Student> gradRule =
                s -> s.getGraduationYear() >= 2022;

        Predicate<Student> percentageRule =
                s -> s.getPercentage() >= 60;

        Predicate<Student> backlogRule =
                s -> s.getBacklogs() == 0;

        Predicate<Student> ratingRule =
                s -> s.getMockRating() >= 4;

        Predicate<Student> resumeRule =
                s -> s.getResumeAvailable();

        Predicate<Student> feeRule =
                s -> s.getFeePaid();

        Predicate<Student> skillRule =
                s -> s.getSkills().contains("java")
                        || s.getSkills().contains("python");

        Predicate<Student> eligibility =
                gradRule
                        .and(percentageRule)
                        .and(backlogRule)
                        .and(ratingRule)
                        .and(resumeRule)
                        .and(feeRule)
                        .and(skillRule);



        Consumer<Student> printStudent =
                s -> System.out.println(
                        s.getStudentName()
                                + " - "
                                + s.getCourseName()
                                + " - Rating: "
                                + s.getMockRating()
                );

        // Function

        Function<Student, String> studentInfo =
                s -> s.getStudentName()
                        + " - "
                        + s.getCourseName();

        List<Student> eligibleStudents = new ArrayList<>();
        List<Student> rejectedStudents = new ArrayList<>();

        for (Student s : students) {

            if (eligibility.test(s)) {
                eligibleStudents.add(s);
            } else {
                rejectedStudents.add(s);
            }
        }

        // Comparator

        eligibleStudents.sort(
                Comparator.comparing(Student::getMockRating)
                        .reversed()
        );

        System.out.println("Eligible Students For Placement:");

        eligibleStudents.forEach(printStudent);

        System.out.println("\nRejected Students:");

        for (Student s : rejectedStudents) {

            List<String> reasons = new ArrayList<>();

            if (!gradRule.test(s))
                reasons.add("Graduation year below 2022");

            if (!percentageRule.test(s))
                reasons.add("Percentage below 60");

            if (!backlogRule.test(s))
                reasons.add("Backlogs available");

            if (!ratingRule.test(s))
                reasons.add("Mock rating below 4");

            if (!resumeRule.test(s))
                reasons.add("Resume missing");

            if (!feeRule.test(s))
                reasons.add("Fee not paid");

            if (!skillRule.test(s))
                reasons.add("Java/Python skill missing");

            System.out.println(
                    studentInfo.apply(s)
                            + " - Reason: "
                            + String.join(", ", reasons)
            );
        }

        // Grouping by Course

        Map<String, List<Student>> groupedStudents =
                new HashMap<>();

        for (Student s : students) {

            groupedStudents
                    .computeIfAbsent(
                            s.getCourseName(),
                            k -> new ArrayList<>())
                    .add(s);
        }

        System.out.println("\nStudents Grouped By Course:");

        groupedStudents.forEach((course, studentList) -> {

            System.out.println(course);

            studentList.forEach(
                    st -> System.out.println(
                            "   " + st.getStudentName()
                    )
            );
        });
    }
}