package school.faang.electronicdiary;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentDatabase {
    public Map<String, Double> findAverageGradesOnSubjects(List<Student> students) {
        validateList(students);
        return students.stream().flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.averagingDouble(entry ->
                                entry.getValue().stream().collect(Collectors.averagingDouble(value ->
                                        Double.parseDouble(value.toString()))))));
    }

    public Map<String, Integer> findAverageGradesStudent(List<Student> students, String firstName, String lastName) {
        validateList(students);
        validateNaming(firstName, lastName);
        List<Student> concreteStudent = students.stream()
                .filter(student ->
                        student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)).toList();
        Map<String, Double> averageGradesOfStudent = findAverageGradesOnSubjects(concreteStudent);
        return averageGradesOfStudent.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry ->
                        (int) Math.round(entry.getValue())));
    }

    public String findHardestSubject(List<Student> students) {
        validateList(students);
        Map<String, Double> averageGrades = findAverageGradesOnSubjects(students);
        return averageGrades.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList().get(0).getKey();
    }

    private void validateList(List<Student> list) {
        Objects.requireNonNull(list, "Invalid list value");
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }

    private void validateNaming(String firstName, String lastName) {
        Objects.requireNonNull(firstName, "Invalid first name value");
        Objects.requireNonNull(lastName, "Invalid last name value");
    }
}
