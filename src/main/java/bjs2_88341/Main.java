package bjs2_88341;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Student> students = StudentLoader.loadStudents("students_test_data.json");

        Map<String, Double> avgPerSubject = StudentAnalyzer.calculateAverageGradePerSubject(students);
        System.out.println("Средние оценки по предметам: " + avgPerSubject);

        Map<String, Integer> finalGrades = StudentAnalyzer.getFinalGradesForStudent(students, "Даша", "Волкова");
        System.out.println("Итоговые оценки Даша Волкова: " + finalGrades);

        String hardSubject = StudentAnalyzer.findMostDifficultSubject(students);
        System.out.println("Самый сложный предмет: " + hardSubject);

        System.out.println("\nТаблица успеваемости:");
        StudentAnalyzer.printPerformanceTable(students);
    }
}