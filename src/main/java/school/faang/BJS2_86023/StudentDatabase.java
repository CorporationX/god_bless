package school.faang.BJS2_86023;

import java.util.*;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentSubjects(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.get(student).put(subject, -1);
        }
    }

    public void addStudentSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void addSubject(Student student, Subject subject, int score) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, score);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).remove(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).remove(subject);
    }

    public void removeStudent(Student student) {
        Set<Subject> subjects = studentSubjects.remove(student).keySet();
        for (Subject subject : subjects) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).remove(student);
        }
    }

    public void printSubjectStudents() {
        System.out.println(subjectStudents);
    }

    public void printStudentSubjects() {
        System.out.println(studentSubjects);
    }
}
