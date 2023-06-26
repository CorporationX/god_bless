package faang.school.godbless.ElectronicDiary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    public static Map<String, Double> averageGrade(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses()
                        .entrySet()
                        .stream()
                        .map(entry -> Arrays.asList(entry.getKey(), entry.getValue().stream().mapToDouble(e -> e).average().orElseThrow())))
                .collect(Collectors.groupingBy(list -> list.get(0).toString(), Collectors.averagingDouble(list -> Double.parseDouble(list.get(1).toString()))));

    }

    public static Map<String, Integer> finalGrade(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .map(Student::getCourses)
                .map(map -> map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, (entry -> entry.getValue().stream().mapToDouble(e -> e).average().getAsDouble()))))
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (int) Math.round(entry.getValue())));
    }

    public static Map<String, Double> hardestMajor(List<Student> students) {
        Map<String, Double> averageGrade = averageGrade(students);
        return averageGrade.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
