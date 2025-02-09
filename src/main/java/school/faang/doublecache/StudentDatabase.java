package school.faang.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        if (student == null || grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Student or grades cannot be null or empty!");
        }

        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student or subject cannot be null!");
        }

        if (grade <= 1 || grade > 5) {
            throw new IllegalArgumentException("Grade must be between 2 and 5!");
        }

        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (student != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudentsWithGrades() {
        for (var entry : studentSubjects.entrySet()) {
            System.out.println("Student: " + entry.getKey().name());
            for (var subjectEntry : entry.getValue().entrySet()) {
                System.out.println("Subject: " + subjectEntry.getKey() + ", grade: " + subjectEntry.getValue());
            }
            System.out.println();
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student or subject cannot be null!");
        }

        List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());

        if (!students.contains(student)) {
            students.add(student);
        }

        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student or subject cannot be null!");
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
        for (var entry : subjectStudents.entrySet()) {
            System.out.println("Subject: " + entry.getKey().name());
            for (Student student : entry.getValue()) {
                System.out.println("Student: " + student.name());
            }
            System.out.println();
        }
    }
}
