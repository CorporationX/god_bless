package school.faang.bjs2_80842;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentManager {

    public Map<String, Double> avgGradeBySubjects(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(
                                entry -> entry.getValue().stream()
                                        .mapToInt(Integer::intValue)
                                        .average().orElse(0))));
    }

    public Map<String, Integer> finalGradesForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream().filter(student -> student.getFirstName().equals(firstName)
                                                   && student.getLastName().equals(lastName))
                .findFirst()
                .map(student -> student.getCourses().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream()
                                                                  .mapToInt(Integer::intValue)
                                                                  .average().orElse(0))
                        ))).orElse(Collections.emptyMap());
    }

    public String findDifficultSubject(List<Student> students) {
        return avgGradeBySubjects(students).entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("Самый сложный предмет не определен");
    }
}
