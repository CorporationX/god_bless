package school.faang.sprint1.task_45271;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();

        final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

        final Student student1 = new Student(1, "Иван Иванов");
        final Student student2 = new Student(2, "Мария Петрова");

        Subject math = new Subject(1, "Математика");
        Subject physics = new Subject(2, "Физика");

        Map<Subject, Integer> gradesForIvan = new HashMap<>();
        gradesForIvan.put(math, 90);
        gradesForIvan.put(physics, 85);
        studentGrades.put(student1, gradesForIvan);

        Map<Subject, Integer> gradesForMaria = new HashMap<>();
        gradesForMaria.put(math, 95);
        studentGrades.put(student2, gradesForMaria);

        subjectStudents.putIfAbsent(math, new ArrayList<>());
        subjectStudents.get(math).add(student1);
        subjectStudents.get(math).add(student2);

        subjectStudents.putIfAbsent(physics, new ArrayList<>());
        subjectStudents.get(physics).add(student1);

        System.out.println("Список студентов и их оценки:");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> grades = entry.getValue();
            System.out.println(student + " -> " + grades);
        }

        System.out.println("\nСписок предметов и студентов:");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();
            System.out.println(subject + " -> " + students);
        }

    }
}
