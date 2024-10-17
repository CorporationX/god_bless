package module_2.module_2_2_StreamAPI.electronicDiary_35235.entity;


import module_2.module_2_2_StreamAPI.electronicDiary_35235.services.JsonReader;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class School {
    private final String name;
    private final List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudents(List<Student> newStudents) {
        this.students.addAll(newStudents);
    }

    public void addStudentsFromJSON(@NonNull String filePath) {
        JsonReader jsonReader = new JsonReader();
        List<Student> newStudents = jsonReader.readJsonFromFile(filePath);
        addStudents(newStudents);
    }

    public Map<String, Double> calculateAverageScore(@NonNull List<Student> students) {
        Map<String, List<Integer>> subjectScores = new HashMap<>();

        for (Student student : students) {
            for (Map.Entry<String, List<Integer>> entry : student.getSubjects().entrySet()) {
                subjectScores.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).addAll(entry.getValue());
            }
        }

        return subjectScores.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(i -> i)
                                .average()
                                .orElse(0.0)
                ));
    }

    public Optional<Map<String, Double>> getTotalScoreStudent(@NonNull List<Student> students, String firstname, String lastname) {
        Optional<Student> student = students.stream()
                .filter(item -> item.getFirstName().equals(firstname) && item.getLastName().equals(lastname))
                .findFirst();

        if (student.isPresent()) {
            Map<String, List<Integer>> subjectScores = student.get().getSubjects();
            Map<String, Double> result = subjectScores.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            entry -> entry.getValue().stream()
                                    .mapToDouble(i -> i)
                                    .average()
                                    .orElse(0.0)));
            return Optional.of(result);
        }
        return Optional.empty();

    }

    public String calculateHardSubject(@NonNull List<Student> students) {
        Map<String, Double> subjectsScore = calculateAverageScore(students);
        return subjectsScore.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void printTotalScoreStudents(@NonNull List<Student> students) {
        System.out.printf("%-20s ", "ФИО");

        List<String> subjects = calculateAverageScore(students).keySet().stream().toList();

        int maxLength = subjects.stream().mapToInt(String::length).max().orElse(0);
        subjects.forEach((subject) -> System.out.printf("| %" + maxLength + "s ", subject));
        System.out.printf("| %" + maxLength + "s | %" + maxLength + "s%n", "%", "Итоговая оценка");

        for (Student student : students) {
            System.out.printf("%-20s ", student.getFirstName() + " " + student.getLastName());

            List<Double> scores = new ArrayList<>();
            for (String subject : subjects) {
                if (student.getSubjects().containsKey(subject)) {
                    double score = student.getSubjects().get(subject).stream()
                            .mapToDouble(i -> i)
                            .average()
                            .orElse(0.0);
                    System.out.printf("| %" + maxLength + ".1f ", score);
                    scores.add(score);
                } else {
                    System.out.printf("| %" + maxLength + "s ", "");
                }
            }

            double avgScore = scores.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);

            System.out.printf("| %" + maxLength + ".1f ", avgScore / 5.0 * 100);
            System.out.printf("| %" + maxLength + ".1f%n", avgScore);
        }
    }
}
