package school.faang.onlineDiary;

import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Objects;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;
    
    public Map<String, Integer> getAverageCourseNote(List<Student> students) {

        return students.stream()
                 .distinct()
                 .flatMap(s -> s.getSubjects().entrySet().stream())
                 .collect(Collectors.groupingBy(
                         Map.Entry::getKey,
                         Collectors.mapping(
                                 Map.Entry::getValue,
                                 Collectors.collectingAndThen(
                                         Collectors.toList(),
                                         listOfList -> {
                                             List<Integer> merged = listOfList.stream()
                                                     .flatMap(List::stream)
                                                     .toList();
                                             return roundNum(averageNote(merged));
                                         }
                                 )

                         )
                         ));
    }

    public Map<String, Integer> getAverageStudentNote(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .distinct()
                .filter(s -> Objects.equals(s.getFirstName(), firstName)
                        && Objects.equals(s.getLastName(), lastName))
                .flatMap(c -> c.getSubjects().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> roundNum(averageNote(e.getValue())),
                        (existing, replacement) -> replacement
                ));
    }

    public String findTheHardestCourse(List<Student> students) {
        Map<String, List<Integer>> gradesBySubject = students.stream()
                .distinct()
                .flatMap(s -> s.getSubjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue,
                                Collectors.flatMapping(List::stream, Collectors.toList()))
                ));

        return gradesBySubject.entrySet().stream()
                .min(Comparator.comparingDouble(e -> averageNote(e.getValue())))
                .map(Map.Entry::getKey)
                .orElse("No subjects");
    }

    public static void printStudentPerformanceTable(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Нет студентов для отображения.");
            return;
        }

        List<String> allSubjects = students.stream()
                .flatMap(s -> s.getSubjects().keySet().stream())
                .distinct()
                .toList();

        StringBuilder header = new StringBuilder();
        header.append(String.format("%-20s", "ФИО"));

        for (String subject : allSubjects) {
            header.append(String.format("| %-10s", subject));
        }

        header.append(String.format("| %-6s| %-20s", "", "")); // если нужны пустые заголовки

        System.out.println(header);
        System.out.println("-".repeat(header.length()));

        List<String> rows = students.stream()
                .map(s -> {
                    StringBuilder row = new StringBuilder();
                    row.append(String.format("%-20s", s.getFirstName() + " " + s.getLastName()));


                    List<Double> averages = allSubjects.stream()
                            .map(subj -> {
                                List<Integer> grades = s.getSubjects().getOrDefault(subj, Collections.emptyList());
                                return grades.isEmpty() ? 0.0 :
                                        grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
                            })
                            .toList();

                    double total = averages.stream().mapToDouble(Double::doubleValue).sum();
                    long count = averages.stream().filter(avg -> avg > 0).count();

                    double percent = count > 0 ? (total / (count * 5)) * 100 : 0;
                    double finalGrade = count > 0 ? total / count : 0;

                    for (double avg : averages) {
                        row.append(String.format("| %-10.1f", avg));
                    }
                    row.append(String.format("| %-6.1f| %-20.1f", percent, finalGrade));
                    return row.toString();
                })
                .toList();

        rows.forEach(System.out::println);
    }

    private static double averageNote(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    private static int roundNum(double value) {
        return (int) Math.round(value);
    }
}
