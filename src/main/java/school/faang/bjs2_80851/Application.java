package school.faang.bjs2_80851;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws IOException {
        List<Student> students = StudentLoader.loadStudentsFromResources("students_test_data.json");
        System.out.println("Loaded students: " + students.size());

        StudentPerformance performance = new StudentPerformance();

        Map<String, Double> averagePerSubject = performance.calculateAverageGrade(students);
        System.out.println("Average grades per subject:");
        averagePerSubject.forEach((subject, avg) -> System.out.printf("%s: %.2f%n", subject, avg));

        if (!students.isEmpty()) {
            Student firstStudent = students.get(0);
            Map<String, Integer> finalGrades = performance.getFinalGradesForStudent(
                    students, firstStudent.getFirstName(), firstStudent.getLastName());
            System.out.println("\nFinal grades for " +
                               firstStudent.getFirstName() + " " + firstStudent.getLastName() + ":");
            finalGrades.forEach((subj, grade) -> System.out.println(subj + ": " + grade));
        }

        String hardestSubject = performance.findMostDifficultSubject(students);
        System.out.println("\nHardest subject in school: " + hardestSubject);

        System.out.println("\nPerformance table:");
        performance.printPerformanceTable(students);

    }
}