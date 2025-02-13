package school.faang.task_57157;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    private final Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        studentSubjects = new HashMap<>();
        subjectStudents = new HashMap<>();
    }

    public void addStudentWithGrades(@NonNull Student student, @NonNull Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.computeIfAbsent(subject, event -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(@NonNull Subject subject, @NonNull Student student, int grade) {
        studentSubjects.computeIfAbsent(student, event -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, event -> new ArrayList<>()).add(student);
    }

    public void removeStudent(@NonNull Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllSubjectsWithStudentsAndGrade() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentEntry : studentSubjects.entrySet()) {
            System.out.printf("Student: %s", studentEntry.getKey());
            for (Map.Entry<Subject, Integer> subjectEntry : studentEntry.getValue().entrySet()) {
                System.out.printf("Subject: %s grade: %d", subjectEntry.getKey(),
                        subjectEntry.getValue());
            }
        }
    }
    public void addSubjectWithStudents(@NonNull Subject subject,  List<Student> students){
        subjectStudents.put(subject, students);
        for (Student student : students){
            studentSubjects.computeIfAbsent(student,
                    event -> new HashMap<>()).put(subject, null);
        }
    }
    public void addStudentToSubject(@NonNull Student student, @NonNull Subject subject){
        subjectStudents.computeIfAbsent(subject, event -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, event -> new HashMap<>()).put(subject, null);
    }
    public void removeStudentFromSubject(@NonNull Student student,@NonNull Subject subject){
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.printf("Subject: %s ", subject.getName());
            for (Student student : entry.getValue()) {
                System.out.println("\t Student: " + student.getName());
            }
        }
    }
}
