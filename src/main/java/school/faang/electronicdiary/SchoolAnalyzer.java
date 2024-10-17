package school.faang.electronicdiary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SchoolAnalyzer {
    public static Map<String, Double> calculateAverageScorePerSubject(List<Student> students) {
        Map<String, List<Integer>> subjectScores = new HashMap<>();

        for (Student student : students) {
            student.getCourses().forEach((subject, scores) -> {
                subjectScores.putIfAbsent(subject, new ArrayList<>());
                subjectScores.get(subject).addAll(scores);
            });
        }

        return subjectScores.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0)
                ));
    }

    public static Map<String, Integer> getFinalGradesForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .map(student -> student.getCourses().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream()
                                        .mapToInt(Integer::intValue)
                                        .average()
                                        .orElse(0.0))
                        )))
                .orElse(new HashMap<>());
    }

    public static String findHardestSubject(List<Student> students) {
        Map<String, Double> averageScores = calculateAverageScorePerSubject(students);

        return averageScores.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No subjects found");
    }

    public static void printPerformanceTable(List<Student> students) {
        Set<String> allSubjects = students.stream()
                .flatMap(student -> student.getCourses().keySet().stream())
                .collect(Collectors.toSet());

        System.out.print("Name           | ");
        allSubjects.forEach(subject -> System.out.print(subject + " | "));
        System.out.println("% | Final Grade");

        for (Student student : students) {
            String fullName = student.getFirstName() + " " + student.getLastName();
            System.out.print(fullName + " | ");

            Map<String, Integer> finalGrades = getFinalGradesForStudent(students, student.getFirstName(), student.getLastName());
            double totalAverage = finalGrades.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
            double performancePercent = (totalAverage / 5) * 100;

            allSubjects.forEach(subject -> {
                Integer grade = finalGrades.get(subject);
                if (grade != null) {
                    System.out.print(grade + " | ");
                } else {
                    System.out.print("N/A | ");
                }
            });

            System.out.printf("%.1f%% | %.1f%n", performancePercent, totalAverage);
        }
    }
}

