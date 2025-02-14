package school.faang;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SchoolPerformance {
    public static Map<String, Double> getAverageGradeForSubjects(List<Student> students) {
        validateStudents(students);
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue))
                ));
    }

    public static Map<String, Double> getAverageGradeForStudent(List<Student> students,
                                                                String firstName, String lastName) {
        validateStudents(students);
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName)
                        && student.getLastName().equals(lastName))
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue))
                ));
    }

    public static String getHardestSubject(List<Student> students) {
        validateStudents(students);
        return getAverageGradeForSubjects(students).entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoSuchElementException("No subjects found"));
    }

    private static void validateStudents(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Student list can't be null.");
        }
    }
}
