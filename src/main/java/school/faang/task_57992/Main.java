package school.faang.task_57992;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ledi", "Gaga", Map.of("Math", List.of(4, 3, 2, 4, 3, 2, 4, 3, 2))));
        students.add(new Student("Ledi", "Gaga", Map.of("Math", List.of(4, 3, 2, 4, 3, 2, 4, 3, 2))));
        StudentAnalyzer studentAnalyzer = new StudentAnalyzer();
        studentAnalyzer.calculateAverageGradePerSubject(students);
    }
}
