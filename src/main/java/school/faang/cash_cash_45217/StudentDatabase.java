package school.faang.cash_cash_45217;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    HashMap<Student, Map<Subject, Integer>> studentGrades;
    HashMap<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        this.subjectStudents = new HashMap<>();
        this.studentGrades = new HashMap<>();
    }

    public void addStudent(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            addStudentToSubject(entry.getKey(), student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        addStudentToSubject(subject, student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentGrades.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                removeStudentFromSubject(subject, student);
            }
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + " grades: " + entry.getValue());
        }
    }

    public void addSubject(Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }

    public void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey() + " students: " + entry.getValue());
        }
    }
}


