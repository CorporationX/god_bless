package school.faang.sprint1.task_45271;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            if (subjectStudents.get(subject) == null) {
                System.out.println("Предмет не найден!");
            } else {
                subjectStudents.get(subject).add(student);
            }
        }

    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        if (!studentGrades.containsKey(student)) {
            System.out.println("Студент не найден!");
            return;
        }
        studentGrades.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        if (!studentGrades.containsKey(student)) {
            System.out.println("Студент не найден.");
            return;
        }
        Map<Subject, Integer> grades = studentGrades.get(student);
        for (Subject subject : grades.keySet()) {
            subjectStudents.get(subject).remove(student);
        }
        studentGrades.remove(student);
    }

    public void printAllStudentsWithGrades() {
        System.out.println("Список студентов и их оценки:");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> grades = entry.getValue();
            System.out.println(student + " -> " + grades);
        }
    }
}