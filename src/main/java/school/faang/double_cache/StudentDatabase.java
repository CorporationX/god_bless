package school.faang.double_cache;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(String nameStudent, String nameSubject, int grade) {
        Student student = new Student(nameStudent);
        Subject subject = new Subject(nameSubject);
        studentSubjects.computeIfAbsent(student, key -> new HashMap<>())
                .putIfAbsent(subject, grade);
        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>())
                .add(student);
    }

    public void addSubject(Student student, String nameSubject, int grade) throws IllegalArgumentException {
        if (!subjectStudents.containsKey(new Subject(nameSubject))) {
            throw new IllegalArgumentException("Такого предмета не существует");
        } else if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Такого студента не существует");
        } else {
            Subject subject = new Subject(nameSubject);
            studentSubjects.get(student).put(subject, grade);
            subjectStudents.get(subject).add(student);
        }
    }

    public void deleteStudent(Student student) {
        for (Subject subject : studentSubjects.computeIfAbsent(student, key -> new HashMap<>())
                .keySet()) {
            subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>())
                    .remove(student);
        }
        studentSubjects.remove(student);
    }

    public void printAllStudentSubject() {
        for (Student student : studentSubjects.keySet()) {
            System.out.println("Student: " + student.name() + " " + studentSubjects.get(student));
        }
        System.out.println("\n*****************************************************************\n");
    }

    public void assignStudentsToSubject(String nameSubject, List<Student> studentList) {
        Subject subject = new Subject(nameSubject);
        subjectStudents.put(subject, studentList);
        for (Student student : studentList) {
            studentSubjects.computeIfAbsent(student, key -> new HashMap<>())
                    .putIfAbsent(subject, null);
        }
    }

    public void addStudentSubject(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student, key -> new HashMap<>())
                .putIfAbsent(subject, null);
        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>())
                .add(student);
    }

    public void deleteSubjectStudent(Subject subject, Student student) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectStudent() {
        for (Subject subject : subjectStudents.keySet()) {
            System.out.println("Subject: " + subject.name() + " " + subjectStudents.get(subject));
        }
        System.out.println("\n*****************************************************************\n");
    }
}
