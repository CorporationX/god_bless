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

    public void addSubject(Student student, String nameSubject, int grade) throws IllegalAccessException {
        Subject subject = new Subject(nameSubject);
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalAccessException("Такого предмета не существует");
        } else if (!studentSubjects.containsKey(student)) {
            throw new IllegalAccessException("Такого студента не существует");
        } else {
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
        studentSubjects.computeIfAbsent(student, key -> new HashMap<>())
                .remove(subject);
        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>())
                .remove(student);
    }

    public void printAllSubjectStudent() {
        for (Subject subject : subjectStudents.keySet().toArray(new Subject[0])) {
            System.out.println("Subject: " + subject.name() + " " + subjectStudents.get(subject));
        }
        System.out.println("\n*****************************************************************\n");
    }
}
