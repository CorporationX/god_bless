package school.faang.university.student.management;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        if (studentSubjects.containsKey(student)) {
            log.warn("Студент {} уже существует", student);
            return;
        }
        studentSubjects.put(student, new HashMap<>(subjects));
        for (Subject subject : subjects.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }

        log.info("Студент {} и его предметы добавлены", student.getName());
    }

    public void addSubjectToStudent(Student student, Subject subject, int mark) {
        Optional<Student> foundStudent = findStudent(student);
        if (foundStudent.isEmpty()) {
            return;
        }

        studentSubjects.get(student).put(subject, mark);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);

        log.info("Предмет {} добавлен студенту {}", subject.getName(), student.getName());
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

        log.info("Студент {} удален", student.getName());
    }

    public void printAllStudentsWithMarks() {
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
            log.warn("Предмет {} уже существует", subject.getName());
            return;
        }

        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        }

        log.info("Предмет {} и студенты добавлены", subject.getName());
    }

    public void addStudentToSubject(Student student, Subject subject) {
        Optional<Subject> foundSubject = findSubject(subject);
        if (foundSubject.isEmpty()) {
            return;
        }

        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());

        log.info("Студент {} добавлен к предмету {}", student.getName(), subject.getName());
    }

    private Optional<Subject> findSubject(Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            log.warn("Предмет {} не найден", subject);
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
            log.info("Студент {} не изучает предмет {}", student.getName(), subject.getName());
            return;
        }

        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);

        log.info("Студент {} удален из предмета {}", student.getName(), subject.getName());
    }

    public void printAllSubjectsWithStudents() {
        if (subjectStudents.isEmpty()) {
            System.out.println("В базе нет предметов");
            return;
        }

        System.out.println("\nСписок предметов и студентов");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.printf("Предмет: %s\n", entry.getKey().getName());
            System.out.printf("  Студенты: %s\n", entry.getValue());
        }
    }
}
