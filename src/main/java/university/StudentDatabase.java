package university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    private void validateInput(Object value, String errorMessage) {
        if (value == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (value instanceof Integer intValue && intValue < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void addStudent(Student student, Map<Subject, Integer> subjectsAndGrades) {
        validateInput(student, "Student cannot be null");
        validateInput(subjectsAndGrades, "Subjects and grades cannot be null");

        studentSubjects.put(student, subjectsAndGrades);

        for (Subject subject : subjectsAndGrades.keySet()) {
            subjectStudents.computeIfAbsent(subject, subjectKey -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        validateInput(student, "Student cannot be null");
        validateInput(subject, "Subject cannot be null");
        validateInput(grade, "Grade cannot be negative");

        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).put(subject, grade);

        List<Student> students = subjectStudents.computeIfAbsent(subject, subjectKey -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void deleteStudent(Student student) {
        Map<Subject, Integer> subjectsAndGrades = studentSubjects.remove(student);
        if (subjectsAndGrades != null) {
            for (Subject subject : subjectsAndGrades.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }

                if (students.isEmpty()) {
                    subjectStudents.remove(subject);
                }
            }
        }
    }

    public void printAllStudentsAndSubjects() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.println("Student: " + student);
            subjects.forEach((subject, grade) -> System.out.println("Subject: " + subject +
                    ", Grade: " + (grade != null ? grade : "No grade")));
        });
    }

    public void addSubject(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);

        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.computeIfAbsent(subject, subjectKey -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }

        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }

        Map<Subject, Integer> subjectsAndGrades = studentSubjects.get(student);
        if (subjectsAndGrades != null) {
            subjectsAndGrades.remove(subject);
        }
    }

    public void printAllSubjectsAndStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println("Subject: " +
                    subject);
            students.forEach(student -> System.out.println("Student: " + student));
        });
    }
}
