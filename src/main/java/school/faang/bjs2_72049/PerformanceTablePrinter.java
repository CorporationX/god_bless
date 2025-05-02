package school.faang.bjs2_72049;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class PerformanceTablePrinter {
    public static void print(List<Student> students) {
        Set<String> allSubjects = students.stream()
                .flatMap(s -> s.courses().keySet().stream())
                .collect(Collectors.toSet());

        List<String> sortedSubjects = allSubjects.stream().sorted().toList();

        System.out.printf("%-20s", "ФИО");
        for (String subject : sortedSubjects) {
            System.out.printf(" | %-10s", subject);
        }
        System.out.println(" |   %   | Итоговая оценка");

        for (Student student : students) {
            String fullName = student.firstName() + " " + student.lastName();
            System.out.printf("%-20s", fullName);

            Map<String, Integer> finalGrades = StudentService.calculateStudentGrades(student);

            double totalSum = 0;
            int totalCount = 0;

            for (String subject : sortedSubjects) {
                Integer grade = finalGrades.get(subject);
                if (grade != null) {
                    System.out.printf(" | %-10d", grade);
                    totalSum += grade;
                    totalCount++;
                } else {
                    System.out.printf(" | %-10s", "-");
                }
            }

            double averageGrade = totalCount > 0 ? totalSum / totalCount : 0;
            double percentage = averageGrade / 5 * 100;

            System.out.printf(" | %5.1f%% | %.1f%n", percentage, averageGrade);
        }
    }
}
