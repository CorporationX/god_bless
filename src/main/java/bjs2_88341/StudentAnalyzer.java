package bjs2_88341;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.Set;

public class StudentAnalyzer {

    public static Map<String, Double> calculateAverageGradePerSubject(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue))
                ));
    }

    public static Map<String, Integer> getFinalGradesForStudent(List<Student> students,
                                                                String firstName, String lastName) {
        return students.stream()
                .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .findFirst()
                .map(student -> student.getSubjects().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream()
                                        .mapToInt(Integer::intValue)
                                        .average()
                                        .orElse(0.0))
                        ))
                ).orElse(Collections.emptyMap());
    }

    public static String findMostDifficultSubject(List<Student> students) {
        Map<String, Double> avgGrades = calculateAverageGradePerSubject(students);
        return avgGrades.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет данных");
    }

    public static void printPerformanceTable(List<Student> students) {
        Set<String> subjects = students.stream()
                .flatMap(s -> s.getSubjects().keySet().stream())
                .collect(Collectors.toSet());

        System.out.printf("%-20s", "ФИО");
        subjects.forEach(subj -> System.out.printf("%-12s", subj));
        System.out.printf("%-15s%-10s%n", "Успеваемость (%)", "Итог");

        for (Student s : students) {
            System.out.printf("%-20s", s.getFirstName() + " " + s.getLastName());
            Map<String, Integer> finalGrades = getFinalGradesForStudent(students, s.getFirstName(), s.getLastName());

            double total = 0;
            for (String subj : subjects) {
                int grade = finalGrades.getOrDefault(subj, 0);
                System.out.printf("%-12d", grade);
                total += grade;
            }

            double percentage = (total / (subjects.size() * 5.0)) * 100;
            double avg = total / subjects.size();

            System.out.printf("%-15.2f%-10.1f%n", percentage, avg);
        }
    }
}