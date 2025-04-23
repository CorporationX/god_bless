package school.faang.bjs2_70746;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class ElectronicDiaryService {
    public Map<String, Double> findAverageMark(List<Student> students) {
        Map<String, List<Integer>> groupedStudents = students.stream()
                .flatMap(student -> student.subjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(), Collectors.toList())));
        return groupedStudents.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElseThrow(() -> new IllegalArgumentException("Student list is empty"))));
    }

    public Map<String, Integer> findStudentsMarks(List<Student> students, String firstName, String lastName) {
        Student foundStudent = students.stream()
                .filter(student -> student.firstName().equals(firstName) && student.lastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Student with firstName %s and lastName %s doesn't exist in the list",
                                firstName, lastName)));
        return foundStudent.subjects().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (int) Math.round(
                                entry.getValue().stream()
                                        .mapToInt(Integer::intValue)
                                        .average()
                                        .orElse(0.0)
                        )));
    }

    public String findHardestSubject(List<Student> students) {
        return findAverageMark(students).entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry<String, Double>::getValue).reversed())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Students list is empty"));
    }
}