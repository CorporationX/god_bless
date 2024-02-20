package ElectrDnevnik;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Gregory", "Ho", Map.of("Math", Arrays.asList(3.0, 3.0, 4.0), "Physics", Arrays.asList(4.0, 4.0, 3.0)));
        Student student2 = new Student("Liza", "Cuddy", Map.of("Math", Arrays.asList(5.0, 5.0, 5.0), "Physics", Arrays.asList(4.0, 5.0, 5.0)));
        Student student3 = new Student("James", "Wilson", Map.of("Math", Arrays.asList(4.0, 5.0, 3.0), "Physics", Arrays.asList(2.0, 5.0, 5.0)));

        List<Student> students = List.of(student1, student2, student3);

        Collector<Student, StringBuilder, String> customCollector = Collector.of(
                StringBuilder::new,
                (sb, student) -> sb.append(formatStudentInfo(student)).append("\n"),
                StringBuilder::append,
                StringBuilder::toString
        );

        String resultTable = students.stream().collect(customCollector);

        System.out.println(resultTable);
    }

    private static String formatStudentInfo(Student student) {
        Map<String, Integer> totalScores = new SchoolDiaryService().calculateTotalScoresForStudent(
                List.of(student), student.getFirstName(), student.getLastName());

        double averagePercentage = student.getCourses().entrySet().stream()
                .mapToDouble(entry -> calculateAveragePercentage(entry.getValue()))
                .average().orElse(0);

        int finalGrade = calculateFinalGrade(averagePercentage);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s |", student.getFirstName(), student.getLastName()));

        student.getCourses().forEach((subject, scores) ->
                sb.append(String.format(" %s: %s |", subject, scores.toString())));

        sb.append(String.format(" Успеваемость: %.2f%% | Итоговая оценка: %d", averagePercentage, finalGrade));

        return sb.toString();
    }

    private static double calculateAveragePercentage(List<Double> scores) {
        return scores.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    private static int calculateFinalGrade(double averagePercentage) {
        return (int) Math.round(averagePercentage);
    }
}