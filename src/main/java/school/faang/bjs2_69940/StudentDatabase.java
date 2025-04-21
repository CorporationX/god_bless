package school.faang.bjs2_69940;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.put(student, new HashMap<>(subjects));
        subjects.forEach((key, value) ->
                subjectStudents.computeIfAbsent(key, subject -> new ArrayList<>()).add(student));
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> removedSubjects = studentSubjects.remove(student);
        if (removedSubjects == null) {
            log.warn("У пользователя {} отсутствуют предметы.", student.name());
            return;
        }

        for (Subject subject : removedSubjects.keySet()) {
            List<Student> students = subjectStudents.get(subject);
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
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            log.info("Студент: {}", entry.getKey().name());
            entry.getValue().forEach((key, value) -> log.info("  {}: {}", key.name(), value));
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students, int defaultGrade) {
        students.forEach(student ->
                studentSubjects.computeIfAbsent(student, student1 -> new HashMap<>()).put(subject, defaultGrade));
        subjectStudents.put(subject, new ArrayList<>(students));
    }

    public void addStudentToSubject(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects == null) {
            log.warn("У пользователя {} отсутствуют предметы.", student.name());
            return;
        }

        subjects.remove(subject);
        var students = subjectStudents.get(subject);
        if (students == null) {
            log.warn("В коллекции не найдены пользователи с предметом {}", subject.name());
            return;
        }

        students.remove(student);
        if (students.isEmpty()) {
            subjectStudents.remove(subject);
        }
    }

    public void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().name());
            entry.getValue().forEach(student -> System.out.println("  " + student.name()));
        }
    }
}