package school.faang.bjs2_72049;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    public static Map<String, Double> calculateSchoolAverage(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.courses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(e -> e.getValue().stream(),
                                Collectors.averagingDouble(Integer::intValue))
                ));
    }

    public static Map<String, Integer> getStudentFinalGrades(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(s -> s.firstName().equals(firstName) && s.lastName().equals(lastName))
                .findFirst()
                .map(StudentService::calculateStudentGrades)
                .orElse(Collections.emptyMap());
    }

    public static String findHardestSubject(List<Student> students) {
        return calculateSchoolAverage(students).entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Предметы отсутствуют");
    }

    public static Map<String, Integer> calculateStudentGrades(Student student) {
        return student.courses().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> (int) Math.round(e.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0))
                ));
    }
}
