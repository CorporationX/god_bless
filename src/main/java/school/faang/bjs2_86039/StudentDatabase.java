package school.faang.bjs2_86039;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectsStudent = new HashMap<>();

    public void addStudent(@NonNull Student student, Map<Subject, Integer> subjects) {
        if (studentSubjects.containsKey(student)) {
            for (Map.Entry<Subject, Integer> subjectEntry : subjects.entrySet()) {
                addSubjectForExistStudent(student, subjectEntry.getKey(), subjectEntry.getValue());
            }
        } else {
            studentSubjects.put(student, subjects);
            for (Subject subject : subjects.keySet()) {
                subjectsStudent.computeIfAbsent(
                        subject,
                        key -> new ArrayList<>()
                ).add(student);
            }
        }
    }

    public void addSubject(@NonNull Subject subject, List<Student> students) {
        if (subjectsStudent.containsKey(subject)) {
            for (Student student : students) {
                addStudentForExistSubject(subject, student);
            }
        } else {
            subjectsStudent.put(subject, students);
            for (Student student : students) {
                studentSubjects.computeIfAbsent(
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
        studentSubjects.computeIfAbsent(
                student,
                key -> new HashMap<>()
        ).put(subject, grade);

        if (subjectsStudent.get(subject) != null && !subjectsStudent.get(subject).contains(student)) {
            subjectsStudent.computeIfAbsent(
                    subject,
                    key -> new ArrayList<>()
            ).add(student);
        }
    }

    public void addStudentForExistSubject(@NonNull Subject subject, @NonNull Student student) {
        if (subjectsStudent.get(subject) != null && !subjectsStudent.get(subject).contains(student)) {
            subjectsStudent.computeIfAbsent(
                    subject,
                    key -> new ArrayList<>()
            ).add(student);
        }

        studentSubjects.computeIfAbsent(
                student,
                key -> new HashMap<>()
        ).putIfAbsent(
                subject,
                null
        );
    }

    public void removeStudent(@NonNull Student student) {
        final Map<Subject, Integer> subjectMap = studentSubjects.remove(student);
        if (subjectMap != null) {
            for (Subject subject : subjectMap.keySet()) {
                if (subjectsStudent.get(subject) != null) {
                    subjectsStudent.get(subject).remove(student);
                }
            }
        }
    }

    public void removeStudentFromSubject(@NonNull Subject subject, @NonNull Student student) {
        final boolean studentRemoved = subjectsStudent.get(subject).remove(student);
        if (studentRemoved) {
            if (studentSubjects.get(student) != null) {
                studentSubjects.get(student).remove(subject);
            }
        }
    }

    public void printAllStudentsWithSubjects() {
        for (Map.Entry<Student, Map<Subject, Integer>> students : studentSubjects.entrySet()) {
            System.out.printf("Student name: %s\n", students.getKey().getName());
            for (Map.Entry<Subject, Integer> subjects : students.getValue().entrySet()) {
                System.out.printf("- Subject: %s Grade: %s\n", subjects.getKey(), subjects.getValue());
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> subjects : subjectsStudent.entrySet()) {
            System.out.printf("Subject: %s\n", subjects.getKey().getName());
            System.out.println("Students: ");
            for (Student student : subjects.getValue()) {
                System.out.printf("- %s\n", student.getName());
            }
        }
    }
}