package school.faang.task_45243;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades;
    private final Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase(HashMap<Student, Map<Subject, Integer>> studentGrades,
                           HashMap<Subject, List<Student>> subjectStudents) {
        this.studentGrades = new HashMap<>(studentGrades);
        this.subjectStudents = new HashMap<>(subjectStudents);
    }

    public StudentDatabase() {
        this(new HashMap<>(), new HashMap<>());
    }

    public void addStudentWithGrades(@NonNull Student student, @NonNull Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        grades.forEach((subject, grade) ->
                subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student));
    }

    public void addSubjectForStudent(@NonNull Student student, @NonNull Subject subject, int grade) {
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.put(subject, grade);
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void removeStudent(@NonNull Student student) {
        Map<Subject, Integer> grades = studentGrades.remove(student);
        if (grades != null) {
            grades.forEach((subject, grade) -> {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            });
        }
    }

    public void printAllStudentsWithGrades() {
        System.out.println("method printAllStudentsWithGrades");
        studentGrades.forEach((student, grades) -> {
            System.out.printf("%s:%n", student);
            grades.forEach((subject, grade) ->
                    System.out.printf("\t- %s: %d%n", subject, grade));
        });
    }


    public void addSubjectWithStudents(@NonNull Subject subject, @NonNull List<Student> students) {
        if (subjectStudents.containsKey(subject)) {
            System.out.printf("Such a subject already exists: %s%n", subject);
        } else {
            subjectStudents.put(subject, new ArrayList<>(students));
            students.forEach(student ->
                    studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, -1));
        }
    }

    public void addStudentToSubject(@NonNull Student student, @NonNull Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, -1);
    }

    public void removeStudentFromSubject(@NonNull Student student, @NonNull Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        System.out.println("method printAllSubjectsWithStudents");
        subjectStudents.forEach((subject, students) -> {
            System.out.printf("%n%s:%n", subject);
            students.forEach(student -> {
                int grade = studentGrades.get(student).get(subject);
                System.out.printf("\t%s - %d%n", student, grade);
            });
        });
    }

}
