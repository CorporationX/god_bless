package school.faang.stream2.electronicdiary;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class School {

    /*
     * Журналы оценок всех студентов преобразуются двумя flatMap в стрим ентри(предмет, оценка)
     * и затем собираются в возвращаемый результат
     */
    public static Map<String, Double> calculateAverage(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream()
                        .flatMap(entry ->
                                entry.getValue().stream()
                                        .map(integer -> Map.entry(entry.getKey(), integer))
                        ))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingInt(Map.Entry::getValue)
                ));
    }

    public static Map<String, Integer> calculateResultByStudent(List<Student> students, String name, String lastName) {
        Optional<Map<String, List<Integer>>> studentsCoursesOpt = students.stream()
                .filter(student -> (name.equals(student.getFirstName())) && (lastName.equals(student.getLastName())))
                .map(Student::getCourses)
                .findFirst();
        return studentsCoursesOpt.map(value ->
                value.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> {
                                    double average = entry.getValue().stream()
                                            .mapToInt(Integer::intValue)
                                            .average()
                                            .orElse(0.0);
                                    return (int) Math.round(average);
                                }
                        ))
        ).orElse(Collections.emptyMap());
    }

    public static String calculateMostDifficultSubject(List<Student> students) {
        return calculateAverage(students).entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
    }
}
