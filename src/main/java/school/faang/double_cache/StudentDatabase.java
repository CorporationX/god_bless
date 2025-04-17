package school.faang.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            Subject subject = entry.getKey();
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, l -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentWithSubjects(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
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
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).putIfAbsent(subject, null);
        }
    }

    public void addStudentForSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).putIfAbsent(subject, null);
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