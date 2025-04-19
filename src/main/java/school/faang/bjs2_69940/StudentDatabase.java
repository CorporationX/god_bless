package school.faang.bjs2_69940;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.put(student, new HashMap<>(subjects));
        for (var entry : subjects.entrySet()) {
            subjectStudents.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        var removedSubjects = studentSubjects.remove(student);
        if (removedSubjects == null) {
            log.warn("У пользователя {} отсутствуют предметы.", student.getName());
            return;
        }

        for (var subject : removedSubjects.keySet()) {
            var students = subjectStudents.get(subject);
            if (students == null) {
                continue;
            }

            students.remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
    }

    public void printAllStudents() {
        for (var entry : studentSubjects.entrySet()) {
            System.out.println("Студент: " + entry.getKey().getName());
            for (var subEntry : entry.getValue().entrySet()) {
                System.out.println("  " + subEntry.getKey().getName() + ": " + subEntry.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students, int defaultGrade) {
        for (var student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, defaultGrade);
        }

        subjectStudents.put(subject, new ArrayList<>(students));
    }

    public void addStudentToSubject(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        var subjects = studentSubjects.get(student);
        if (subjects == null) {
            log.warn("У пользователя {} отсутствуют предметы.", student.getName());
            return;
        }

        subjects.remove(subject);
        var students = subjectStudents.get(subject);
        if (students == null) {
            log.warn("В коллекции не найдены пользователи с предметом {}", subject.getName());
            return;
        }

        students.remove(student);
        if (students.isEmpty()) {
            subjectStudents.remove(subject);
        }
    }

    public void printAllSubjects() {
        for (var entry : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().getName());
            for (var student : entry.getValue()) {
                System.out.println("  " + student.getName());
            }
        }
    }
}