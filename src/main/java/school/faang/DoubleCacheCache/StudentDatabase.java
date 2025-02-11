package school.faang.DoubleCacheCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (subjects == null) {
            throw new IllegalArgumentException("Subjects cannot be null");
        }

        studentSubjects.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (studentSubjects.containsKey(student)) {
            Map<Subject, Integer> subjects = studentSubjects.remove(student);
            for (Subject subject : subjects.keySet()) {
                subjectStudents.get(subject).remove(student);
            }
        }
    }

    public void printAllStudentWithGrades() {
        if (studentSubjects == null) {
            throw new IllegalArgumentException("Student subjects cannot be null");
        }

        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println("Student: " + entry.getKey());
            for (Map.Entry<Subject, Integer> gradeEntry : entry.getValue().entrySet()) {
                System.out.println(" Subject: " + gradeEntry.getKey() + " – Grade: " + gradeEntry.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (students == null) {
            throw new IllegalArgumentException("Students cannot be null");
        }

        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }

        subjectStudents.getOrDefault(subject, new ArrayList<>()).remove(student);
        studentSubjects.getOrDefault(student, new HashMap<>()).remove(subject);
    }

    public void printAllSubjectsWithStudents() {
        if (subjectStudents == null) {
            throw new IllegalArgumentException("Subject students cannot be null");
        }

        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(" Student: " + student);
            }
        }
    }
}

