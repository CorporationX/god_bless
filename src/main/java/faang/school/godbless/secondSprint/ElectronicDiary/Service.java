package faang.school.godbless.secondSprint.ElectronicDiary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {
    public static Map<String, Double> calculateAvgGrade(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.courses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue))));
    }

    public static Map<String, Integer> calculateFinalGrade(List<Student> students, String firstName, String lastName) {
        Student rightStudent = students.stream()
                .filter(student -> student.firstName().equals(firstName) && student.lastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal firstName or lastName value"));

        return rightStudent.courses().entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.collectingAndThen(Collectors.averagingDouble(Integer::doubleValue),
                                        avg -> (int) Math.round(avg)))));
    }

    public static String findHardestSubject(List<Student> students) {
        Map<String, Double> avgGrade = calculateAvgGrade(students);

        return avgGrade.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Empty students list"));
    }
}
