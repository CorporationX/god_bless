package school.faang.hashhash;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private static final int MIN_GRADE = 1;
    private static final int MAX_GRADE = 5;
    private static final int DEFAULT_GRADE = 0;
    private final Map<Student, Map<Subject, Integer>> studentSubject = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubject(Student student, @NonNull Map<Subject, Integer> subjects) {
        validationStudent(student);
        Set<Subject> subjectsKey = subjects.keySet();
        for (Subject subject : subjectsKey) {
            validationSubject(subject);
        }
        if (studentSubject.containsKey(student)) {
            throw new IllegalArgumentException("Student is already in the database");
        }
        studentSubject.put(student, subjects);
        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            subjectStudents.putIfAbsent(entry.getKey(), new ArrayList<>());
            subjectStudents.get(entry.getKey()).add(student);
        }
    }

    public void addSubjectForStudent(Subject subject, Student student, int grade) {
        validationStudent(student);
        validationSubject(subject);
        validationGrade(grade);
        if (!studentSubject.containsKey(student)) {
            throw new IllegalArgumentException(String.format("Student %s has not been added", student.getName()));
        }
        Set<Subject> keyStudentSubject = studentSubject.get(student).keySet();
        if (keyStudentSubject.contains(subject)) {
            throw new IllegalArgumentException("Subject is already in the database");
        }
        studentSubject.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        validationStudent(student);
        if (!studentSubject.containsKey(student)) {
            throw new IllegalArgumentException(String.format("Student %s has not been added", student.getName()));
        }
        Set<Subject> subjects = studentSubject.get(student).keySet();
        studentSubject.remove(student);
        for (Subject subject : subjects) {
            subjectStudents.get(subject).remove(student);
        }
    }

    public void printAllStudentWithSubject() {
        StringBuilder allStudents = new StringBuilder();
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubject.entrySet()) {
            allStudents.append(entry.getKey().getName()).append("\n");
            for (Map.Entry<Subject, Integer> entry1 : entry.getValue().entrySet()) {
                allStudents.append(entry1.getKey().getName()).append(":").append(entry1.getValue()).append("\n");
            }
            allStudents.append("\n");
        }
        System.out.println(allStudents);
    }

    public void addSubject(@NonNull List<Student> students, Subject subject) {
        for (Student student : students) {
            validationStudent(student);
        }
        validationSubject(subject);
        if (subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException(String.format("Subject has alredy %s   added", subject.getName()));
        }
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubject.putIfAbsent(student, new HashMap<>());
            studentSubject.get(student).put(subject, DEFAULT_GRADE);
        }
    }

    public void addStudentForSubject(Student newStudent, Subject subject) {
        validationStudent(newStudent);
        validationSubject(subject);
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException(String.format("Subject %s has not been added", subject.getName()));
        }
        studentSubject.putIfAbsent(newStudent, new HashMap<>());
        studentSubject.get(newStudent).put(subject, DEFAULT_GRADE);
        subjectStudents.get(subject).add(newStudent);
    }

    public void removeStudentForSubject(Student student, Subject subject) {
        validationStudent(student);
        validationSubject(subject);
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException(String.format("Subject %s has not been added", subject.getName()));
        }
        Set<Subject> keyStudentSubject = studentSubject.get(student).keySet();
        if (!keyStudentSubject.contains(subject)) {
            throw new IllegalArgumentException(String.format("Student %s has not been added", student.getName()));
        }
        studentSubject.get(student).remove(subject);
        subjectStudents.get(subject).remove(student);
    }

    public void printAllSubjectWithStudents() {
        StringBuilder allSubjects = new StringBuilder();
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            allSubjects.append(entry.getKey().getName()).append(":").append("\n");
            List<Student> students = entry.getValue();
            for (Student student : students) {
                allSubjects.append(student.getName()).append("\n");
            }
            allSubjects.append("\n");
        }
        System.out.println(allSubjects);
    }


    private void validationStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("student is null");
        }
    }

    private void validationSubject(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("subject is null");
        }
    }

    private void validationGrade(int grade) {
        if (grade < MIN_GRADE || grade > MAX_GRADE) {
            throw new IllegalArgumentException("grade must be between " + MIN_GRADE + " and " + MAX_GRADE);
        }
    }
}
