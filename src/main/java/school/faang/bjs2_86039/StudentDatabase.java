package school.faang.bjs2_86039;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public void addStudent(@NonNull Student student, Map<Subject, Integer> subjects) {
        if (STUDENT_SUBJECTS.containsKey(student)) {
            for (Map.Entry<Subject, Integer> subjectEntry : subjects.entrySet()) {
                addSubjectForExistStudent(student, subjectEntry.getKey(), subjectEntry.getValue());
            }
        } else {
            STUDENT_SUBJECTS.put(student, subjects);
            for (Subject subject : subjects.keySet()) {
                SUBJECT_STUDENTS.computeIfAbsent(
                        subject,
                        key -> new ArrayList<>()
                ).add(student);
            }
        }
    }

    public void addSubject(@NonNull Subject subject, List<Student> students) {
        if (SUBJECT_STUDENTS.containsKey(subject)) {
            for (Student student : students) {
                addStudentForExistSubject(subject, student);
            }
        } else {
            SUBJECT_STUDENTS.put(subject, students);
            for (Student student : students) {
                STUDENT_SUBJECTS.computeIfAbsent(
                        student,
                        key -> new HashMap<>()
                ).putIfAbsent(
                        subject,
                        null
                );
            }
        }
    }

    public void addSubjectForExistStudent(@NonNull Student student, @NonNull Subject subject, int grade) {
        STUDENT_SUBJECTS.computeIfAbsent(
                student,
                key -> new HashMap<>()
        ).put(subject, grade);

        if (SUBJECT_STUDENTS.get(subject) != null && !SUBJECT_STUDENTS.get(subject).contains(student)) {
            SUBJECT_STUDENTS.computeIfAbsent(
                    subject,
                    key -> new ArrayList<>()
            ).add(student);
        }
    }

    public void addStudentForExistSubject(@NonNull Subject subject, @NonNull Student student) {
        if (SUBJECT_STUDENTS.get(subject) != null && !SUBJECT_STUDENTS.get(subject).contains(student)) {
            SUBJECT_STUDENTS.computeIfAbsent(
                    subject,
                    key -> new ArrayList<>()
            ).add(student);
        }

        STUDENT_SUBJECTS.computeIfAbsent(
                student,
                key -> new HashMap<>()
        ).putIfAbsent(
                subject,
                null
        );
    }

    public void removeStudent(@NonNull Student student) {
        final Map<Subject, Integer> subjectMap = STUDENT_SUBJECTS.remove(student);
        if (subjectMap != null) {
            for (Subject subject : subjectMap.keySet()) {
                if (SUBJECT_STUDENTS.get(subject) != null) {
                    SUBJECT_STUDENTS.get(subject).remove(student);
                }
            }
        }
    }

    public void removeStudentFromSubject(@NonNull Subject subject, @NonNull Student student) {
        final boolean studentRemoved = SUBJECT_STUDENTS.get(subject).remove(student);
        if (studentRemoved) {
            if (STUDENT_SUBJECTS.get(student) != null) {
                STUDENT_SUBJECTS.get(student).remove(subject);
            }
        }
    }

    public void printAllStudentsWithSubjects() {
        for (Map.Entry<Student, Map<Subject, Integer>> students : STUDENT_SUBJECTS.entrySet()) {
            System.out.printf("Student name: %s\n", students.getKey().getName());
            for (Map.Entry<Subject, Integer> subjects : students.getValue().entrySet()) {
                System.out.printf("- Subject: %s Grade: %s\n", subjects.getKey(), subjects.getValue());
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> subjects : SUBJECT_STUDENTS.entrySet()) {
            System.out.printf("Subject: %s\n", subjects.getKey().getName());
            System.out.println("Students: ");
            for (Student student : subjects.getValue()) {
                System.out.printf("- %s\n", student.getName());
            }
        }
    }
}