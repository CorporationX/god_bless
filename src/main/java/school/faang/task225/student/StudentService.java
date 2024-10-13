package school.faang.task225.student;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    public static Map<String, Double> getAllSubjectAvgGrade(List<Student> studentList) {
        Map<String, Integer> subjectCount = new HashMap<>();

        Map<String, Double> totalScores = studentList.stream()
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        list -> {
                            subjectCount.merge(list.getKey(), 1, Integer::sum);
                            return list.getValue().stream()
                                    .mapToInt(Integer::intValue)
                                    .average()
                                    .orElse(0);
                        },
                        Double::sum

                ));
        totalScores.entrySet().stream()
                .map(s -> totalScores.put(s.getKey(), totalScores.get(s.getKey()) / subjectCount.get(s.getKey())))
                .toList();
        return totalScores;

    }

    public static Map<String, Integer> getFinalGrade(String name, String surName, List<Student> students) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(name) && student.getLastName().equals(surName))
                .limit(1)
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        list -> (int) Math.round(list.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0))
                ));
    }

    public static String getHardest(List<Student> students) {
        HashMap<String, Double> allSubject = (HashMap<String, Double>) getAllSubjectAvgGrade(students);
        return allSubject.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .limit(1)
                .toList().get(0);
    }

    public static void printAllInfoAboutStudent(List<Student> studentList) {
        Map<String, Map<String, Double>> studentsGrade = studentList.stream()
                .collect(Collectors.toMap(
                        student -> student.getLastName() + " " + student.getFirstName(),
                        student -> {
                            return student.getSubjects().entrySet().stream()
                                    .collect(Collectors.toMap(
                                            Map.Entry::getKey,
                                            grade -> grade.getValue().stream()
                                                    .mapToDouble(Integer::doubleValue)
                                                    .average()
                                                    .orElse(0.0)));
                                            },
                                            ((firstStudent, secondStudent) -> firstStudent)
                ));


        List<String> subject = getAllSubjectAvgGrade(studentList).entrySet().stream()
                .map(Map.Entry::getKey)
                .toList();

        System.out.printf("%-20s", "ФИО");
        subject.stream().peek(s -> System.out.printf("%-12s", s)).toList();
        System.out.printf("%-10s%-10s%n", "Успеваемость в процентах| ", "Итоговая оценка по 5-ти бальной шкале");

        studentsGrade.entrySet().stream().peek(student -> {
            System.out.printf("%-20s", student.getKey());
            subject.stream().peek(s -> {
                Double value = student.getValue().get(s);
                if (value != null) {
                    BigDecimal roundedValue = BigDecimal.valueOf(value)
                            .setScale(2, RoundingMode.HALF_UP);
                    System.out.printf("%-12f", roundedValue.doubleValue());
                } else {
                    System.out.printf("%-12s", "empty");
                }
            }).toList();

            System.out.printf("%-26f", (studentsGrade.get(student.getKey())
                    .entrySet().stream()
                    .mapToDouble(s -> s.getValue())
                    .average()
                    .orElse(0.0) * 100) / 5);

            System.out.printf("%-10d", Math.round(studentsGrade.get(student.getKey())
                    .entrySet().stream()
                    .mapToDouble(s -> s.getValue())
                    .average()
                    .orElse(0.0)));

            System.out.println();
        }).toList();

    }
}
