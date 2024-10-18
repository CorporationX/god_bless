package school.faang.electronicdiary;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SchoolAnalyzer {

    public static Map<String, Double> calculateAverageGradePerSubject(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey, // Group by subject name
                        Collectors.flatMapping(
                                entry -> entry.getValue().stream(), // Flatten list of grades
                                Collectors.averagingDouble(Integer::doubleValue) // Calculate average
                        )
                ));
    }

    public static Map<String, Integer> getFinalGradesForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equalsIgnoreCase(firstName) &&
                        student.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .map(student -> student.getCourses().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream()
                                        .mapToInt(Integer::intValue).average().orElse(0.0))
                        ))
                ).orElse(Collections.emptyMap());
    }

    public static String findMostDifficultSubject(List<Student> students) {
        Map<String, Double> averageGrades = calculateAverageGradePerSubject(students);
        return averageGrades.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No Data");
    }

    public static void printPerformanceTable(List<Student> students) {
        Set<String> subjects = students.stream()
                .flatMap(student -> student.getCourses().keySet().stream())
                .collect(Collectors.toSet());

        System.out.printf("%-20s", "Full Name");
        subjects.forEach(subject -> System.out.printf("%-12s", subject));
        System.out.printf("%-15s%-15s%n", "Performance (%)", "Final Grade");

        students.forEach(student -> {
            System.out.printf("%-20s", student.getFirstName() + " " + student.getLastName());

            Map<String, Integer> finalGrades = getFinalGradesForStudent(students, student.getFirstName(), student.getLastName());
            double totalGradeSum = subjects.stream().mapToInt(subject -> finalGrades.getOrDefault(subject, 0)).sum();
            subjects.forEach(subject -> {
                int grade = finalGrades.getOrDefault(subject, 0);
                System.out.printf("%-12d", grade);
            });

            double percentage = (totalGradeSum / (subjects.size() * 5.0)) * 100;
            double finalGrade = totalGradeSum / (double) subjects.size();

            System.out.printf("%-15.2f%-15.1f%n", percentage, finalGrade);
        });
    }
}

