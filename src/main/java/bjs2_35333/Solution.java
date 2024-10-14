package bjs2_35333;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static Map<String, Double> getAverageMarks(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0),
                        (val1, val2) -> {
                            BigDecimal bd = BigDecimal.valueOf((val1 + val2) / 2);
                            bd = bd.setScale(2, RoundingMode.HALF_UP);
                            return bd.doubleValue();
                        }
                ));
    }

    public static Map<String, Integer> getStudentMarks(
            List<Student> students,
            String firstName,
            String lastName) {
        return students.stream()
                .filter(student ->
                        student.getFirstName().equals(firstName) &&
                                student.getLastName().equals(lastName))
                .limit(1)
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) Math.round(entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0))
                ));
    }

    public static String getMostDifficultSubject(List<Student> students) {
        return getAverageMarks(students).entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .limit(1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining());
    }
}
