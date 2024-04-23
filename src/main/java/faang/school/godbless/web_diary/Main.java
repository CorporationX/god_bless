package faang.school.godbless.web_diary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иван", "Иванов",
                Map.of("Математика", Arrays.asList(4, 5, 3), "Литература", Arrays.asList(4, 4, 4),
                        "Химия", Arrays.asList(3, 3, 4))));
        students.add(new Student("Петр", "Петров",
                Map.of("Математика", Arrays.asList(5, 5, 5), "Литература", Arrays.asList(4, 5, 4),
                        "Химия", Arrays.asList(4, 5, 4))));
        SchoolDiary diary = new SchoolDiary();
        Map<String, Double> averageGrades = diary.calculateAverageGrades(students);
        System.out.println("Средние оценки по предметам:");
        averageGrades.forEach((subject, averageGrade) -> System.out.println(subject + ": " + averageGrade));
        String firstName = "Иван";
        String lastName = "Иванов";
        Map<String, Integer> finalGrades = diary.calculateFinalGradesForStudent(students, firstName, lastName);
        System.out.println("\nИтоговые оценки для студента " + firstName + " " + lastName + ":");
        finalGrades.forEach((subject, finalGrade) -> System.out.println(subject + ": " + finalGrade));
        String mostDifficultSubject = diary.findMostDifficultSubject(students);
        System.out.println("\nСамый сложный предмет: " + mostDifficultSubject);
    }
}
