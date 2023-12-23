package faang.school.godbless.stream_api.task6diary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Ваня", "Алексеев", Map.of("Математика", Arrays.asList(5, 3, 4), "Литература", Arrays.asList(3, 4, 4), "Химия", Arrays.asList(3, 4, 3))),
                new Student("Даша", "Иванова", Map.of("Математика", Arrays.asList(4, 3, 4), "Литература", Arrays.asList(4, 5, 4), "Химия", Arrays.asList(4, 2, 4)))
        );

        Map<String, Double> averageScores = ElectronicDiary.toAverageSubject(students);
        System.out.println("Средняя оценка по школе за каждый предмет:");
        averageScores.forEach((subject, score) -> System.out.println(subject + ": " + score));

        String firstName = "Ваня";
        String lastName = "Алексеев";
        Map<String, Integer> totalScore = ElectronicDiary.totalScoreBySubject(students, firstName, lastName);
        System.out.println("\nИтоговая оценка для ученика " + firstName + " " + lastName + ":");
        totalScore.forEach((subject, score) -> System.out.println(subject + ": " + score));

        String mostDifficultSubject = ElectronicDiary.mostDifficultSubject(students);
        System.out.println("\nСамый сложный предмет: " + mostDifficultSubject);
    }
}
