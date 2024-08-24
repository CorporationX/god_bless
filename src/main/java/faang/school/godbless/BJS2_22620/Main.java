package faang.school.godbless.BJS2_22620;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = getStudents();

        System.out.println(Student.subjectByAvgAssessment(students));
        System.out.println();

        System.out.println(Student.mapStudentByFinalAssessments(students));
        System.out.println();

        System.out.println(Student.findMostDifficultSubject(students).orElse("No subjects available"));
        System.out.println();

        Student.analyzeStudents(students);
    }

    private static List<Student> getStudents() {
        return List.of(
                new Student("John", "Doe", Map.of(
                        "Math", List.of(5, 3, 5),
                        "Science", List.of(5, 5, 4),
                        "History", List.of(4, 4, 4)
                )),
                new Student("Alice", "Smith", Map.of(
                        "Math", List.of(3, 4),
                        "Science", List.of(4, 4),
                        "History", List.of(4, 5)
                )),
                new Student("Bob", "Johnson", Map.of(
                        "Math", List.of(3, 2),
                        "Science", List.of(3, 3),
                        "History", List.of(3, 4)
                )),
                new Student("Emma", "Williams", Map.of(
                        "Math", List.of(5, 5, 4),
                        "Science", List.of(5, 4, 3),
                        "History", List.of(5, 5, 2)
                )),
                new Student("Robert", "Williams", Map.of(
                        "Math", List.of(5, 5, 5),
                        "Science", List.of(5, 3, 3),
                        "History", List.of(5, 2, 2)
                )),
                new Student("Sultan", "Williams", Map.of(
                        "Math", List.of(5, 5, 5),
                        "Science", List.of(5, 3, 3),
                        "History", List.of(5, 2, 2),
                        "Java", List.of(5, 5, 4)
                ))
        );
    }
}
