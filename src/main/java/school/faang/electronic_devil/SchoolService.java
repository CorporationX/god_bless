package school.faang.electronic_devil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SchoolService {

    public static Map<String, Double> averageGradeSchoolEachSubject(List<Student> students) {

        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                entries -> {
                                    double sum = entries.stream()
                                            .flatMapToInt(entry -> entry.getValue().stream()
                                                    .mapToInt(Integer::intValue))
                                            .sum();
                                    long count = entries.stream()
                                            .mapToInt(entry -> entry.getValue().size())
                                            .sum();
                                    return sum / count;
                                }
                        )
                ));

    }

    public Map<String, Integer> getFinalGradesForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst() // Находим первого подходящего студента
                .map(student -> student.getCourses().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, // Название предмета
                                entry -> (int) Math.round(entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0)) // Средняя оценка
                        ))
                ).orElse(Collections.emptyMap()); // Если нет такого студента, возвращаем пустую мапу
    }

    public String findMostDifficultSubject(List<Student> students) {
        Map<String, Double> averageGrades = averageGradeSchoolEachSubject(students);
        return averageGrades.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Нет данных");
    }
}
