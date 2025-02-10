package school.faang.doublecache;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private @NonNull Map<Student, Map<Subject, Integer>> studentSubjects;
    private @NonNull Map<Subject, List<Student>> subjectStudents;

    public void addStudentWithGrades(@NonNull Student student, @NonNull Map<Subject, Integer> grades) {
        if (studentSubjects.putIfAbsent(student, grades) == null) {
            for (Map.Entry<Subject, Integer> subject : grades.entrySet()) {
                subjectStudents.putIfAbsent(subject.getKey(), new ArrayList<>()).add(student);
            }
        }
    }

    public void addSubjectForStudent(@NonNull Student student, @NonNull Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(@NonNull Student student) {
        Map<Subject, Integer> subjects = studentSubjects.remove(student);
        if (subjects != null) {
            for (Subject subject : subjects.keySet()) {
                subjectStudents.computeIfPresent(subject, (k, students) -> {
                    students.remove(student);
                    return students.isEmpty() ? null : students;
                });
            }
        }
    }

    public void printAllStudentsWithSubjectsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentEntry : studentSubjects.entrySet()) {
            System.out.println("Студент: " + studentEntry.getKey());
            System.out.println("\tПредмет - Оценка:");
            for (Map.Entry<Subject, Integer> subjectEntry : studentEntry.getValue().entrySet()) {
                System.out.println("\t" + subjectEntry.getKey() + " - " + subjectEntry.getValue());
            }
        }
    }

    public void addSubjectWithStudents(@NonNull Subject subject, @NonNull List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(@NonNull Student student, @NonNull Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(@NonNull Student student, @NonNull Subject subject) {
        subjectStudents.computeIfPresent(subject, (k, v) -> {
            v.remove(student);
            return v;
        });
        studentSubjects.computeIfPresent(student, (k, v) -> {
            v.remove(subject);
            return v;
        });
    }

    public void printAllSubjectWithStudents() {
        for (Map.Entry<Subject, List<Student>> entrySubject : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entrySubject.getKey());
            System.out.println("\tСтуденты:");
            entrySubject.getValue().forEach(student -> System.out.println("\t" + student));
        }
    }
}
