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
        subjects.forEach((subject, grade) ->
                subjectStudents.computeIfAbsent(subject, subject1 -> new ArrayList<>()).add(student));
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, student1 -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, subject1 -> new ArrayList<>()).add(student);
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
        studentSubjects.forEach((student, grades) -> {
            log.info("Студент: {}", student.name());
            grades.forEach((subject, grade) -> log.info("  {}: {}", subject.name(), grade));
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students, int defaultGrade) {
        students.forEach(student ->
                studentSubjects.computeIfAbsent(student, student1 -> new HashMap<>()).put(subject, defaultGrade));
        subjectStudents.put(subject, new ArrayList<>(students));
    }

    public void addStudentToSubject(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, student1 -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, subject1 -> new ArrayList<>()).add(student);
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
        subjectStudents.forEach((subject, students) -> {
            System.out.println("Предмет: " + subject.name());
            students.forEach(student -> System.out.println("  " + student.name()));
        });
    }
}