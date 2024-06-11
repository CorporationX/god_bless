package faang.school.godbless.task12;

import java.util.*;

public class Main {
    public static Map<Student, Map<Subject, Integer>> studentMarks = new HashMap<>();
    public static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Physics");

        // Добавляем студентов и их предметы
        Map<Subject, Integer> subjectIntegerMap = new HashMap<>();
        subjectIntegerMap.put(subject2, 90);
        subjectIntegerMap.put(subject1, 85);

        addStudentAndSubjectWithMarks(student1, subjectIntegerMap);
        addStudentAndSubjectWithMarks(student2, subjectIntegerMap);

        // Выводим оценки студентов по предметам
        printStudentsAndMarks();

        // Добавляем новый предмет и студентов
        addSubject(student1, subject1, 40);

        // Выводим список студентов, изучающих предметы
        printStudentsAndMarks();

        // Удаляем студента из предмета
        removeStudent(student1);

        // Выводим список студентов, изучающих предметы после удаления
        printSubjectsAndStudents();
    }

    public static void addSubject(Student student, Subject subject, int mark) {
        studentMarks.computeIfAbsent(student, k -> new HashMap<>()).put(subject, mark);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void addStudentAndSubjectWithMarks(Student student, Map<Subject, Integer> marks) {
        if (studentMarks.containsKey(student)) {
            studentMarks.get(student).putAll(marks);
        } else {
            studentMarks.put(student, marks);
        }
        for (Map.Entry<Subject, Integer> entry : marks.entrySet()) {
            if (subjectStudents.containsKey(entry.getKey())) {
                subjectStudents.get(entry.getKey()).add(student);
            } else subjectStudents.put(entry.getKey(), new ArrayList<>(Collections.singletonList(student)));

        }
    }

    public static void removeStudent(Student student) {
        studentMarks.remove(student);
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            subjectStudents.get(entry.getKey()).remove(student);
        }
    }

    public static void printStudentsAndMarks() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentMarks.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " Marks: " + entry.getValue());
        }
    }

    public static void printSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + " Student: " + entry.getValue());
        }
    }
}
