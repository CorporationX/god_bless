package school.faang.doubleCash;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    private static final int DEFAULT_GRADE = 0;
    private static final int MIN_GRADE = 1;
    private static final int MAX_GRADE = 5;

    public void addNewStudentWithGrades(Student student, @NonNull Map<Subject, Integer> grades) {
        if (studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Student " + student.getName() + " already exists.");
        }

        studentSubjects.put(student, new HashMap<>(grades));
        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            Subject subject = entry.getKey();
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, @NonNull int grade) {
        validateStudentExists(student);
        validateGrade(grade);

        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects.containsKey(subject)) {
            throw new IllegalArgumentException("Student " + student.getName()
                    + " already has subject " + subject.getName());
        }

        subjects.put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades == null) {
            throw new IllegalArgumentException("Student " + student.getName() + " does not exist.");
        }

        for (Subject subject : grades.keySet()) {
            List<Student> students = subjectStudents.get(subject);
            if (students != null) {
                students.remove(student);
            }
        }
    }

    public void printAllStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> subjects = entry.getValue();
            System.out.println("Student: " + student.getName());

            for (Map.Entry<Subject, Integer> subjectEntry : subjects.entrySet()) {
                Subject subject = subjectEntry.getKey();
                Integer grade = subjectEntry.getValue();
                System.out.println("  Subject: " + subject.getName() + ", Grade: " + grade);
            }
            System.out.println();
        }
    }

    public void addSubjectWithStudents(Subject subject, @NonNull List<Student> students) {
        if (subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException("Subject " + subject.getName() + " already exists.");
        }

        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, DEFAULT_GRADE);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException(subject.getName() + "subject already exists");
        }

        subjectStudents.get(subject).add(student);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, DEFAULT_GRADE);
    }

    public void removeStudentToSubject(Student student, Subject subject) {
        validateStudentExists(student);

        if (!studentSubjects.get(student).containsKey(subject)) {
            throw new IllegalArgumentException("Student " + student.getName()
                    + " is not enrolled in " + subject.getName());
        }

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
            System.out.println("Subject: " + entry.getKey());
            List<Student> students = entry.getValue();

            for (Student student : students) {
                System.out.println("Student: " + student.getName());
            }
            System.out.println();
        }
    }

    private void validateStudentExists(Student student) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Student " + student.getName() + " does not exist.");
        }
    }

    private void validateGrade(int grade) {
        if (grade < MIN_GRADE || grade > MAX_GRADE) {
            throw new IllegalArgumentException("Grade must be between " + MIN_GRADE + " and " + MAX_GRADE);
        }
    }
}