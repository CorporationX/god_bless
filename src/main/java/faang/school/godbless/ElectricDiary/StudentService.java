package faang.school.godbless.ElectricDiary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    public Map<Course, Double> getAverageMarksForEachCourse(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                                entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Double::valueOf)
                        )
                ));
    }

    public Map<Course, Integer> getFinalMarksForEachCourseForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.collectingAndThen(
                                Collectors.flatMapping(
                                        entry -> entry.getValue().stream(),
                                        Collectors.averagingDouble(Double::valueOf)
                                ),
                                mark -> (int) Math.round(mark)
                        )
                ));
    }

    public Course getHardestCourse(List<Student> students) {
        return getAverageMarksForEachCourse(students).entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("Предметы не найдены"))
                .getKey();
    }

    public String getStudentsTable(List<Student> students) {
        return students.stream().collect(new StudentsToTableCollector());
    }
}
