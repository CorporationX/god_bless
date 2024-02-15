package ElectrDnevnik;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SchoolDiaryService {
    public Map<String, Double> calculateAverageScores(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.averagingDouble(entry -> entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0))));
    }

    public Map<String, Integer> calculateTotalScoresForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (int) Math.round(entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0))));
    }

    public String findMostChallengingSubject(List<Student> students) {
        Map<String, Double> averageScores = calculateAverageScores(students);
        double minAverageScore = Double.MAX_VALUE;
        String mostChallengingSubject = null;

        for (Map.Entry<String, Double> entry : averageScores.entrySet()) {
            double averageScore = entry.getValue();
            if (averageScore < minAverageScore) {
                minAverageScore = averageScore;
                mostChallengingSubject = entry.getKey();
            }
        }

        return mostChallengingSubject;
    }
}
