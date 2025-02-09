package school.faang.bjs2_56955;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private static final int DEFAULT_GRADE = 0;
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(@NonNull Student student, @NonNull Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).putIfAbsent(subject, grade);
        List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        };
    }

    public void addSubjectForStudent(@NonNull Student student, @NonNull Subject subject, int grade) {
        if (!studentSubjects.containsKey(student)) {
            System.out.println("Student " + student.getName() + " does not exist");
            return;
        }
        studentSubjects.get(student).putIfAbsent(subject, grade);
        List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudentAndSubjectForStudent(Student student) {
        if (!studentSubjects.containsKey(student)) {
            System.out.println("Student " + student.getName() + " does not exist");
            return;
        }
        studentSubjects.remove(student);
        subjectStudents.values().forEach(students -> students.remove(student));
    }

    public void printAllStudentsAndRangeForStudent() {
        if (studentSubjects.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        studentSubjects.forEach((student, subjects) -> {
            sb.append("Student: ").append(student.getName()).append("\nSubjects:\n");
            subjects.forEach((subject, grade) ->
                    sb.append("\t").append(subject.getName()).append(": ").append(grade).append("\n"));
            sb.append("\n");
        });
        System.out.print(sb.toString());
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        List<Student> studentList = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());

        for (Student student : students) {
            studentList.add(student);
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, DEFAULT_GRADE);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).putIfAbsent(subject, DEFAULT_GRADE);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
        }
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).remove(subject);
        }
    }

    public void printAllSubjectsAndStudents() {
        if (subjectStudents.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        subjectStudents.forEach((subject, students) -> {
            sb.append("Subject: ").append(subject.getName()).append("\nStudents:\n");
            students.forEach(student -> sb.append("\t").append(student.getName()).append("\n"));
            sb.append("\n");
        });
        System.out.print(sb);
    }

    public Map<Student, Map<Subject, Integer>> getSubjectsAndGradesByStudent() {
        return Collections.unmodifiableMap(studentSubjects);
    }

    public Map<Subject, List<Student>> getStudentsBySubject() {
        return Collections.unmodifiableMap(subjectStudents);
    }
}
