package school.faang.BJS2_58002;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StudentGradeService {
    public static Map<String, Double> getAverageGradesBySubject(@NonNull List<Student> students) {
        if (students.isEmpty()) {
            throw new IllegalArgumentException("There is no student in this list");
        }
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue))
                ));
    }

    public static Map<String, Double> getFinalGradesBySubject(@NonNull List<Student> students,
                                                              @NonNull String firstName,
                                                              @NonNull String lastName) {
        if (students.isEmpty() || firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Students cannot be empty");
        }
        Map<String, List<Integer>> coursesWithGrades = students.stream()
                .filter(s -> s.getFirstName().equals(firstName)
                        && s.getLastName().equals(lastName))
                .findFirst()
                .map(Student::getCourses)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        return coursesWithGrades.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e ->
                                Math.ceil((double) e.getValue().stream()
                                        .mapToInt(Integer::intValue).sum() / e.getValue().size())));
    }

    public static String getMostDifficultSubject(@NonNull List<Student> students) {
        Map<String, Double> averageSubjectGrades = getAverageGradesBySubject(students);
        return averageSubjectGrades.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoSuchElementException("No subjects found"));
    }
}
