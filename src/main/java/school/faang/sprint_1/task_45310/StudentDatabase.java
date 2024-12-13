package school.faang.sprint_1.task_45310;

import java.util.*;

public class StudentDatabase {

    final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        grades.forEach((subject, grade) -> addStudentToSubject(subject, student));
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        addStudentToSubject(subject, student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentGrades.remove(student);
        if (grades != null) {
            grades.keySet().forEach(subject -> removeStudentFromSubject(subject, student));
        }
    }

    public void printAllStudents() {
        studentGrades.forEach((student, grades) -> {
            System.out.println(student + " Grades: " + grades);
        });
    }

    public void addSubject(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        students.forEach(student -> addStudentToSubject(subject, student));
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
        subjectStudents.forEach((subject, students) -> {
            System.out.println(subject + " Students: " + students);
        });
    }
}
