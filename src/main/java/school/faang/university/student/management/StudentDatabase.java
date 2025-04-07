package school.faang.university.student.management;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        if (studentSubjects.containsKey(student)) {
            log.warn(String.format("Студент %s уже существует", student));
            return;
        }
        studentSubjects.put(student, new HashMap<>(subjects));
        for (Subject subject : subjects.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }

        log.info(String.format("Студент %s и его предметы добавлены", student.getName()));
    }

    public void addSubjectToStudent(Student student, Subject subject, int mark) {
        Optional<Student> foundStudent = findStudent(student);
        if (foundStudent.isEmpty()) {
            return;
        }

        studentSubjects.get(student).put(subject, mark);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);

        log.info(String.format("Предмет %s добавлен студенту %s", subject.getName(), student.getName()));
    }

    private Optional<Student> findStudent(Student student) {
        if (!studentSubjects.containsKey(student)) {
            log.warn(String.format("Студент %s не найден", student));
            return Optional.empty();
        }
        return Optional.of(student);
    }

    public void removeStudent(Student student) {
        Optional<Student> foundStudent = findStudent(student);
        if (foundStudent.isEmpty()) {
            return;
        }

        for (Subject subject : studentSubjects.get(student).keySet()) {
            subjectStudents.get(subject).remove(student);
        }
        studentSubjects.remove(student);

        log.info(String.format("Студент %s удален", student.getName()));
    }

    public void printAllStudentsWithGrades() {
        if (studentSubjects.isEmpty()) {
            System.out.println("В базе нет студентов");
            return;
        }

        System.out.println("\nСписок студентов и их оценок");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.printf("Студент: %s\n", entry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                System.out.printf("   %s: %s\n", subjectEntry.getKey().getName(), subjectEntry.getValue());
            }
            System.out.println();
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subjectStudents.containsKey(subject)) {
            log.warn(String.format("Предмет %s уже существует", subject.getName()));
            return;
        }

        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        }

        log.info(String.format("Предмет %s и студенты добавлены", subject.getName()));
    }

    public void addStudentToSubject(Student student, Subject subject) {
        Optional<Subject> foundSubject = findSubject(subject);
        if (foundSubject.isEmpty()) {
            return;
        }

        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());

        log.info(String.format("Студент %s добавлен к предмету %s", student.getName(), subject.getName()));
    }

    private Optional<Subject> findSubject(Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            log.warn(String.format("Предмет %s не найден", subject));
            return Optional.empty();
        }
        return Optional.of(subject);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        Optional<Subject> foundSubject = findSubject(subject);
        if (foundSubject.isEmpty()) {
            return;
        }

        if (!subjectStudents.get(subject).contains(student)) {
            log.info(String.format("Студент %s не изучает предмет %s", student.getName(), subject.getName()));
            return;
        }

        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);

        log.info(String.format("Студент %s удален из предмета %s", student.getName(), subject.getName()));
    }

    public void printAllSubjectsWithStudents() {
        if (subjectStudents.isEmpty()) {
            System.out.println("В базе нет предметов");
            return;
        }

        System.out.println("\nСписок предметов и студентов");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.printf("Предмет: %s", entry.getKey().getName());
            System.out.printf("  Студенты: %s", entry.getValue());
        }
    }
}
