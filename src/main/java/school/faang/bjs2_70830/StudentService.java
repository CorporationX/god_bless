package school.faang.bjs2_70830;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentService {
    public Map<Subject, Double> getAvgGradeGroupingBySubject(List<Student> students) {
        if (students == null) {
            throw new ParamsInStudentServiceIsNullException();
        }
        return students.stream()
                .filter(Objects::nonNull)
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue))));
    }

    public Map<Subject, Integer> getFinalGradesForStudent(List<Student> students, String firstName, String lastName) {
        if (students == null) {
            throw new ParamsInStudentServiceIsNullException();
        }
        Student student = getStudentByFirstNameAndLastName(students, firstName, lastName)
                .orElseThrow(() -> new StudentNotFoundException(String.format(
                        "Student with first name %s and last name %s not found", firstName, lastName)));
        return student.getCourses().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) Math.round(entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0))
                ));
    }

    public Subject getMostDifficultSubject(List<Student> students) {
        if (students == null) {
            throw new ParamsInStudentServiceIsNullException();
        }
        Map<Subject, Double> averageGrades = getAvgGradeGroupingBySubject(students);
        return averageGrades.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(SubjectNotFoundException::new);
    }

    private Optional<Student> getStudentByFirstNameAndLastName(List<Student> students,
                                                               String firstName, String lastName) {
        return students.stream()
                .filter(student -> Objects.equals(student.getFirstName(), firstName)
                        && Objects.equals(student.getLastName(), lastName))
                .findFirst();
    }
}
