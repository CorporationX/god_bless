package school.faang.dual_cache;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {

    // Хранит информацию о студентах, их предметах и оценках
    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    // Хранит информацию о предметах и списке студентов, изучающих каждый предмет
    private final Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        studentSubjects = new HashMap<Student, Map<Subject, Integer>>();
        subjectStudents = new HashMap<Subject, List<Student>>();
    }

    // 4.1
    // Добавление нового студента в studentSubjects и записывает для него оценки
    // по каждому предмету, добовление студента к каждому предмету в subjectStudents
    void addNewStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);           // Добавляем оценки для студента
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);  // Добавляем студента к предмету
        }
    }

    // 4.2
    // Добавляет новый предмет и оценку для существующего студента.
    // Если студент отсутствует, создается новая запись
    void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>() {
            {
                put(subject, grade);
            }
        });
        studentSubjects.get(student).put(subject, grade);

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    // 4.3
    // Удаляет студента и все его предметы из studentSubjects,
    // а также удаляет его из списков студентов для всех соответствующих предметов в subjectStudents
    void removeStudent(Student student) {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            var list = subjectStudents.get(subject);
            if (list != null) {
                list.remove(student);
            }
            subjectStudents.put(subject, list);
        }
        studentSubjects.remove(student);
    }

    // 4.4
    // Выводит список всех предметов и всех студентов, изучающих каждый предмет
    void printAllStudentsWithSubjectsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            var value = entry.getValue();
            System.out.println(student.getName());
            for (Map.Entry<Subject, Integer> entry1 : value.entrySet()) {
                Subject subject = entry1.getKey();
                System.out.println("--- " + subject.getName() + ": " + entry1.getValue());
            }
        }
    }

    // 5.1
    // Добавляет новый предмет в subjectStudents и присваивает ему список студентов.
    // Также добавляет предмет в studentSubjects каждого студента.
    void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students)); // Можно ли просто студентов добавить, без new Array?
        for (var student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    // 5.2
    // Добавляет студента к существующему предмету.
    // Если предмет или студент отсутствуют, создаются соответствующие записи.
    void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }

        /*studentSubjects.putIfAbsent(student, new HashMap<>()); // Было в задании, так затирает прошлую оценку
        studentSubjects.get(student).put(subject, null);*/

        studentSubjects.putIfAbsent(student, new HashMap<>());
        if (!studentSubjects.get(student).containsKey(subject)) {
            studentSubjects.get(student).put(subject, null);
        }
    }

    // 5.3
    // Удаляет студента из предмета в subjectStudents и очищает запись
    // предмета у студента в studentSubjects.
    void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    // 5.4
    // Выводит список предметов и всех студентом изучающих этот предмет
    void printAllSubjectsWithStudents() {
        subjectStudents.forEach((k, v) -> {
            System.out.println(k.getName());
            v.forEach(s -> System.out.println("----" + s.getName()));
        });

        // Чтобы было, реализация на более низком уровне
        /*for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            var value = entry.getValue();
            System.out.println(subject.getName());
            value.forEach(s -> System.out.println("----" + s.getName()));
        }*/
    }
}
