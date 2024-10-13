package electronicDiary_35235.entity;


import electronicDiary_35235.services.JsonReader;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@EqualsAndHashCode
public class School {
    private final List<Student> students;

    public School() {
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

    public Optional<Map<String, Integer>> getTotalScoreStudent(@NonNull List<Student> students, String firstname, String lastname) {
        Optional<Student> student = students.stream()
                .filter(item -> item.getFirstName().equals(firstname) && item.getLastName().equals(lastname))
                .findFirst();

        if (student.isPresent()) {
            Map<String, List<Integer>> subjectScores = student.get().getSubjects();
            Map<String, Integer> result = subjectScores.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            entry -> entry.getValue().stream().mapToInt(i -> i).sum() / entry.getValue().size()));
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

}
