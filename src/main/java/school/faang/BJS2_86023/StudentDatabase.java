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

    public void addStudentTiSubject(Student student, Subject subject) {
        subjectStudents.get(subject).add(student);
        studentSubjects.get(student).put(subject, -1);
    }

    public void addSubject(Student student, Subject subject, int score) {
        studentSubjects.get(student).put(subject, score);
        subjectStudents.get(subject).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);
    }

    public void removeStudent(Student student) {
        Set<Subject> subjects = studentSubjects.remove(student).keySet();
        for (Subject subject : subjects) {
            subjectStudents.get(subject).remove(student);
        }
    }

    public void printSubjectStudents() {
        System.out.println(subjectStudents);
    }

    public void printStudentSubjects() {
        System.out.println(studentSubjects);
    }
}
