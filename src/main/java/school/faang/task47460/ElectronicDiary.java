package school.faang.task47460;

import java.util.*;
import java.util.stream.Collectors;

public class ElectronicDiary {
    public static Map<String, Double> averageGrade(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.subjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue))
                ));
    }

    public static Map<String, Integer> finalGrade(List<Student> students, String firstName, String lastName) {

        return students.stream()
                .filter(student -> student.firstName().equals(firstName) && student.lastName().equals(lastName))
                .findFirst()
                .map(student -> student.subjects().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream()
                                        .mapToInt(Integer::intValue).average().orElse(0.0))
                        ))).orElse(Collections.emptyMap());
    }

    private static Map<String, Double> averageGradeStudent(List<Student> students, String firsName, String lastName) {
        return students.stream()
                .filter(student -> student.firstName().equals(firsName) && student.lastName().equals(lastName))
                .findFirst()
                .map(student2 -> student2.subjects().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue().stream()
                                        .mapToDouble(Integer::doubleValue).average().orElse(0.0))))
                .orElse(Collections.emptyMap());
    }

    public static String hardSubject(List<Student> students) {
        return averageGrade(students).entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Данных нет");

    }

    public static void printResults(List<Student> students) {
        System.out.printf("%-20s|", "ФИО");
        averageGrade(students).forEach((key, value) -> System.out.printf("%-15s|", key));
        System.out.printf("%-5s|", "%");
        System.out.printf("%s|%n", "Итоговая оценка");

        Set<String> subjects = averageGrade(students).keySet();

        students.sort(Comparator.comparing(Student::firstName));

        students.forEach(student -> {
            System.out.printf("%-20s|", student.firstName() + " " + student.lastName());

            Map<String, Double> averagedGradeStudent =
                    averageGradeStudent(students, student.firstName(), student.lastName());
            Map<String, Integer> finalGradeStudent = finalGrade(students, student.firstName(), student.lastName());

            subjects.forEach(subject -> {
                double grade = averagedGradeStudent.getOrDefault(subject, 0.0);
                System.out.printf("%15.1f|", grade);
            });

            int count = averagedGradeStudent.values().size();
            double percent = averagedGradeStudent.values()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .sum() / count / 5 * 100;

            System.out.printf("%5.0f|", percent);
            System.out.printf("%15d|%n", Math.round(finalGradeStudent
                    .values().stream().mapToInt(Integer::intValue).average().orElse(0)));

        });


    }
}
