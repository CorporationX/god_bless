package faang.school.godbless.electronic_diary;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Diary {
    private final int PERCENTAGE_PER_SCALE = 20;

    public Map<String, Double> getSchoolCoursesAndAverageGradesMap(List<Student> studentList) {
        List<Map.Entry<String, List<Integer>>> courseEntries = extractCourseEntries(studentList);

        Map<String, List<Map.Entry<String, List<Integer>>>> groupedCourses = groupCourseEntriesByCourseName(courseEntries);

        return calculateAverageGrades(groupedCourses);
    }

    public Optional<String> getHardestCourse(List<Student> studentList) {
        Map<String, Double> averageGrades = getSchoolCoursesAndAverageGradesMap(studentList);

        return averageGrades.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Collector<Student, StringBuilder, String> gradeCourseGradesTable(List<Student> studentList,
                                                                            List<String> courseNameList) {
        return new Collector<>() {
            @Override
            public Supplier<StringBuilder> supplier() {
                return StringBuilder::new;
            }

            @Override
            public BiConsumer<StringBuilder, Student> accumulator() {
                return (studentInfoRow, student) -> {
                    Map<String, Double> studentCourseAverageGradeMap = getStudentCoursesAndAverageGradesMap(student);

                    double totalAverageGrade = studentCourseAverageGradeMap.values().stream()
                            .collect(Collectors.averagingDouble(value -> value));

                    studentInfoRow.append(String.format("%-20s", student.getFirstName() + " " + student.getLastName()));

                    courseNameList.forEach(courseName ->
                        studentInfoRow.append(" | ")
                                .append(String.format("%-" + courseName.length() + "s",
                                        roundToNDigitsAfterComma(studentCourseAverageGradeMap.get(courseName), 1)))
                    );

                    studentInfoRow.append(" | ")
                            .append(String.format("%3.2f",
                                    roundToNDigitsAfterComma(totalAverageGrade * PERCENTAGE_PER_SCALE, 1)))
                            .append(" | ");

                    studentInfoRow.append(String.format("%11.1f", roundToNDigitsAfterComma(totalAverageGrade, 1)));
                    studentInfoRow.append("\n");
                };
            }

            @Override
            public BinaryOperator<StringBuilder> combiner() {
                return (result, header) -> {
                    result.append(header);

                    studentList.forEach(student -> accumulator().accept(result, student));

                    return result;
                };
            }

            @Override
            public Function<StringBuilder, String> finisher() {
                return (result) -> combiner().apply(result, getHeader()).toString();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return new HashSet<>();
            }

            private StringBuilder getHeader() {
                StringBuilder header = supplier().get();

                header.append(String.format("%-20s", "Name Surname"));

                courseNameList.forEach(courseName ->
                        header.append(" | ").append(String.format("%-" + courseName.length() + "s", courseName)));

                header.append(" |   %  ").append(" | Total Grade").append("\n");

                return header;
            }
        };
    }

    public String getTable(Collector<Student, StringBuilder, String> tableConstructor) {
        return tableConstructor.finisher().apply(tableConstructor.supplier().get());
    }

    private Map<String, Double> getStudentCoursesAndAverageGradesMap(Student student) {
        return student.getCourses()
                .entrySet().stream()
                .collect(
                        Collectors.toMap(Map.Entry::getKey,
                                entry -> entry.getValue().stream()
                                        .collect(Collectors.averagingDouble(grade -> grade)))
                );
    }

    private double roundToNDigitsAfterComma(double toRound, int n) {
        double tenToNthPower = Math.pow(10, n);
        return Math.round(toRound * tenToNthPower) / tenToNthPower;
    }

    private List<Map.Entry<String, List<Integer>>> extractCourseEntries(List<Student> studentList) {
        return studentList.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.toList());
    }

    private Map<String, List<Map.Entry<String, List<Integer>>>> groupCourseEntriesByCourseName(
            List<Map.Entry<String, List<Integer>>> courseEntries) {
        return courseEntries.stream()
                .collect(Collectors.groupingBy(Map.Entry::getKey));
    }

    private Map<String, Double> calculateAverageGrades(
            Map<String, List<Map.Entry<String, List<Integer>>>> groupedCourses) {
        return groupedCourses.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .flatMap(courseEntry -> courseEntry.getValue().stream())
                                .collect(Collectors.averagingDouble(Integer::intValue))
                ));
    }

    public Map<String, Integer> getStudentFinalGrades(Student student) {
        Map<String, Double> courseAndAvgGrade = getStudentCoursesAndAverageGradesMap(student);

        return courseAndAvgGrade.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Math.toIntExact(Math.round(entry.getValue()))));
    }
}
