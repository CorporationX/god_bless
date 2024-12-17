package school.faang.sprint_2.task_bjs247313;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentService {
    public Map<String, Double> getAvgGradeInSchoolBySubject(@NonNull List<Student> students) {
        return students.stream()
                .flatMap(student -> student.subjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0))));
    }

    public Map<String, Integer> getAvgGradeBySubjectByStudent(@NonNull List<Student> students,
                                                              @NonNull String name,
                                                              @NonNull String lastName) {
        return students.stream()
                .filter(student -> Objects.equals(student.firstName(), name)
                        && Objects.equals(student.lastName(), lastName))
                .findFirst()
                .map(student -> student.subjects().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(
                                        entry.getValue().stream()
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElse(0.0)
                                )
                        )))
                .orElseThrow(() -> new NoSuchElementException("Student not found: " + name + " " + lastName));
    }

    public String getHardestSubject(@NonNull List<Student> students) {
        Map<String, Double> gradeBySubject = getAvgGradeInSchoolBySubject(students);
        return gradeBySubject.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoSuchElementException("No data"));
    }
}
