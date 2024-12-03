package school.faang.task45219;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> everyStudentScore = new HashMap<>();
        Map<Subject, List<Student>> studentLearnAll = new HashMap<>();
        Map<Subject, Integer> subjectAndScore = new HashMap<>();

        List<Subject> subjects = Arrays.asList(
                new Subject(1, "Физика"),
                new Subject(2, "Математика"),
                new Subject(3, "Физкультура"),
                new Subject(4, "ОБЖ"),
                new Subject(5, "Астрономия")
        );

        List<Student> students = Arrays.asList(
                new Student(1, "Алексей"),
                new Student(2, "Сергей"),
                new Student(3, "Марина"),
                new Student(4, "Кирилл")
        );

    }
}
