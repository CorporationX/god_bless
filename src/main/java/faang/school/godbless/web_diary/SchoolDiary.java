package faang.school.godbless.web_diary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SchoolDiary {
    public Map<String, Double> calculateAverageGrades(List<Student> students) {
        Map<String, List<Integer>> allCourses = students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, e -> new ArrayList<>(e.getValue()),
                        (grades1, grades2) -> {
                            List<Integer> combinedGrades = new ArrayList<>(grades1);
                            combinedGrades.addAll(grades2);
                            return combinedGrades;
                        }));

        return allCourses.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0)));
    }
    public Map<String, Integer> calculateFinalGradesForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (int) Math.round(entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0))));
    }

    public String findMostDifficultSubject(List<Student> students) {
        Map<String, Double> averageGradesBySubject = students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.averagingDouble(entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0))));

        return averageGradesBySubject.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}

