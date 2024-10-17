package school.faang.electronicdiary;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            List<Student> students = StudentLoader.loadStudents("src/main/resources/students_test_data.json");

            Map<String, Double> averageGrades = SchoolAnalyzer.calculateAverageGradePerSubject(students);
            System.out.println("Average grades per subject:");
            averageGrades.forEach((subject, avg) -> System.out.println(subject + ": " + avg));

            String firstName = "Ivan";
            String lastName = "Ivanov";
            Map<String, Integer> finalGrades = SchoolAnalyzer.getFinalGradesForStudent(students, firstName, lastName);
            System.out.println("\nFinal grades for " + firstName + " " + lastName + ":");
            finalGrades.forEach((subject, grade) -> System.out.println(subject + ": " + grade));

            String hardestSubject = SchoolAnalyzer.findMostDifficultSubject(students);
            System.out.println("\nMost difficult subject: " + hardestSubject);

            System.out.println("\nPerformance table:");
            SchoolAnalyzer.printPerformanceTable(students);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


