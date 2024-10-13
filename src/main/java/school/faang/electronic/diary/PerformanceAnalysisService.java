package school.faang.electronic.diary;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PerformanceAnalysisService {

    public Map<String, Double> averageMarkBySubject(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0),
                        (avg1, avg2) -> {
                            if (avg1 == 0) {
                                return avg2;
                            } else if (avg2 == 0) {
                                return avg1;
                            }
                            return (avg1 + avg2) / 2;
                        }));
    }

    public Map<String, Integer> finalMarkBySubject(List<Student> students, String firstName, String lastname) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastname))
                .limit(1)
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) Math.round(entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElseThrow(() -> new IllegalArgumentException("У студента нет оценок по предмету"))),
                        (mark1, mark2) -> (int) Math.round((mark1 + mark2) / 2.0)
                ));
    }

    public String findMostDifficultSubject(List<Student> students) {
        return averageMarkBySubject(students).entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .orElseThrow(() -> new IllegalArgumentException("Список студентов пустой"))
                .getKey();
    }

    public void printPerformanceTable(List<Student> students) {
        Set<String> subjects = getAllSubjects(students);
        System.out.printf("%-19s ",
                "ФИО");
        subjects.forEach(subject -> System.out.printf("| %-10s ", subject));
        System.out.printf("| %-5s | %-15s%n", "%", "Итоговая оценка");

        for (Student student : students) {
            System.out.printf("%-19s ", student.getFirstName() + " " + student.getLastName());

            Map<String, Integer> subjectToFinalMark = finalMarkBySubject(students,
                    student.getFirstName(), student.getLastName());
            subjects.forEach(subject -> System.out.printf("| %-10s ",
                    subjectToFinalMark.getOrDefault(subject, 0)));

            int finalMarkTotal = (int) Math.round(subjectToFinalMark.values().stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElseThrow(() -> new IllegalArgumentException("У студента нет оценок")));
            System.out.printf(" %5.1f | %15d%n",
                    finalMarkTotal / 5.0 * 100, finalMarkTotal);
        }
    }


    private Set<String> getAllSubjects(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().keySet().stream())
                .collect(Collectors.toCollection(LinkedHashSet<String>::new));
    }
}
