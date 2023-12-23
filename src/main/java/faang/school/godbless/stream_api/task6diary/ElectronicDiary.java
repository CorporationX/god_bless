package faang.school.godbless.stream_api.task6diary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ElectronicDiary {
    public static Map<String, Double> toAverageSubject(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getSubjectsGrade().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(en -> en.getValue().stream().mapToDouble(Integer::intValue).average().orElse(0.0))
                ));
    }

    public static Map<String, Integer> totalScoreBySubject(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .flatMap(student -> student.getSubjectsGrade().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) Math.round(entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0))
                ));
    }

    public static String mostDifficultSubject(List<Student> students) {
        Map<String, Double> averageScores = toAverageSubject(students);

        return averageScores.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
