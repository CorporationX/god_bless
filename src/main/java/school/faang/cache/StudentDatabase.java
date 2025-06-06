package school.faang.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects;
    private Map<Subject, List<Student>> subjectStudents;

    public void addStudent(Student student, Map<Subject, Integer> mark) {
        studentSubjects.put(student, mark);
        for (Subject subject : mark.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int mark) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, mark);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        for (var entry : subjectStudents.entrySet()) {
            entry.getValue().remove(student);
        }
    }

    public void printStudent() {
        for (var entry : studentSubjects.entrySet()) {
            System.out.println("Student: " + entry.getKey());

            for (Subject subject : entry.getValue().keySet()) {
                System.out.println("Subject: " + subject + " Mark: " + entry.getValue().get(subject));
            }
        }
    }

    public void addSubject(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        students.remove(student);
        Map<Subject, Integer> grades = studentSubjects.get(student);
        grades.remove(subject);
    }
}
