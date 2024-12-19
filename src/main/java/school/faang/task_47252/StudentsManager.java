package school.faang.task_47252;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentsManager {
    public Map<String, Double> averageGradePerSchool(List<Student> studentsList) {
        return studentsList.stream()
                .flatMap(student -> student.courses.entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue))
                ));
    }

    public Map<String, Integer> getFinalGradesForStudent(List<Student> studList, String firstName, String lastName) {
        return studList.stream()
                .filter(student -> student.firstName.equals(firstName) && student.lastName.equals(lastName))
                .findFirst()
                .map(student -> student.courses.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue()
                                        .stream().mapToInt(Integer::intValue).average()
                                        .orElse(0.0))
                        ))
                ).orElse(Collections.emptyMap());
    }

    public String findMostDifficultSubject(List<Student> students) {
        Map<String, Double> averageGrades = averageGradePerSchool(students);
        return averageGrades.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Нет данных");
    }

    public void printPerformanceTable(List<Student> students) {
        Set<String> subjects = students.stream()
                .flatMap(student -> student.getCourses().keySet().stream()) // Собираем все предметы
                .collect(Collectors.toSet());

        System.out.printf("%-15s", "ФИО");
        subjects.forEach(subject -> System.out.printf("%-12s", subject));
        System.out.printf("%-10s%-10s%n", "Успеваемость", "Итоговая оценка");

        students.forEach(student -> {
            System.out.printf("%-15s", student.getFirstName() + " " + student.getLastName());

            Map<String, Integer> finalGrades = getFinalGradesForStudent(students, student.getFirstName(),
                    student.getLastName());
            double total = subjects.stream().mapToInt(subject -> finalGrades.getOrDefault(subject, 0)).sum();

            subjects.forEach(subject -> {
                int grade = finalGrades.getOrDefault(subject, 0);
                System.out.printf("%-12d", grade);
            });

            double percentage = (total / (subjects.size() * 5.0)) * 100;
            double finalGrade = total / (double) subjects.size();

            System.out.printf("%-10.2f%-10.1f%n", percentage, finalGrade);
        });
    }
}
