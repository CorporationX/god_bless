package school.faang.task45240.services;

import school.faang.task45240.model.Student;
import school.faang.task45240.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentGrades.putIfAbsent(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.computeIfAbsent(subject, init -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {

        Map<Subject, Integer> grades = studentGrades.get(student);

        if (grades != null) {
            grades.put(subject, grade);
            subjectStudents.computeIfAbsent(subject, init -> new ArrayList<>()).add(student);

            if (studentGrades.containsKey(student)) {
                studentGrades.get(student).putIfAbsent(subject, grade);
                subjectStudents.computeIfAbsent(subject, init -> new ArrayList<>()).add(student);
            }
        }


    }

    public void removeStudent(Student student) {
        studentGrades.remove(student);
        for (Subject subject : subjectStudents.keySet()) {
            List<Student> students = subjectStudents.get(subject);
            if (students != null) {
                students.remove(student);
            }
        }
    }

    public void printGradedStudents() {
        System.out.println("=======");
        System.out.println("printGradedStudents: ");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + " has grades:");
            System.out.println(entry.getValue());
        }
        System.out.println("=======");
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentGrades.computeIfAbsent(student, init -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, init -> new ArrayList<>()).add(student);
        studentGrades.computeIfAbsent(student, init -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printStudentSubjects() {
        System.out.println("=======");
        System.out.println("printStudentSubjects: ");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("=======");
    }
}
