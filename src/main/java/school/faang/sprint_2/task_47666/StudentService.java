package school.faang.sprint_2.task_47666;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentService {

    public Map<String, Double> getAverageSchoolGrade(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }
        return students.stream()
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingInt(Integer::intValue))
                ));
    }

    public Map<String, Integer> getFinalStudentGrades(List<Student> students, String firstName, String lastName) {
        if (students == null && firstName.isEmpty() && lastName.isEmpty()) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }
        if (firstName.isEmpty() && lastName.isEmpty()) {
            throw new IllegalArgumentException("Не верный входные параметры");
        }
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .map(student -> student.getSubjects().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream()
                                        .mapToInt(Integer::intValue).average().orElse(0.0))
                        ))
                ).orElse(Collections.emptyMap());
    }

    public String getMostDifficultSubject(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }
        Map<String, Double> averageSchoolGrades = getAverageSchoolGrade(students);
        return averageSchoolGrades.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет данных");
    }

    public void printPerformanceTable(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }
        Set<String> subjects = students.stream()
                .flatMap(student -> student.getSubjects().keySet().stream())
                .collect(Collectors.toSet());

        System.out.printf("|%-20s | ", "ФИО");
        subjects.forEach(subject -> System.out.printf("%-13s | ", subject));
        System.out.printf("%-13s | %-16s%n", "Успеваемость", "Итоговая оценка |");

        students.forEach(student -> {
            System.out.printf("|%-20s | ", student.getFirstName() + " " + student.getLastName());

            Map<String, Integer> finalStudentGrades =
                    getFinalStudentGrades(students, student.getFirstName(), student.getLastName());
            double total = subjects.stream()
                    .mapToInt(subject -> finalStudentGrades.getOrDefault(subject, 0)).sum();

            subjects.forEach(subject -> {
                int grade = finalStudentGrades.getOrDefault(subject, 0);
                System.out.printf("%-13d | ", grade);
            });

            double percentage = (total / (subjects.size() * 5)) * 100;
            double finalGrade = total / (double) subjects.size();

            System.out.printf("%-13.2f | %-16.1f|%n", percentage, finalGrade);
        });

    }
}
