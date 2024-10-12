package electronicDiary_35235;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@Getter
@EqualsAndHashCode
public class School {
    private List<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public Map<String, Integer> calculateAverageScore(List<Student> students) {
        Map<String, List<Integer>> subjectScores = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for (Student student : students) {
            for (Map.Entry<String, List<Integer>> entry : student.getSubjects().entrySet()) {
                subjectScores.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).addAll(entry.getValue());
            }
        }
        for (Map.Entry<String, List<Integer>> entry : subjectScores.entrySet()) {
            result.computeIfAbsent(entry.getKey(),
                    k -> (int) entry.getValue().stream().mapToInt(i -> i).average().orElse(0));
        }
        return result;
    }

    public void addStudentsFromJSON(String filePath) {
        JsonReader jsonReader = new JsonReader();
        List<Student> newStudents = jsonReader.readJson(filePath);
        addStudents(newStudents);
    }

    public void addStudents(List<Student> newStudents) {
        this.students.addAll(newStudents);
    }

}
