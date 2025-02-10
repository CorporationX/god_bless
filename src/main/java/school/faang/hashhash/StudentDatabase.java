package school.faang.hashhash;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private static final int MIN_GRADE = 1;
    private static final int MAX_GRADE = 5;
    private static final int DEFAULT_GRADE = 0;
    private final Map<Student, Map<Subject, Integer>> studentSubject = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubject(Student student, @NonNull Map<Subject, Integer> subjects) {
        validationStudent(student);
        Set<Subject> subjectsKey = subjects.keySet();
        for (Subject subject : subjectsKey) {
            validationSubject(subject);
        }
        if (studentSubject.containsKey(student)) {
            throw new IllegalArgumentException("Student is already in the database");
        }
        studentSubject.put(student, subjects);
        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            subjectStudents.putIfAbsent(entry.getKey(), new ArrayList<>());
            subjectStudents.get(entry.getKey()).add(student);
        }
    }

    public void addSubjectForStudent(Subject subject, Student student, int grade) {
        validationStudent(student);
        validationSubject(subject);
        validationGrade(grade);
        if (!studentSubject.containsKey(student)) {
            throw new IllegalArgumentException(String.format("Student %s has not been added", student.getName()));
        }
        Set<Subject> keyStudentSubject = studentSubject.get(student).keySet();
        if (keyStudentSubject.contains(subject)) {
            throw new IllegalArgumentException("Subject is already in the database");
        }

        Map<Subject, Integer> subjects = studentSubject.get(student);
        subjects.put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        validationStudent(student);
        if (!studentSubject.containsKey(student)) {
            throw new IllegalArgumentException(String.format("Student %s has not been added", student.getName()));
        }
        Set<Subject> subjects = studentSubject.get(student).keySet();
        studentSubject.remove(student);
        for (Subject subject : subjects) {
            List<Student> students = subjectStudents.get(subject);
            students.remove(student);
        }
    }

    public void printAllStudentWithSubject() {
        StringBuilder allStudents = new StringBuilder();
        for (var subjects : studentSubject.entrySet()) {
            String name = subjects.getKey().getName();
            allStudents.append(name).append("\n");
            for (var grades : subjects.getValue().entrySet()) {
                String subject = grades.getKey().getName();
                Integer grade = grades.getValue();
                allStudents.append(subject).append(":").append(grade).append("\n");
            }
            allStudents.append("\n");
        }
        System.out.println(allStudents);
    }

    public void addSubject(@NonNull List<Student> students, Subject subject) {
        for (Student student : students) {
            validationStudent(student);
        }
        validationSubject(subject);
        if (subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException(String.format("Subject has alredy %s   added", subject.getName()));
        }
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubject.putIfAbsent(student, new HashMap<>());
            Map<Subject, Integer> subjects = studentSubject.get(student);
            subjects.put(subject, DEFAULT_GRADE);
        }
    }

    public void addStudentForSubject(Student newStudent, Subject subject) {
        validationStudent(newStudent);
        validationSubject(subject);
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException(String.format("Subject %s has not been added", subject.getName()));
        }
        studentSubject.putIfAbsent(newStudent, new HashMap<>());
        Map<Subject, Integer> subjects = studentSubject.get(newStudent);
        subjects.put(subject, DEFAULT_GRADE);
        List<Student> students = subjectStudents.get(subject);
        students.add(newStudent);
    }

    public void removeStudentForSubject(Student student, Subject subject) {
        validationStudent(student);
        validationSubject(subject);
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException(String.format("Subject %s has not been added", subject.getName()));
        }
        Set<Subject> keyStudentSubject = studentSubject.get(student).keySet();
        if (!keyStudentSubject.contains(subject)) {
            throw new IllegalArgumentException(String.format("Student %s has not been added", student.getName()));
        }
        Map<Subject, Integer> subjects = studentSubject.get(student);
        subjects.remove(subject);
        List<Student> students = subjectStudents.get(subject);
        students.remove(student);
    }

    public void printAllSubjectWithStudents() {
        StringBuilder allSubjects = new StringBuilder();
        for (Map.Entry<Subject, List<Student>> subjects : subjectStudents.entrySet()) {
            String subjectName = subjects.getKey().getName();
            allSubjects.append(subjectName).append(":").append("\n");
            List<Student> students = subjects.getValue();
            for (Student student : students) {
                String studentName = student.getName();
                allSubjects.append(studentName).append("\n");
            }
            allSubjects.append("\n");
        }
        System.out.println(allSubjects);
    }


    private void validationStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("student is null");
        }
    }

    private void validationSubject(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("subject is null");
        }
    }

    private void validationGrade(int grade) {
        if (grade < MIN_GRADE || grade > MAX_GRADE) {
            throw new IllegalArgumentException("grade must be between " + MIN_GRADE + " and " + MAX_GRADE);
        }
    }
}
