package school.faang.BJS2_57045;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private static final int MAX_GRADE = 5;
    private static final int MIN_GRADE = 1;
    private static final int DEFAULT_GRADE = 0;
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        validateStudent(student);
        if (studentSubjects.containsKey(student)) {
            System.out.printf(String.format("Student %s has already been added.", student.getName()));
            return;
        }
        studentSubjects.put(student, subjects);
        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            subjectStudents.putIfAbsent(entry.getKey(), new ArrayList<>());
            subjectStudents.get(entry.getKey()).add(student);
        }
    }

    public void addSubjectToStudent(Subject subject, Student student, int grade) {
        validateSubject(subject);
        validateStudent(student);
        validateGradle(grade);
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException(String.format("Student %s has not been added.", student.getName()));
        }
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        validateStudent(student);
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("student has not been added");
        }
        Set<Subject> subjects = studentSubjects.get(student).keySet();
        for (Subject subject : subjects) {
            subjectStudents.get(subject).remove(student);
        }
        studentSubjects.remove(student);
    }

    public void printStudentsWithGrade() {
        StringBuilder allStudents = new StringBuilder();
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            allStudents.append("Student: ").append(entry.getKey().getName()).append("\n");
            allStudents.append("Subjects: ").append("\n");
            for (Map.Entry<Subject, Integer> entry1 : entry.getValue().entrySet()) {
                allStudents.append(entry1.getKey().getName()).append(" - ").append(entry1.getValue())
                        .append("\n");
            }
            allStudents.append("\n");
        }
        System.out.println(allStudents);
    }

    public void addSubjectFromStudent(Subject subject, List<Student> students) {
        validateSubject(subject);
        if (subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException("student has already been added");
        }
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, DEFAULT_GRADE);
        }
    }

    public void addStudentFromSubject(Student student, Subject subject, int grade) {
        validateStudent(student);
        validateSubject(subject);
        validateGradle(grade);
        if (studentSubjects.containsKey(student) && studentSubjects.get(student).containsKey(subject)) {
            throw new IllegalArgumentException("student has already been added");
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.get(subject).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        validateStudent(student);
        validateSubject(subject);
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("student has not been added");
        }
        studentSubjects.remove(student);
        subjectStudents.get(subject).remove(student);
    }

    public void printSubjectsWithStudents() {
        StringBuilder allSubjects = new StringBuilder();
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            allSubjects.append("Subject: ").append(entry.getKey().getName()).append("\n");
            for (Student student : entry.getValue()) {
                allSubjects.append(student.getName()).append("\n");
            }
        }
        System.out.println(allSubjects);
    }

    private void validateStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
    }

    private void validateSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("subject is null");
        }
    }

    private void validateGradle(int grade) {
        if (grade < MIN_GRADE || grade > MAX_GRADE) {
            throw new IllegalArgumentException("grade must be between " + MIN_GRADE + " and " + MAX_GRADE);
        }
    }
}
