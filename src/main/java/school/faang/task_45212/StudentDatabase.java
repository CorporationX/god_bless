package school.faang.task_45212;

import lombok.Getter;

import java.util.*;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    private void studentCheck(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть пустым");
        }
    }

    private void subjectCheck(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Предмет не может быть пустым");
        }
    }

    // Добавление нового студента и его предметов с оценками
    public void addStudent(Student student, Map<Subject, Integer> grades) {
        studentCheck(student);

        studentGrades.put(student, grades);
        grades.keySet().forEach(key -> subjectStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student));
    }

    // Добавление нового предмета для существующего студента с оценкой
    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        studentCheck(student);
        subjectCheck(subject);
        if (grade == null) {
            throw new IllegalArgumentException("Оценка не может быть пустой");
        }

        var existMap = studentGrades.computeIfPresent(student, (k, v) -> {
            v.put(subject, grade);
            return v;
        });

        if (existMap == null) {
            throw new IllegalArgumentException("Такого студента: " + student.getName() + " не существует");
        } else {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    // Удаление студента и его предметов
    public void removeStudent(Student student) {
        studentCheck(student);
        Optional.ofNullable(studentGrades.remove(student))
                .orElseThrow(() -> new IllegalArgumentException("Студент " + student.getName() + " не найден"))
                .forEach((subject, grade) -> Optional.ofNullable(subjectStudents.get(subject))
                        .orElseThrow(() -> new IllegalArgumentException("Список студентов для предмета "
                                + subject.getName() + " не найден"))
                        .remove(student));
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println("Студент: " + entry.getKey().getName());
            for (Map.Entry<Subject, Integer> gradeEntry : entry.getValue().entrySet()) {
                System.out.println(" Предмет: " + gradeEntry.getKey().getName() + ", Оценка: " + gradeEntry.getValue());
            }
        }
    }

    // Добавление нового предмета и списка студентов, изучающих его
    public void addSubject(Subject subject, List<Student> students) {
        subjectCheck(subject);

        subjectStudents.put(subject, students);
        students.forEach(student -> studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null));
    }

    // Добавление студента к существующему предмету
    public void addStudentToSubject(Student student, Subject subject) {
        studentCheck(student);
        subjectCheck(subject);

        var studentList = subjectStudents.computeIfPresent(subject, (k, v) -> {
            v.add(student);
            return v;
        });

        if (studentList == null) {
            throw new IllegalArgumentException("Такого предмета: " + subject.getName() + " не существует");
        } else {
            studentGrades.computeIfAbsent(student, k -> new HashMap<>())
                    .computeIfAbsent(subject, k -> null);
        }
    }

    // Удаление студента из предмета
    public void removeStudentFromSubject(Student student, Subject subject) {
        studentCheck(student);
        subjectCheck(subject);

        Optional.ofNullable(subjectStudents.get(subject))
                .orElseThrow(() -> new IllegalArgumentException("Список студентов для предмета "
                        + subject.getName() + " не найден"))
                .remove(student);

        Optional.ofNullable(studentGrades.get(student))
                .orElseThrow(() -> new IllegalArgumentException("Список предметов с оценками для "
                        + student.getName() + " не найден"))
                .remove(subject);
    }

    // Вывод списка всех предметов и студентов, изучающих их
    public void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println(" Студент: " + student.getName());
            }
        }
    }
}
