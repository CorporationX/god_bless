package faang.school.godbless.sprint3.streamAPI.task6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

    public Map<String, Double> avgGradeSubject(List<Student> students) {
        checkValidation(students);
        return students.stream()
                .flatMap(x -> x.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(x -> x.getValue().stream(), Collectors.averagingDouble(x -> x))));
    }

    public Map<String, Integer> avgGradeSubjectForStudent(List<Student> students, String firstName, String lastName) {
        checkValidation(students);
        List<Student> filterStudent = students.stream()
                .filter(x -> x.getFirstName().equals(firstName) && x.getLastName().equals(lastName))
                .collect(Collectors.toList());
        return avgGradeSubject(filterStudent)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (int) Math.round(e.getValue())));
    }

    public String findHardSubject(List<Student> students) {
        checkValidation(students);
        return avgGradeSubject(students)
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x1.getValue() * 100 - x2.getValue() * 100))
                .map(Map.Entry::getKey)
                .toList()
                .get(0);
    }

    private void checkValidation(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Список пуст!");
        }
    }
}
