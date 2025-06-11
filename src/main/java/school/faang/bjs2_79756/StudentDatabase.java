package school.faang.bjs2_79756;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudentWithGrade(Student student, Subject subject, int grade) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("студент не найден");
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        grades.put(subject, grade);

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudentWithSubject(Student student) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("студент не найден");
        }
        studentSubjects.remove(student);
        for (List<Student> students : subjectStudents.values()) {
            students.remove(student);
        }
    }

    public void printStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> students : studentSubjects.entrySet()) {
            System.out.printf("student: %s%n", students.getKey());
            Map<Subject, Integer> subjects = students.getValue();
            for (Map.Entry<Subject, Integer> subject : subjects.entrySet()) {
                System.out.printf("     subject: %s   grade: %s%n", subject.getKey(), subject.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentForSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printSubjectsWithStudents() {
        for (var entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.printf("subject: %s%n", subject);
            for (Student student : studentSubjects.keySet()) {
                System.out.printf("     student: %s%n", student);
            }
        }
    }
}