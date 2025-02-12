package school.faang.task_57213;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(@NonNull Student student, @NonNull Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.put(subject, grade);
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = this.studentGrades.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> students = this.subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            Student student = entry.getKey();
            System.out.println("Студент: " + student.name());
            for (Map.Entry<Subject, Integer> gradeEntry : entry.getValue().entrySet()) {
                System.out.println("   Предмет: " + gradeEntry.getKey().name() + ", Оценка: "
                        + gradeEntry.getValue());
            }
        }
    }


    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).putIfAbsent(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentGrades.putIfAbsent(student, new HashMap<>());
        studentGrades.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("Предмет: " + subject.name());
            for (Student student : entry.getValue()) {
                System.out.println("   Студент: " + student.name());
            }
        }
    }
}
