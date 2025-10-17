package bjs285940;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjectAndGrade(Student student, Map<Subject, Integer> grades) {
        studentSubjects.putIfAbsent(student, grades);

        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);

        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades == null) {
            return;
        }
        for (Subject subject : grades.keySet()) {
            List<Student> students = subjectStudents.get(subject);
            if (students != null) {
                students.remove(student);
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("Subject: " + subject.getName());
            for (Student student : entry.getValue()) {
                System.out.println("Student: " + student.getName());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }
}
