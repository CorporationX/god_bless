package school.faang.cachecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    // First HashMap: Student -> Map of Subjects and Grades
    private Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();

    // Second HashMap: Subject -> List of Students
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    // Method to add a new student with subjects and grades
    public void addStudentWithGrades(Student student, Map<Subject, Integer> subjectsAndGrades) {
        studentGrades.put(student, subjectsAndGrades);
        for (Subject subject : subjectsAndGrades.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    // Method to add a new subject and grade for an existing student
    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    // Method to remove a student and all their subjects and grades
    public void removeStudent(Student student) {
        Map<Subject, Integer> subjects = studentGrades.remove(student);
        if (subjects != null) {
            for (Subject subject : subjects.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    // Method to print all students and their subjects with grades
    public void printAllStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            Student student = entry.getKey();
            System.out.println("Student: " + student.getName() + " (ID: " + student.getId() + ")");
            for (Map.Entry<Subject, Integer> gradesEntry : entry.getValue().entrySet()) {
                Subject subject = gradesEntry.getKey();
                int grade = gradesEntry.getValue();
                System.out.println(" - " + subject.getName() + ": " + grade);
            }
        }
    }

    // Method to add a new subject and a list of students studying it
    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0); // Default grade
        }
    }

    // Method to add a student to an existing subject
    public void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0); // Default grade
    }

    // Method to remove a student from a subject
    public void removeStudentFromSubject(Subject subject, Student student) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> subjects = studentGrades.get(student);
        if (subjects != null) {
            subjects.remove(subject);
        }
    }

    // Method to print all subjects and the students studying them
    public void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("Subject: " + subject.getName() + " (ID: " + subject.getId() + ")");
            for (Student student : entry.getValue()) {
                System.out.println(" - " + student.getName() + " (ID: " + student.getId() + ")");
            }
        }
    }
}