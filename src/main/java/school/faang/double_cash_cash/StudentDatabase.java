package school.faang.double_cash_cash;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    @Getter
    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    @Getter
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    void removeStudent(Student student) {
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

    void printAllStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            System.out.println("\nСтудент: " + student.getName());
            for (Map.Entry<Subject, Integer> entry1 : entry.getValue().entrySet()) {
                System.out.println("\tПредмет: " + entry1.getKey().getName()
                        + "\n\t- оценка: " + entry1.getValue());
            }
        }
        System.out.println();
    }

    void addSubjectWithStudent(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        for (Student student : students) {
            if (!subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).add(student);
            }
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).putIfAbsent(subject, null);
        }
    }

    void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("\nПредмет: " + subject.getName());
            for (Student student : entry.getValue()) {
                System.out.println("\tСтудент: " + student.getName());
            }
        }
        System.out.println();
    }
}