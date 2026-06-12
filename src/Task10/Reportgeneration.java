package Task10;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@FunctionalInterface
 interface ReportGenerator<T, R> {
    R generate(List<T> data);
}

public class Reportgeneration {

        public static void main(String[] args) {

            List<Student> students = List.of(
                    new Student(1, "Prasad"),
                    new Student(2, "Rahul"),
                    new Student(3, "Kiran"),
                    new Student(4, "Sneha"),
                    new Student(5, "Priya")
            );

            List<Course> courses = List.of(
                    new Course(101, "Java Fullstack", 50000.0, "Ashok"),
                    new Course(102, "Python Fullstack", 45000.0, "Ravi"),
                    new Course(103, "DevOps", 40000.0, "Kumar"),
                    new Course(104, "Data Science", 70000.0, "Ashok"),
                    new Course(105, "AI & ML", 80000.0, "Ravi")
            );

            List<Payment> payments = List.of(
                    new Payment(1, 1, 50000.0, "PAID"),
                    new Payment(2, 2, 45000.0, "PAID"),
                    new Payment(3, 3, 40000.0, "PENDING"),
                    new Payment(4, 4, 70000.0, "PAID"),
                    new Payment(5, 5, 80000.0, "PENDING")
            );

            List<Enrollment> enrollments = List.of(
                    new Enrollment(1, 1, 101, LocalDate.of(2025, 1, 10)),
                    new Enrollment(2, 2, 102, LocalDate.of(2025, 1, 15)),
                    new Enrollment(3, 3, 103, LocalDate.of(2025, 2, 20)),
                    new Enrollment(4, 4, 104, LocalDate.of(2025, 2, 25)),
                    new Enrollment(5, 5, 105, LocalDate.of(2025, 3, 5))
            );

            ReportGenerator<Payment, Double> totalRevenue =
                    data -> data.stream()
                            .filter(p -> p.getStatus().equalsIgnoreCase("PAID"))
                            .collect(Collectors.summingDouble(Payment::getAmount));

            System.out.println("\nTotal Revenue : ₹" +
                    totalRevenue.generate(payments));



            ReportGenerator<Payment, Double> pendingPayments =
                    data -> data.stream()
                            .filter(p -> p.getStatus().equalsIgnoreCase("PENDING"))
                            .collect(Collectors.summingDouble(Payment::getAmount));

            System.out.println("Pending Payments : ₹" +
                    pendingPayments.generate(payments));



            System.out.println("\nCourse Wise Enrollment Report:");

            Map<Integer, Long> enrollmentReport =
                    enrollments.stream()
                            .collect(Collectors.groupingBy(
                                    Enrollment::getCourseId,
                                    Collectors.counting()
                            ));

            enrollmentReport.forEach((courseId, count) -> {

                String courseName = courses.stream()
                        .filter(c -> c.getCourseId().equals(courseId))
                        .map(Course::getCourseName)
                        .findFirst()
                        .orElse("Unknown Course");

                System.out.println(courseName + " : " + count + " Student(s)");
            });
        }
    }

