package school.faang.bjs2_68775;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    private final Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        this.studentSubjects = new HashMap<>();
        this.subjectStudents = new HashMap<>();
    }

    public void addStudentInfo(Student student, Map<Subject, Integer> mapSubject) {
        studentSubjects.put(student, mapSubject);
        mapSubject.keySet().forEach(subject -> subjectStudents
                .computeIfAbsent(subject, students -> new ArrayList<>()).add(student));
    }

    public void addSubjectByStudent(Student student, Subject subject, int score) {
        studentSubjects.get(student).put(subject, score);
        subjectStudents.computeIfAbsent(subject, students -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        subjectStudents.values().forEach(students -> students.remove(student));
    }

    public void printAllStudentsInfo() {
        studentSubjects.forEach((key, value) -> {
            System.out.println("Student: " + key.name());
            value.entrySet().stream().map(mapSubject -> "Subject: " + mapSubject.getKey().name()
                    + "\nScore: " + mapSubject.getValue()).forEach(System.out::println);
        });
    }

    public void addSubjectInfo(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        students.forEach(student -> studentSubjects.computeIfAbsent(student, subjects ->
                new HashMap<>()).put(subject, null));
    }

    public void addStudentBySubject(Student student, Subject subject) {
        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, subjects -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentBySubject(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);
    }

    public void printAllSubjectsAndStudent() {
        subjectStudents.forEach((key, value) -> {
            System.out.println("Subject: " + key.name());
            System.out.println("Students:");
            value.stream().map(Student::name).forEach(System.out::println);
        });
    }
}
