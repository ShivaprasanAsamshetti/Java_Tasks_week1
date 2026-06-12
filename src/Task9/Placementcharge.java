package Task9;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Placementcharge {

    public static void main(String[] args) {

        InterviewFeedback ravi =
                new InterviewFeedback(
                        101,
                        "Ravi",
                        8.0,
                        7.0,
                        8.0,
                        7.0,
                        9.0,
                        List.of("Java", "SQL"),
                        List.of("Coding"),
                        List.of("Communication", "System Design")
                );

        // Calculate Overall Rating
        Function<InterviewFeedback, Double> overallRating = feedback -> {

            double total =
                    feedback.getTechnicalRating()
                            + feedback.getCommunicationRating()
                            + feedback.getCodingRating()
                            + feedback.getConfidenceRating()
                            + feedback.getProblemSolvingRating();

            return total / 5;
        };

        // Performance Status
        Function<Double, String> performanceStatus = rating -> {

            if (rating >= 8) {
                return "Excellent";
            } else if (rating >= 6) {
                return "Good";
            } else if (rating >= 4) {
                return "Average";
            } else {
                return "Needs Improvement";
            }
        };

        // Placement Eligibility
        Predicate<InterviewFeedback> placementEligible = feedback -> {

            double overall = overallRating.apply(feedback);

            return overall >= 6
                    && feedback.getCodingRating() >= 6;
        };

        // Improvement Suggestions
        Consumer<InterviewFeedback> suggestions = feedback -> {

            System.out.print("Suggestions: ");

            for (String weakness : feedback.getWeaknesses()) {
                System.out.print(weakness + " ");
            }

            System.out.println();
        };

        // Report

        double overall = overallRating.apply(ravi);

        String status = performanceStatus.apply(overall);

        boolean eligible = placementEligible.test(ravi);

        System.out.println("Student: "
                + ravi.getStudentName());

        System.out.println("Overall Rating: "
                + overall);

        System.out.println("Performance: "
                + status);

        System.out.println("Placement Eligible: "
                + (eligible ? "Yes" : "No"));

        suggestions.accept(ravi);
    }
}