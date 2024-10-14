package school.faangSprint2.t18;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentManagementSystem {
    public Map<String, Double> getAverageGradesBySubject(List<Student> students) {
        Map<String, List<Integer>> allGrades = new HashMap<>();

        for (Student student : students) {
            for (Map.Entry<String, List<Integer>> entry : student.getSubjects().entrySet()) {
                String subject = entry.getKey();
                List<Integer> grades = entry.getValue();
                allGrades.computeIfAbsent(subject, k -> new ArrayList<>()).addAll(grades);
            }
        }

        return allGrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0)
                ));
    }

    public Map<String, Integer> getFinalGrades(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .findFirst()
                .map(student -> student.getSubjects().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0))
                        )))
                .orElse(new HashMap<>());
    }

    public String getMostDifficultSubject(List<Student> students) {
        Map<String, Double> averageGrades = getAverageGradesBySubject(students);
        return averageGrades.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public void printPerformanceTable(List<Student> students) {
        System.out.printf("%-20s", "ФИО");
        Set<String> allSubjects = students.stream()
                .flatMap(s -> s.getSubjects().keySet().stream())
                .collect(Collectors.toSet());

        for (String subject : allSubjects) {
            System.out.printf("| %-12s", subject);
        }
        System.out.printf("| %-10s | %-20s%n", "%", "Итоговая оценка");

        for (Student student : students) {
            System.out.printf("%-20s", student.getFirstName() + " " + student.getLastName());
            Map<String, Double> avgGrades = new HashMap<>();
            double overallAvg = 0;

            for (String subject : allSubjects) {
                List<Integer> grades = student.getSubjects().getOrDefault(subject, Collections.emptyList());
                double avg = grades.stream().mapToInt(Integer::intValue).average().orElse(0);
                avgGrades.put(subject, avg);
                overallAvg += avg;
                System.out.printf("| %-12.1f", avg);
            }

            overallAvg /= allSubjects.size();
            double performancePercentage = (overallAvg / 5) * 100;
            System.out.printf("| %-10.1f | %-20.1f%n", performancePercentage, overallAvg);
        }
    }

    public List<Student> loadStudentsFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(filePath).toFile(), new TypeReference<List<Student>>() {
        });
    }
}