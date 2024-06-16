package faang.school.godbless.electronic_diary;

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
    final int PERCENTAGE_PER_SCALE = 20;
    public Map<String, Double> getSchoolCoursesAndAverageGradesMap(List<Student> studentList) {
        return studentList.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.averagingDouble(entry -> entry.getValue()
                                        .stream()
                                        .reduce(0, Integer::sum)
                                )));
    }

    public Map<String, Integer> getStudentFinalGrades(Student student) {
        Map<String, Double> courseAndAvgGrade = getStudentCoursesAverageGradesMap(student);

        return courseAndAvgGrade.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> Math.toIntExact(Math.round(entry.getValue())))
                );
    }

    public Optional<String> getHardestCourse(List<Student> studentList) {
        Map<String, Double> averageGrades = getSchoolCoursesAndAverageGradesMap(studentList);

        return averageGrades.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public void gradeCourseGradesTable(List<Student> studentList,
                                       List<String> courseNameList) {

        Collector<Student, StringBuilder, String> tableBuildingCollector = new Collector<>() {
            @Override
            public Supplier<StringBuilder> supplier() {
                StringBuilder result = new StringBuilder();

                result.append(String.format("%-20s", "Name Surname"));
                courseNameList.forEach(courseName -> {
                    result.append(" | ").append(String.format("%-" + courseName.length() + "s", courseName));
                });
                result.append(" |   %  ").append(" | Total Grade");
                result.append("\n");

                return () -> result;
            }

            @Override
            public BiConsumer<StringBuilder, Student> accumulator() {
                return (studentInfoRow, student) -> {
                    Map<String, Double> studentCourseAverageGradeMap = getStudentCoursesAverageGradesMap(student);

                    double totalAverageGrade = studentCourseAverageGradeMap.values().stream()
                            .collect(Collectors.averagingDouble(value -> value));

                    studentInfoRow.append(String.format("%-20s", student.getFirstName() + " " + student.getLastName()));
                    courseNameList.forEach(courseName -> {
                        int courseNameLength = courseName.length();
                        studentInfoRow
                                .append(" | ")
                                .append(String.format("%-" + courseNameLength + "s",
                                        roundToNAfterComma(studentCourseAverageGradeMap.get(courseName), 1)));
                    });
                    studentInfoRow
                            .append(" | ")
                            .append(String.format("%3.1f",
                                    roundToNAfterComma(totalAverageGrade * PERCENTAGE_PER_SCALE, 1)))
                            .append(" | ");
                    studentInfoRow.append(String.format("%11.1f", roundToNAfterComma(totalAverageGrade, 1)));
                    studentInfoRow.append("\n");
                };
            }

            @Override
            public BinaryOperator<StringBuilder> combiner() {
                return null;
            }

            @Override
            public Function<StringBuilder, String> finisher() {
                return (result) -> {
                    studentList.forEach(student -> {
                        accumulator().accept(result, student);
                    });

                    return result.toString();
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return null;
            }
        };

        String table = tableBuildingCollector.finisher().apply(tableBuildingCollector.supplier().get());
        System.out.println(table);
    }

    private Map<String, Double> getStudentCoursesAverageGradesMap(Student student) {
        return student.getCourses()
                .entrySet().stream()
                .collect(
                        Collectors.toMap(Map.Entry::getKey,
                                entry -> entry.getValue().stream()
                                        .collect(Collectors.averagingDouble(grade -> grade)))
                );
    }

    private double roundToNAfterComma(double toRound, int n) {
        double tenToN = Math.pow(10, n);
        return Math.round(toRound * tenToN) / tenToN;
    }
}
