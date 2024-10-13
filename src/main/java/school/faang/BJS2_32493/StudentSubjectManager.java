package school.faang.BJS2_32493;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSubjectManager {
    private Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student) {
        studentGrades.putIfAbsent(student, new HashMap<>());
    }

    public void addNewSubject(Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade){
        studentGrades.putIfAbsent(student, new HashMap<>());
        studentGrades.get(student).put(subject, grade);

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudent(Student student) {
        studentGrades.remove(student);
        for (List<Student> students : subjectStudents.values()) {
            students.remove(student);
        }
    }

    public void printStudentGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + "Grades: " + entry.getValue());
        }
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }

    public void printSubjectAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey() + " Students: " + entry.getValue());
        }
    }
}
