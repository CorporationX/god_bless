package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubject = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        validateStudent(student);
        studentSubject.put(student, grades);
        for (var entry : grades.entrySet()) {
            subjectStudents.putIfAbsent(entry.getKey(), new ArrayList<>());
            subjectStudents.get(entry.getKey()).add(student);
        }
        System.out.printf("Student %s with subjects %s added\n", student.getName(), grades);
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        validateStudent(student);
        studentSubject.putIfAbsent(student, new HashMap<>());
        studentSubject.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
        System.out.printf("Student %s with subject %s and grade %d added\n",
                student.getName(), subject.getName(), grade);
    }

    public void removeStudentWithSubjects(Student student) {
        if (!studentSubject.containsKey(student)) {
            throw new StudentNotFoundException("No student " + student.getName() + " in DB");
        }
        Map<Subject, Integer> subjects = studentSubject.get(student);
        studentSubject.remove(student);
        for (var entry : subjects.entrySet()) {
            subjectStudents.get(entry.getKey()).remove(student);
            if (subjectStudents.get(entry.getKey()).isEmpty()) {
                subjectStudents.remove(entry.getKey());
            }
        }
        System.out.printf("Student %s was removed\n", student.getName());
    }

    public void printAllStudentsAndSubjects() {
        for (var entry : studentSubject.entrySet()) {
            System.out.printf("Student %s:\n", entry.getKey().getName());
            for (var subject : entry.getValue().entrySet()) {
                System.out.printf("Subject %s, grade %s\n", subject.getKey().getName(), subject.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        for (Student student : students) {
            studentSubject.putIfAbsent(student, new HashMap<>());
            studentSubject.get(student).put(subject, null);
            subjectStudents.get(subject).add(student);
            System.out.printf("Student %s with subject %s added\n",
                    student.getName(), subject.getName());
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
        studentSubject.putIfAbsent(student, new HashMap<>());
        studentSubject.get(student).put(subject, null);
        System.out.printf("Student %s and subject %s added\n", student.getName(), subject.getName());
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            throw new SubjectNotFoundException("No subject " + subject.getName() + " in DB");
        } else if (!studentSubject.containsKey(student)) {
            throw new StudentNotFoundException("No student " + student.getName() + " in DB");
        }
        subjectStudents.get(subject).remove(student);
        studentSubject.get(student).remove(subject);
        if (subjectStudents.get(subject).isEmpty()) {
            subjectStudents.remove(subject);
        }
        if (studentSubject.get(student).isEmpty()) {
            studentSubject.remove(student);
        }
        System.out.printf("Removing a student %s from subject %s\n", student.getName(), subject.getName());
    }

    public void printAllSubjectsWithStudents() {
        for (var entry : subjectStudents.entrySet()) {
            System.out.printf("Subject %s:\n", entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
            System.out.println();
        }
    }

    private void validateStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can't be null");
        }
    }
}