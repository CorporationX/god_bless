package faang.school.godbless.bjs2_5296;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentService {

    public Map<String, Double> findAverageScoreBySubject(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(entry ->
                                (double) entry.getValue().stream().reduce(0, Integer::sum) / entry.getValue().size())
                ));
    }

    public Map<String, Integer> calcTotalScorePerSubjForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName()))
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.collectingAndThen(Collectors.averagingInt(entry ->
                                Math.round((float) entry.getValue().stream().reduce(0, Integer::sum)) / entry.getValue().size()), Double::intValue))
                );
    }

    public String findTheMostDifficultSubject(List<Student> students) {
        return findAverageScoreBySubject(students).entrySet()
                .stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .stream().findFirst().orElse("Subject not found");
    }

    public Collector<Student, StringBuilder, String> getCustomCollector() {
        return Collector.of(
                StringBuilder::new,
                (sb, student) -> {
                    //Print subjects
                    sb.append("ФИО           ");
                    student.getCourses()
                            .forEach((key, value) -> sb.append("|").append(String.format("%12s", key)));
                    sb.append("|   %   | Общая оценка\n");

                    sb.append(student.getFirstName()).append(" ").append(student.getLastName());
                    //print average score
                    List<Double> scores = new ArrayList<>();

                    student.getCourses().forEach((key, value) -> {
                        Double avgScore = (double) value.stream().reduce(0, Integer::sum) / value.size();
                        scores.add(avgScore);
                        sb.append(String.format("|%12.1f", avgScore));
                    });

                    double totalScore = scores.stream().reduce(0.0, Double::sum) / scores.size();
                    //print percent
                    sb.append(String.format("|%7.1f", totalScore / 5 * 100));

                    //print total score
                    sb.append(String.format("|%12.1f", totalScore));

                    sb.append("\n");
                },
                StringBuilder::append,
                StringBuilder::toString
        );
    }
}
