package school.faang.task_45261;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentWithGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectWithStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        if (student == null || grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }

        studentWithGrades.put(student, grades);

        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            subjectWithStudents.computeIfAbsent(entry.getKey(), key -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null || students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }

        subjectWithStudents.computeIfAbsent(subject, key -> new ArrayList<>()).addAll(students);

        for (Student student : students) {
            studentWithGrades.computeIfAbsent(student, key -> new HashMap<>()).put(subject, null);
        }
    }

    public void addSubjectForStudent(Subject subject, Student student, int grade) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }
        if (!studentWithGrades.containsKey(student)) {
            throw new IllegalArgumentException("Студент не найден!");
        }

        studentWithGrades.get(student).put(subject, grade);
        subjectWithStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public void addStudentForSubject(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }
        if (!subjectWithStudents.containsKey(subject)) {
            throw new IllegalArgumentException("Предмет не найден!");
        }

        subjectWithStudents.get(subject).add(student);
        studentWithGrades.computeIfAbsent(student, key -> new HashMap<>()).put(subject, null);
    }

    public void deleteStudentWithSubjects(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }

        if (!studentWithGrades.containsKey(student)) {
            throw new IllegalArgumentException("Студент не найден!");
        }

        var subjectsWithGrades = studentWithGrades.remove(student);

        for (Subject subject : subjectsWithGrades.keySet()) {
            var students = subjectWithStudents.get(subject);
            if (students != null) {
                students.remove(student);
                if (students.isEmpty()) {
                    subjectWithStudents.remove(subject);
                }
            }
        }
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }

        if (!subjectWithStudents.containsKey(subject)) {
            throw new IllegalArgumentException("Предмет не найден!");
        }

        subjectWithStudents.get(subject).remove(student);

        var subjectsWithGrades = studentWithGrades.get(student);

        if (subjectsWithGrades != null) {
            subjectsWithGrades.remove(subject);
            if (subjectsWithGrades.isEmpty()) {
                studentWithGrades.remove(student);
            }
        }
    }

    public void printAllStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentWithGrades.entrySet()) {
            var subjectsWithGrades = entry.getValue();
            System.out.println("Студент: " + entry.getKey());
            for (Map.Entry<Subject, Integer> subjectWithGrade : subjectsWithGrades.entrySet()) {
                var subject = subjectWithGrade.getKey();
                var grade = subjectWithGrade.getValue();
                System.out.println(" Предмет: " + subject.getName() + " Оценка: " + grade);
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectWithStudents.entrySet()) {
            var subject = entry.getKey();
            System.out.println("Предмет: " + subject.getName());
            for (Student student : entry.getValue()) {
                System.out.println(" Студент: " + student.getName());
            }
        }
    }
}
