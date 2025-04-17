package school.faang.e_diary;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class DiaryOperations {
    private String formatForTitle = "%-17s | %11s | %11s | %5s | %6s | %16s%n";
    private String formatForRow = "%-15.15s   | %11.1f | %11.1f | %5.1f | %6.1f | %16.1f %n";

    public Map<String, Double> getSubjectAvgGrades(List<Student> students) {
        return students.stream()
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry ->
                        Map.of(entry.getKey(),
                                entry.getValue().stream()
                                        .mapToInt(num -> num)
                                        .average()
                                        .getAsDouble()))
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
    }

    public Map<String, Long> getAvgGradesForStudent(List<Student> students, String name, String lastName) {
        return students.stream()
                .filter(student -> student.getName().equals(name) && student.getLastName().equals(lastName))
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry -> {
                    double avgMark = entry.getValue().stream()
                            .mapToInt(num -> num)
                            .average()
                            .getAsDouble();
                    return Map.of(entry.getKey(), Math.round(avgMark));
                })
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public String getTheLowestGradeSubject(List<Student> students) {
        return students.stream()
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry ->
                        Map.of(entry.getKey(),
                                entry.getValue().stream()
                                        .mapToInt(num -> num)
                                        .average()
                                        .getAsDouble()))
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
    }

    public String getStudentsGradingTable(List<Student> students) {
        Map<Student, Map<String, Double>> studentsToAvgMarks = getstudentsToAvgMarksMap(students);
        Map<Student, Double> studentToTotalAverageMark = getTotalAverageMarkForStudent(studentsToAvgMarks);
        Map<Student, Double> studentOverallPerformance = getStudentOverallPerformance(studentToTotalAverageMark);
        return getFormattedTable(students, studentsToAvgMarks, studentToTotalAverageMark, studentOverallPerformance);


    }

    private static String getFormattedTable(List<Student> students, Map<Student,
                                                    Map<String, Double>> studentsToAvgMarks,
                                            Map<Student, Double> studentToTotalAverageMark,
                                            Map<Student, Double> studentOverallPerformance) {
        StringBuilder resultTable = new StringBuilder();
        resultTable.append(String.format(formatForTitle, "ФИО",
                "Математика",
                "Литература",
                "Химия",
                "%",
                "Итоговая оценка"));
        for (Student student : students) {
            Map<String, Double> subjectAvgMarkMap = studentsToAvgMarks.get(student);
            resultTable.append(String.format(formatForRow,
                    String.format("%s %s", student.getName(), student.getLastName()),
                    subjectAvgMarkMap.get("Математика"),
                    subjectAvgMarkMap.get("Литература"),
                    subjectAvgMarkMap.get("Химия"),
                    studentOverallPerformance.get(student),
                    studentToTotalAverageMark.get(student)));
        }
        return resultTable.toString();
    }

    private static Map<Student, Double> getStudentOverallPerformance(
            Map<Student, Double> studentToTotalAverageMark) {
        return studentToTotalAverageMark.entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), 100 * (entry.getValue() / 5)))
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
    }

    private static Map<Student, Double> getTotalAverageMarkForStudent(
            Map<Student, Map<String, Double>> studentsToAvgMarks) {
        return studentsToAvgMarks.entrySet().stream()
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry -> {
                    double averageForAllMarks = entry.getValue().values().stream()
                            .collect(Collectors.averagingDouble(Double::doubleValue));
                    return Map.of(entry.getKey(), averageForAllMarks);
                })
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Map<Student, Map<String, Double>> getstudentsToAvgMarksMap(List<Student> students) {
        return students.stream()
                .map(student -> {
                    Map<String, Double> subjectToAvgMark = student.getMarks()
                            .entrySet().stream()
                            .filter(entry -> !entry.getValue().isEmpty())
                            .map(entry -> Map.of(entry.getKey(),
                                    entry.getValue().stream().mapToInt(num -> num).average().getAsDouble()))
                            .flatMap(map -> map.entrySet().stream())
                            .collect(Collectors.groupingBy(Map.Entry::getKey,
                                    Collectors.averagingDouble(Map.Entry::getValue)));
                    return Map.of(student, subjectToAvgMark);
                })
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
