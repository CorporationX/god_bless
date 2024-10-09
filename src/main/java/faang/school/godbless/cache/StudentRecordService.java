package faang.school.godbless.cache;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRecordService {
    private final Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    private final Map<Subject, List<Student>> subjects = new HashMap<>();

    public void addSubjectsForStudent(@NonNull Student student, @NonNull Map<Subject, Integer> subjects) {
        students.computeIfAbsent(student, v -> new HashMap<>()).putAll(subjects);
    }

    public void addSubjectForStudent(@NonNull Student student, @NonNull Subject subject, @NonNull Integer grade) {
        students.computeIfAbsent(student, v -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudentGrades(@NonNull Student student) {
        students.remove(student);
    }

    public void printStudentGrades() {
        System.out.println(students);
    }

    public void addStudentsForSubject(@NonNull Subject subject, @NonNull List<Student> students) {
        subjects.computeIfAbsent(subject, v -> new ArrayList<>()).addAll(students);
    }

    public void addStudentForSubject(@NonNull Subject subject, @NonNull Student student) {
        subjects.computeIfAbsent(subject, v -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        var foundSubject = subjects.get(subject);
        if (foundSubject != null) {
            foundSubject.remove(student);
        }
    }

    public void printSubjects() {
        System.out.println(subjects);
    }

}
