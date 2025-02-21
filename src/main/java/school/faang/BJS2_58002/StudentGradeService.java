package school.faang.BJS2_58002;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentGradeService {
    public static Map<String, Double> getAverageGradesBySubject(@NonNull List<Student> students) {
        if (students.isEmpty()) {
            throw new IllegalArgumentException("There is no student in this list");
        }
        Map<String, List<Double>> subjectGradesPerStudent =
                students.stream()
                        .map(student -> student.getCourses().entrySet().stream()
                                .collect(Collectors.toMap(Map.Entry::getKey,
                                        entry -> entry.getValue().stream()
                                                .mapToInt(Integer::intValue)
                                                .average().orElse(0.0))))
                        .flatMap(entry -> entry.entrySet().stream())
                        .collect(Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                        ));

        return subjectGradesPerStudent.entrySet().stream()
                .map(subjectGrade -> {
                    double averageGrade = subjectGrade.getValue().stream()
                            .mapToDouble(Double::intValue).average().orElse(0.0);
                    return Map.entry(subjectGrade.getKey(), averageGrade);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Double> getFinalGradesBySubject(@NonNull List<Student> students,
                                                              @NonNull String firstName,
                                                              @NonNull String lastName) {
        if (students.isEmpty() || firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Students cannot be empty");
        }
        Optional<Student> foundStudent = students.stream()
                .filter(s -> s.getFirstName().equals(firstName)
                        && s.getLastName().equals(lastName))
                .findFirst();
        if (!foundStudent.isPresent()) {
            throw new IllegalArgumentException("Студент с такими именем и фамилией не найден.");
        }
        Map<String, List<Integer>> coursesWithGrades = foundStudent.get().getCourses();
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
