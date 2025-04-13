package school.faang.double_cache;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {

    Map<Student, Map<Subject, Integer>> studentSubjects;
    Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        this.studentSubjects = new HashMap<>();
        this.subjectStudents = new HashMap<>();
    }

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> subjectsWithGrades) {
        if (student == null || subjectsWithGrades == null) {
            throw new IllegalArgumentException("Student and subjects not be a null");
        }

        studentSubjects.put(student, new HashMap<>(subjectsWithGrades));

        for (Subject subject : subjectsWithGrades.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        if (student == null || subject == null || grade == null) {
            throw new IllegalArgumentException("Student, subject and grade cannot be null");
        }

        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Student not found in database");
        }
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Student not found in database");
        }
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        for (Subject subject : subjects.keySet()) {
            List<Student> studentsForSubject = subjectStudents.get(subject);
            if (studentsForSubject != null) {
                studentsForSubject.remove(student);

                if (studentsForSubject.isEmpty()) {
                    subjectStudents.remove(subject);
                }
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("Предмет: " + subject.getName());
            for (Student student : entry.getValue()) {
                System.out.println("   Студент: " + student.getName());
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

    public String getAllStudentsWithGrades() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Student, Map<Subject, Integer>> studentEntry : studentSubjects.entrySet()) {
            Student student = studentEntry.getKey();
            sb.append("Student: ").append(student.getName()).append(" (ID: ").append(student.getId()).append(")\n");

            Map<Subject, Integer> subjects = studentEntry.getValue();
            if (subjects.isEmpty()) {
                sb.append("  No subjects\n");
            } else {
                for (Map.Entry<Subject, Integer> subjectEntry : subjects.entrySet()) {
                    sb.append("  Subject: ").append(subjectEntry.getKey().getName())
                            .append(" - Grade: ").append(subjectEntry.getValue()).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}