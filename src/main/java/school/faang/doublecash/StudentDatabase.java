package school.faang.doublecash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects;
    private Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        studentSubjects = new HashMap<>();
        subjectStudents = new HashMap<>();
    }

    public void addNewStudent(Student student, Map<Subject, Integer> mapSubject) {
        studentSubjects.put(student, mapSubject);
        mapSubject.forEach((students, grade) ->
                subjectStudents.computeIfAbsent(students, newList -> new ArrayList<>()).add(student));
    }

    public void addNewSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, newList -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        subjectStudents.forEach((subject, students) -> students.remove(student));
    }

    public void printAllSubjectsWithStudents() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.println("Student: " + student.getName());
            subjects.forEach((subject, grade) ->
                    System.out.println("Subject: " + subject.getName() + " Grade: " + grade));
        });
    }

    public void addNewSubjectsWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        students.forEach(student ->
                studentSubjects.computeIfAbsent(student, newMap -> new HashMap<>()).put(subject, null));
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, newMap -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);
    }

    public void printAllSubjectsAndStudent() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println("Subject: " + subject.getName() + "\nStudents: ");
            students.forEach(student -> System.out.println(" - " + student.getName()));
        });
    }
}