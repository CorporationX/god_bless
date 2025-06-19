package school.faang.bjs2_80851;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StudentPerformance {

    public Map<String, Double> calculateAverageGrade(List<Student> students) {
        return students.stream()
                .filter(entry -> Objects.nonNull(entry.getCourses()))
                .flatMap(student -> student.getCourses().entrySet().stream())
                .filter(entry -> Objects.nonNull(entry.getValue()))
                .flatMap(entry -> entry.getValue().stream()
                        .map(grade -> new AbstractMap.SimpleEntry<>(entry.getKey(), grade)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingInt(Map.Entry::getValue)
                ));
    }

    public Map<String, Integer> getFinalGradesForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName()))
                .findFirst()
                .map(student -> {
                    Map<String, List<Integer>> courses = student.getCourses();
                    if (courses == null) {
                        return Collections.<String, Integer>emptyMap();
                    }
                    return courses.entrySet().stream()
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    entry -> (int) Math.round(
                                            entry.getValue().stream()
                                                    .mapToInt(Integer::intValue)
                                                    .average()
                                                    .orElse(0.0)
                                    )
                            ));
                })
                .orElse(Collections.emptyMap());
    }

    public String findMostDifficultSubject(List<Student> students) {
        Map<String, Double> averageStudents = calculateAverageGrade(students);
        return averageStudents.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No subjects found");
    }

    public void printPerformanceTable(List<Student> students) {
        List<String> subjects = students.stream()
                .flatMap(student -> {
                    Map<String, List<Integer>> courses = student.getCourses();
                    if (courses == null) {
                        return Stream.empty();
                    }
                    return courses.keySet().stream();
                })
                .distinct()
                .sorted()
                .toList();

        System.out.printf("%-20s", "ФИО");
        for (String subject : subjects) {
            System.out.printf("| %-12s", subject);
        }
        System.out.printf("| %-15s| %-15s%n", "Успеваемость (%)", "Итоговая оценка");

        for (Student student : students) {
            String fullName = student.getFirstName() + " " + student.getLastName();
            System.out.printf("%-20s", fullName);

            Map<String, Integer> finalGrades = getFinalGradesForStudent(
                    students, student.getFirstName(), student.getLastName());

            double total = 0;
            int count = 0;

            for (String subject : subjects) {
                int grade = finalGrades.getOrDefault(subject, 0);
                System.out.printf("| %-12d", grade);
                total += grade;
                count++;
            }

            double percentage = (count > 0) ? (total / (count * 5.0)) * 100 : 0;
            double finalGrade = (count > 0) ? total / count : 0;

            System.out.printf("| %-15.2f| %-15.1f%n", percentage, finalGrade);
        }
    }
}
