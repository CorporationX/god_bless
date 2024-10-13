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


    public Map<String, Integer> calculateAverageScore(@NonNull List<Student> students) {
        Map<String, List<Integer>> subjectScores = new HashMap<>();

        for (Student student : students) {
            for (Map.Entry<String, List<Integer>> entry : student.getSubjects().entrySet()) {
                subjectScores.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).addAll(entry.getValue());
            }
        }

        Map<String, Integer> result = subjectScores.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) entry.getValue().stream()
                                .mapToInt(i -> i)
                                .average()
                                .orElse(0)
                ));
        return result;
    }

    public void addStudentsFromJSON(@NonNull String filePath) {
        JsonReader jsonReader = new JsonReader();
        List<Student> newStudents = jsonReader.readJsonFromFile(filePath);
        addStudents(newStudents);
    }

    public void addStudents(List<Student> newStudents) {
        this.students.addAll(newStudents);
    }

}
