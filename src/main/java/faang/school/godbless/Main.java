package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static HashMap<Student, Map<Subject, Integer>> students = new HashMap<>();
    private static HashMap<Subject, List<Student>> subjects = new HashMap<>();

    public static void addNewStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        if (!students.containsKey(student)) {
            students.put(student, subjects);
        }
    }

    public static void addNewSubject(Student student, Subject subject, int mark) {
        var subjectsMap = students.get(student);
        subjectsMap.put(subject, mark);
        students.replace(student, subjectsMap);
    }

    public static void deleteStudent(Student student) {
        students.remove(student);
    }

    public static void printAllStudents() {
        for (var entry : students.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }
    }

    public static void addNewSubject(Subject subject, List<Student> students) {
        subjects.put(subject, students);
    }

    public static void addNewStudent(Subject subject, Student student) {
        var students = subjects.get(subject);
        students.add(student);
        subjects.replace(subject, students);
    }

    public static void removeStudent(Subject subject, Student student) {
        if (subjects.containsKey(subject)) {
            var students = subjects.get(subject);
            students.remove(student);
            subjects.replace(subject, students);
        }
    }

    public static void printAllSubjects() {
        for (var entry : subjects.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Sergey");
        Student student2 = new Student(2, "Alex");
        Student student3 = new Student(3, "Kim");
        Student student4 = new Student(4, "Tim");

        Subject subject1 = new Subject(1, "Algebra");
        Subject subject2 = new Subject(2, "Mechanics");
        Subject subject3 = new Subject(3, "Vocal");
        Subject subject4 = new Subject(4, "Music");

        Map<Subject, Integer> map1 = new HashMap<>();
        map1.put(subject1, 5);
        map1.put(subject2, 3);
        map1.put(subject4, 2);

        Map<Subject, Integer> map2 = new HashMap<>();
        map2.put(subject1, 5);
        map2.put(subject2, 3);
        map2.put(subject3, 5);

        addNewStudentWithSubjects(student1, map1);
        addNewStudentWithSubjects(student2, map2);
        printAllStudents();
        addNewSubject(student1, subject3, 1);
        printAllStudents();
        deleteStudent(student1);
        printAllStudents();

        List<Student> studentList1 = new ArrayList<>(Arrays.asList(new Student[]{student1, student2, student3}));
        List<Student> studentList2 = new ArrayList<>(Arrays.asList(new Student[]{student1, student4}));
        addNewSubject(subject1, studentList1);
        addNewSubject(subject3, studentList2);
        printAllSubjects();
        addNewStudent(subject3, student2);
        printAllSubjects();
    }
}
