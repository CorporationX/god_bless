package school.faang.bjs2_85989;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@Slf4j
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjectsWithGrades) {

        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть null");
        }
        if (subjectsWithGrades == null) {
            throw new IllegalArgumentException("Список предметов не может быть null");
        }

        studentSubjects.put(student, new HashMap<>(subjectsWithGrades));

        for (Subject subject : subjectsWithGrades.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubject(Student student, Subject subject, int grade) {

        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Предмет не может быть null");
        }
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 1 до 5");
        }

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public boolean removeStudentAndSubjects(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть null");
        }

        if (!studentSubjects.containsKey(student)) {
            log.warn("Попытка удаления несуществующего студента: {}", student.getName());
            return false;
        }

        Map<Subject, Integer> studentSubjectsCopy = new HashMap<>(studentSubjects.get(student));

        studentSubjects.remove(student);
        log.info("Студент '{}' удален из основной мапы", student.getName());

        int removedCount = 0;
        for (Subject subject : studentSubjectsCopy.keySet()) {
            List<Student> studentsInSubject = subjectStudents.get(subject);

            if (studentsInSubject != null) {
                boolean removed = studentsInSubject.remove(student);

                if (removed) {
                    removedCount++;
                    log.debug("Студент '{}' удален из предмета '{}'", student.getName(), subject.getName());

                    if (studentsInSubject.isEmpty()) {
                        subjectStudents.remove(subject);
                        log.debug("Предмет '{}' удален (больше нет студентов)", subject.getName());
                    }
                }
            }
        }
        log.info("Студент '{}' удален из {} предметов", student.getName(), removedCount);
        return true;
    }

    public void printAllStudentsWithGrades() {
        if (studentSubjects.isEmpty()) {
            System.out.println("В базе нет студентов");
            return;
        }

        System.out.println("СПИСОК СТУДЕНТОВ И ОЦЕНОК");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> subjects = entry.getValue();

            System.out.println("\nСтудент: " + student.getName());
            System.out.println("Предметы и оценки:");

            for (Map.Entry<Subject, Integer> subjectEntry : subjects.entrySet()) {
                System.out.println("- " + subjectEntry.getKey().getName() + ": " + subjectEntry.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, Map<Student, Integer> studentsWithGrades) {
        if (subject == null) {
            throw new IllegalArgumentException("Предмет не может быть null");
        }
        if (studentsWithGrades == null || studentsWithGrades.isEmpty()) {
            throw new IllegalArgumentException("Список студентов не может быть пустым");
        }

        for (Map.Entry<Student, Integer> entry : studentsWithGrades.entrySet()) {
            Student student = entry.getKey();
            Integer grade = entry.getValue();

            studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                    .put(subject, grade);

            List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
            if (!students.contains(student)) {
                students.add(student);
            }
        }

        log.info("Предмет '{}' добавлен с {} студентами", subject.getName(), studentsWithGrades.size());
    }

    public void addStudentToSubject(Student student, Subject subject, int grade) {
        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Предмет не может быть null");
        }
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 1 до 5");
        }

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                .put(subject, grade);

        List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }

        log.info("Студент '{}' добавлен к предмету '{}' с оценкой {}",
                student.getName(), subject.getName(), grade);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Предмет не может быть null");
        }

        if (studentSubjects.containsKey(student)) {
            Map<Subject, Integer> subjects = studentSubjects.get(student);
            subjects.remove(subject);

            if (subjects.isEmpty()) {
                studentSubjects.remove(student);
            }
        }

        if (subjectStudents.containsKey(subject)) {
            List<Student> students = subjectStudents.get(subject);
            students.remove(student);

            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }

        log.info("Студент '{}' удален из предмета '{}'", student.getName(), subject.getName());
    }

    public void printAllSubjectsWithStudents() {
        if (subjectStudents.isEmpty()) {
            System.out.println("В базе нет предметов");
            return;
        }

        System.out.println("СПИСОК ПРЕДМЕТОВ И СТУДЕНТОВ");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("\nПредмет: " + subject.getName());
            System.out.println("Студенты:");

            for (Student student : students) {
                Integer grade = studentSubjects.get(student).get(subject);
                System.out.println("- " + student.getName() + " (оценка: " + grade + ")");
            }
        }
    }

    // вспомогательные
    public Set<Student> getAllStudents() {
        return studentSubjects.keySet();
    }

    public Set<Subject> getAllSubjects() {
        return subjectStudents.keySet();
    }

    public Map<Subject, Integer> getStudentSubjects(Student student) {
        return studentSubjects.getOrDefault(student, new HashMap<>());
    }

    public List<Student> getSubjectStudents(Subject subject) {
        return subjectStudents.getOrDefault(subject, new ArrayList<>());
    }
}
