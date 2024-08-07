package faang.school.godbless.BJS2_20000;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Main {
    private Map<Student, Map<Subject, Integer>> studentWithSubjects = new HashMap<>();
    private Map<Subject, List<Student>> allSubjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        studentWithSubjects.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            allSubjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentWithSubjects.get(student).put(subject, grade);
        allSubjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> subjects = studentWithSubjects.remove(student);
        for (Subject subject : subjects.keySet()) {
            List<Student> students = allSubjectStudents.get(subject);
            students.remove(student);
            if (students.isEmpty()) {
                allSubjectStudents.remove(subject);
            }
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentWithSubjects.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> subjects = entry.getValue();
            System.out.println("Студент: " + student.getName());
            for (Map.Entry<Subject, Integer> subjectEntry : subjects.entrySet()) {
                System.out.println("Предмет: " + subjectEntry.getKey().getName() + ", Оценка: " + subjectEntry.getValue());
            }
        }
    }

    public void addSubject(Subject subject, List<Student> students) {
        allSubjectStudents.put(subject, students);
        for (Student student : studentWithSubjects.keySet()) {
            studentWithSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public void addStudentAtSubject(Student student, Subject subject) {
        allSubjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentWithSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        if (allSubjectStudents.containsKey(subject)) {
            List<Student> students = allSubjectStudents.get(subject);
            students.remove(student);
        }
        if (studentWithSubjects.containsKey(student)) {
            Map<Subject, Integer> subjects = studentWithSubjects.get(student);
            subjects.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : allSubjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();
            System.out.println("Предмет: " + subject.getName());
            for (Student student : students) {
                System.out.println("Студент: " + student.getName());
            }
        }
    }
}