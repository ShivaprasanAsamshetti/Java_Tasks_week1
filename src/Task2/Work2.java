package Task2;

import java.util.Arrays;
import java.util.List;

public class Work2 {
    public static void main(String args[]) {
        Student shiva = new Student(1, "shiva", Arrays.asList("java", "golang"), "Btech", 4, "java", 30000.0);

        course obj2 = new course(1, "Java full stack", "hard", "java tech stack", 27000.0, "7 months", 9.0);

        course obj3 = new course(2, "python full stack", "medium", "python tech stack", 25000.0, "6 months", 10.0);

        course obj4 = new course(3, "java full stack", "easy", "core java", 15000.0, "4 months", 6.0);

        course obj5 = new course(4, "data science course", "medium", "data science", 17000.0, "4 months", 7.0);

        course obj6 = new course(5, "spring boot course", "hard", "spring boot", 50000.0, "6 months", 10.0);
        List<course> courses = Arrays.asList(obj2, obj3, obj4, obj5, obj6);

        List<course> res = courses.stream()
                .filter(e -> shiva.getSkills().stream()
                        .anyMatch(skill -> e.getTechnology().toLowerCase().contains(skill.toLowerCase())))
                .filter(e -> e.getFee() < shiva.getBudget())
                .filter(e -> {
                    if (shiva.getExperience() == 0) return e.getLevel().equals("easy");
                    else if (shiva.getExperience() >= 3) return e.getLevel().equals("hard");
                    return e.getLevel().equals("medium");
                }).sorted((c1, c2) -> Double.compare(c2.getRating(), c1.getRating()))
                .toList();

        res.forEach(System.out::println);


    }
}
