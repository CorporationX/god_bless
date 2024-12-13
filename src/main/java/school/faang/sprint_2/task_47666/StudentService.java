package school.faang.sprint_2.task_47666;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentService {
    private static final int PERCENTAGE_INDEX = 100;
    private static final int MAX_GRADE_VALUE = 5;
    private static final String STUDENT_NAME_TABLE_FORMAT = "|%-20s | ";
    private static final String SUBJECT_TABLE_FORMAT = "%-13s | ";
    private static final String GRADE_TABLE_FORMAT = "%-13d | ";
    private static final String SUMMARY_NAME_TABLE_FORMAT = "%-13s | %-16s|%n";
    private static final String SUMMARY_GRADE_TABLE_FORMAT = "%-13.2f | %-16.1f|%n";

    public Map<String, Double> getAverageSchoolGrade(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }
        return students.stream()
                .flatMap(student -> student.subjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().stream(),
                                Collectors.averagingInt(Integer::intValue))
                ));
    }

    public Map<String, Integer> getFinalStudentGrades(List<Student> students, String firstName, String lastName) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }
        if ((firstName == null || firstName.isEmpty()) && (lastName == null || lastName.isEmpty())) {
            throw new IllegalArgumentException("Не верные входные параметры");
        }
        return students.stream()
                .filter(student -> student.firstName().equals(firstName) && student.lastName().equals(lastName))
                .findFirst()
                .map(student -> student.subjects().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream()
                                        .mapToInt(Integer::intValue).average().orElse(0.0))
                        ))
                ).orElse(Collections.emptyMap());
    }

    public String getMostDifficultSubject(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }
        Map<String, Double> averageSchoolGrades = getAverageSchoolGrade(students);
        return averageSchoolGrades.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет данных");
    }

    public void printPerformanceTable(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }
        Set<String> subjects = students.stream()
                .flatMap(student -> student.subjects().keySet().stream())
                .collect(Collectors.toSet());

        printTableHeader(subjects);
        printStudentsTableData(students, subjects);
    }

    private void printTableHeader(Set<String> subjects) {
        System.out.printf(STUDENT_NAME_TABLE_FORMAT, "ФИО");
        subjects.forEach(subject -> System.out.printf(SUBJECT_TABLE_FORMAT, subject));
        System.out.printf(SUMMARY_NAME_TABLE_FORMAT, "Успеваемость", "Итоговая оценка");
    }

    private void printStudentsTableData(List<Student> students, Set<String> subjects) {
        students.forEach(student -> {
            System.out.printf(STUDENT_NAME_TABLE_FORMAT, student.firstName() + " " + student.lastName());

            Map<String, Integer> finalStudentGrades =
                    getFinalStudentGrades(students, student.firstName(), student.lastName());
            double total = subjects.stream()
                    .mapToInt(subject -> finalStudentGrades.getOrDefault(subject, 0)).sum();

            subjects.forEach(subject -> {
                int grade = finalStudentGrades.getOrDefault(subject, 0);
                System.out.printf(GRADE_TABLE_FORMAT, grade);
            });

            double percentage = (total / (subjects.size() * MAX_GRADE_VALUE)) * PERCENTAGE_INDEX;
            double finalGrade = total / (double) subjects.size();

            System.out.printf(SUMMARY_GRADE_TABLE_FORMAT, percentage, finalGrade);
        });

    }
}
