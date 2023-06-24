package faang.school.godbless.E_diary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class E_diary {

    public static Map<String, Double> getAverageGrade(List<Student> students) {

        return students.stream()
                .flatMap(x -> x.courses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.flatMapping(x -> x.getValue().stream(),
                                Collectors.averagingDouble(x -> x))));
    }

    public static Map<String, Integer> getFinalGrade(List<Student> students, String firstName, String lastName) {
        List<Student> currentStudent = students.stream()
                .filter(s -> s.firstName().equals(firstName) && s.lastName().equals(lastName))
                .toList();
        return getAverageGrade(currentStudent)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, x -> (int) Math.round(x.getValue())));

    }

    public static String getTheMostStrongCourse(List<Student> students) {
        return getAverageGrade(students)
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) ((x1.getValue() * 100) - (x2.getValue() * 100)))
                .map(Map.Entry::getKey)
                .toList()
                .get(0);
    }
}
