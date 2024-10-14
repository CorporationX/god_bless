package school.faang.BJS2_35230;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentService {
    public Map<String, Double> getAverageGradesBySubject(List<Student> students) {
        Map<String, List<Integer>> studentGrades = students.stream()
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(), Collectors.toList())
                ));

        return studentGrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0)
                ));
    }

    public Map<String, Integer> getFinalGrade(List<Student> students, String fullName) {
        return students.stream()
                .filter(student -> student.getFullName().equals(fullName))
                .findFirst()
                .map(student -> student.getSubjects().entrySet().stream()
                        .collect(Collectors.toMap(
                                Entry::getKey,
                                entry -> (int) Math.round(
                                        entry.getValue().stream()
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElse(0.0))
                        )))
                .orElse(new HashMap<>());
    }

    public String getMostDifficultSubject(List<Student> students) {
        Map<String, Double> averageGrades = getAverageGradesBySubject(students);

        return averageGrades.entrySet().stream()
                .min(Entry.comparingByValue())
                .map(Entry::getKey)
                .orElse("");
    }

    public void printPerformanceTable(List<Student> students) {
        Set<String> subjects = students.stream()
                .flatMap(student -> student.getSubjects().keySet().stream())
                .collect(Collectors.toSet());

        System.out.printf("%-15s", "ФИО");
        subjects.forEach(subject -> System.out.printf("%-12s", subject));
        System.out.printf("%-10s%-10s%n", "Успеваемость", "Итоговая оценка");

        students.forEach(student -> {
            System.out.printf("%-20s", student.getFullName());

            Map<String, Integer> finalGrades = getFinalGrade(students, student.getFullName());
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

    public List<Student> loadStudentsFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(filePath).toFile(), new TypeReference<>() {
        });
    }
}
