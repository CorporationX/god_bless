package school.faang.task56944.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).put(subject, grade);
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        } else {
            throw new IllegalArgumentException("Студент не найден");
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> removedSubjects = studentSubjects.remove(student);
        if (removedSubjects != null) {
            for (Subject subject : removedSubjects.keySet()) {
                subjectStudents.get(subject).remove(student);
            }
        }
    }

    public void addSubject(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        subjectStudents.getOrDefault(subject, new ArrayList<>()).remove(student);
        studentSubjects.getOrDefault(student, new HashMap<>()).remove(subject);
    }

    public void printAllStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println("Студент: " + entry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                System.out.println("  Предмет: " + subjectEntry.getKey().getName() + ", Оценка: " + subjectEntry.getValue());
            }
        }
    }

    public void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println("  Студент: " + student.getName());
            }
        }
    }
}