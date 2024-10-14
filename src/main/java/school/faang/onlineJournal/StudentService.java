package school.faang.onlineJournal;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
  public Map<String, Double> calculateAverageGradesBySubject(List<Student> students) {
    return students.stream()
        .flatMap(student -> student.getSubjects().entrySet().stream())
        .flatMap(entry -> entry.getValue().stream()
            .map(grade -> new AbstractMap.SimpleEntry<>(entry.getKey(), grade)))
        .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingInt(Map.Entry::getValue)));
  }

  public List<Map<String, Integer>> calculateFinalGradesForStudent(List<Student> students, String firstName, String lastName) {
    return students.stream()
        .filter(student -> firstName.equals(student.getFirstName()))
        .filter(student -> lastName.equals(student.getLastName()))
        .map(student -> student.getSubjects().entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> (int) Math.round(entry.getValue().stream()
                    .mapToInt(Integer::intValue).average().orElse(0.0))
            )))
        .toList();
  }

  public String hardestSubject(List<Student> students) {
    return calculateAverageGradesBySubject(students).entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null).getKey();
  }

  public void showStudentPerformanceTable(List<Student> students) {
    System.out.printf("%-20s", "| ФИО");

    Set<String> subjectNames = students.stream()
        .flatMap(student -> student.getSubjects().keySet().stream())
        .collect(Collectors.toSet());

    subjectNames.forEach(subjectName -> System.out.printf("| %-12s", subjectName));

    System.out.printf("| %-17s | %-17s%n", " Успеваемость ", "Итоговая оценка\n");

    students.forEach(student -> {
      System.out.printf("%-20s", student.getFirstName() + " " + student.getLastName());

      Map<String, Integer> finalGrades = calculateFinalGradesForStudent(
          students,
          student.getFirstName(),
          student.getLastName()
      ).get(0);

      double total = subjectNames.stream()
          .mapToDouble(subjectName -> finalGrades.getOrDefault(subjectName, 0))
          .sum();

      subjectNames.forEach(subjectName -> {
        int grade = finalGrades.getOrDefault(subjectName, 0);
        System.out.printf("| %-12d", grade);
      });

      double percentage = (total / (finalGrades.size() * 5)) * 100;
      double finalGrade = total / (double) finalGrades.size();

      System.out.printf("| %-17.2f | %-17.1f\n", percentage, finalGrade);
    });
  }
}
