package faang.school.godbless.BJS2_22620;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class Student {

    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;

    public static void analyzeStudents(List<Student> students) {
        students.forEach(student -> {
            Map<String, Double> subjectByAvgAssessment = subjectByAvgAssessment(List.of(student));
            double generalAssessment = getGeneralAssessment(subjectByAvgAssessment.values());
            double maxAssessment = 5D;
            double performance = generalAssessment / maxAssessment * 100;

            System.out.printf("%s %s | %s%.1f | %.1f%n",
                    student.firstName,
                    student.lastName,
                    getSubjectsByAssessments(subjectByAvgAssessment),
                    performance,
                    generalAssessment
            );
        });
    }

    private static double getGeneralAssessment(Collection<Double> assessments) {
        return assessments.stream()
                .mapToDouble(i -> i)
                .sum() / assessments.size();
    }

    private static String getSubjectsByAssessments(Map<String, Double> subjectByAvgAssessment) {
        StringBuilder subjects = new StringBuilder();

        for (var entry : subjectByAvgAssessment.entrySet()) {
            subjects.append(String.format("%s: %.1f | ",
                    entry.getKey(),
                    entry.getValue()));
        }

        return subjects.toString();
    }

    public static Optional<String> findMostDifficultSubject(List<Student> students) {
        Map<String, Double> subjectByAverageAssessment = subjectByAvgAssessment(students);
        return subjectByAverageAssessment
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public static Map<String, Double> subjectByAvgAssessment(List<Student> students) {
        Map<String, List<Integer>> subjectByAssessments = mapSubjectByAssessments(students);
        return subjectByAssessments.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> average(entry.getValue())
                ));
    }

    private static Map<String, List<Integer>> mapSubjectByAssessments(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.courses.entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                                entry -> entry.getValue().stream(),
                                Collectors.toList()
                        )
                ));
    }

    public static Map<Student, Map<String, Long>> mapStudentByFinalAssessments(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        Student::mapStudentByFinalAssessment
                ));
    }

    private static Map<String, Long> mapStudentByFinalAssessment(Student student) {
        return student.courses.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Math.round(
                                average(entry.getValue()))
                ));
    }

    private static double average(List<Integer> assessments) {
        return assessments.stream()
                .mapToDouble(Double::valueOf)
                .average().orElse(Double.NaN);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
