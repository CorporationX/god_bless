package school.faang.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).putAll(grades);
        } else {
            studentSubjects.put(student, new HashMap<>(grades));
        }

        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            Subject subject = entry.getKey();
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            if (!subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).add(student);
            }
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        if (!studentSubjects.containsKey(student)) {
            studentSubjects.put(student, new HashMap<>());
        }
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudentWithSubjects(Student student) {
        studentSubjects.remove(student);
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            for (Student studentToRemove : entry.getValue()) {
                if (studentToRemove.equals(student)) {
                    subjectStudents.get(entry.getKey()).remove(student);
                    break;
                }
            }
        }
    }

    public void printAllStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, students);
        for (Student student : students) {
            if (!subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).add(student);
            }
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).putIfAbsent(subject, null);
        }
    }

    public void addStudentForSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
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

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
