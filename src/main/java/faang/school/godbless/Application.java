package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        if (studentGrades.containsKey(student)) {
            studentGrades.get(student).put(subject, grade);
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudent(Student student) {
        if (studentGrades.containsKey(student)) {
            Map<Subject, Integer> subjects = studentGrades.get(student);
            for (Subject subject : subjects.keySet()) {
                subjectStudents.get(subject).remove(student);
            }
            studentGrades.remove(student);
        }
    }

    public void printAllStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).put(subject, 0);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).put(subject, 0);
        }
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
            if (studentGrades.containsKey(student)) {
                studentGrades.get(student).remove(subject);
            }
        }
    }

    public void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Application app = new Application();

        Student student1 = new Student(1, "David");
        Student student2 = new Student(2, "Diana");

        Subject math = new Subject(1, "Mathematics");
        Subject physics = new Subject(2, "Physics");

        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 5);
        grades1.put(physics, 5);

        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(math, 3);

        app.addStudent(student1, grades1);
        app.addStudent(student2, grades2);

        app.printAllStudentsAndGrades();
        app.printAllSubjectsAndStudents();

        app.addSubjectToStudent(student2, physics, 4);
        app.printAllStudentsAndGrades();

        app.removeStudentFromSubject(student2, math);
        app.printAllStudentsAndGrades();

        app.removeStudent(student1);
        app.printAllStudentsAndGrades();
        app.printAllSubjectsAndStudents();
    }
}
