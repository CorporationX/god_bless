package bjs2_35333;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = StudentSupplier.getStudents();

        Map<String, Double> averageMarks = Solution.getAverageMarks(students);
        Map<String, Integer> studentMarks = Solution.getStudentMarks(students, "Андрей", "Тихонов");
        String mostDifficultSubject = Solution.getMostDifficultSubject(students);

        System.out.println(averageMarks);
        System.out.println(studentMarks);
        System.out.println(mostDifficultSubject);
    }
}
