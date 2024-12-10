package school.faang.task_45285;

import java.util.*;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        grades.forEach((subject, grade) ->
                subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student));
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.put(subject, grade);
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentGrades.remove(student);
        if (grades != null) {
            grades.keySet().forEach(subject -> {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                    if (students.isEmpty()) {
                        subjectStudents.remove(subject);
                    }
                }
            });
            System.out.println("Student removed: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void printAllStudentsAndGrades() {
        studentGrades.forEach((student, grades) -> {
            System.out.println("Student: " + student.getName());
            grades.forEach((subject, grade) ->
                    System.out.println("  Subject: " + subject.getName() + ", Grade: " + grade));
        });
    }

    public void addSubject(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        students.forEach(student ->
                studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0));
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }

        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsAndStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println("Subject: " + subject.getName());
            students.forEach(student ->
                    System.out.println("  Student: " + student.getName()));
        });
    }
}
