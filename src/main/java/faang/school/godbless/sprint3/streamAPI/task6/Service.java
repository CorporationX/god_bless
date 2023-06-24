package faang.school.godbless.sprint3.streamAPI.task6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

    public Map<String, Double> avgGradeSubject(List<Student> students) {
        return students.stream()
                .flatMap(x -> x.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(x -> x.getValue().stream(), Collectors.averagingDouble(x -> x))));
    }

    public Map<String, Double> avgGradeSubjectForStudent(List<Student> students, String firstName, String lastName) {
        List<Student> filterStudent = students.stream()
                .filter(x -> x.getFirstName().equals(firstName) && x.getLastName().equals(lastName))
                .collect(Collectors.toList());
        return avgGradeSubject(filterStudent);
    }

    public String findHardSubject(List<Student> students) {

        return avgGradeSubject(students)
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue())).toList()
                .get(0)
                .getKey();
    }
}
