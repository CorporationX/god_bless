package faang.school.godbless.electronicDiary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

    public Map<String, Double> calculateAverage(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(entry -> (double) entry.getValue()
                                .stream()
                                .reduce(0, Integer::sum) / entry.getValue().size())
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
        return calculateAverage(students).entrySet()
                .stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .stream().findFirst().orElse("Subject not found");
    }


}
