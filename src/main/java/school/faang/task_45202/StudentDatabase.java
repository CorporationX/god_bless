package school.faang.task_45202;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> studentBySubject = new HashMap<>();

    public void addNewStudentWithGrades(Student student, Map<Subject, Integer> subjects) {
        if (studentGrades.containsKey(student)) {
            System.out.println("Студент" + student.getName() + "уже есть в списке");
            return;
        }
        studentGrades.putIfAbsent(student, subjects);
        for (Subject subject : subjects.keySet()) {
            studentBySubject.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        }
    }

    public void addNewSubjectForStudent(Student student, Subject subject, int grade) {
        studentGrades.computeIfAbsent(student, key -> new HashMap<>()).put(subject, grade);
        studentBySubject.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        if (!studentGrades.containsKey(student)) {
            System.out.println("Данный студент не существует");
            return;
        }
        studentGrades.remove(student);
        studentBySubject.forEach(((subject, students) -> students.remove(student)));
        System.out.println("Студент " + student.getName() + " удален");
    }


    public void printAllStudentsFromSubject() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println("Студент " + entry.getKey());
            System.out.println("Предметы " + entry.getValue());
        }
        System.out.println();
    }

    public void addSubjectForStudent(Subject subject, List<Student> students) {
        if (studentBySubject.containsKey(subject)) {
            System.out.println("Данный предмет уже есть в списке");
            return;
        }
        studentBySubject.put(subject, students);

        for (Student student : students) {
            studentGrades.computeIfAbsent(student, key -> new HashMap<>()).put(subject, 0);
        }
        System.out.println("Предмет " + subject.getName() + " добавлен");
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (!studentBySubject.containsKey(subject)) {
            System.out.println("Данный предмет отсутствует в списке");
            return;
        }
        List<Student> students = studentBySubject.get(subject);
        if (students.contains(student)) {
            System.out.println("Данный студент уже есть в списке");
            return;
        }
        students.add(student);

        Map<Subject, Integer> subjectIntegerMap = studentGrades.computeIfAbsent(student, k -> new HashMap<>());
        subjectIntegerMap.put(subject, 0);

        System.out.println("Студент " + student.getName() + " добавлен к предмету " + subject.getName());
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> currentStudent = studentBySubject.get(subject);

        if (currentStudent == null || !currentStudent.contains(student)) {
            System.out.println("Студент отсутствует в данном предмете");
            return;
        }
        currentStudent.remove(student);
        if (currentStudent.isEmpty()) {
            studentBySubject.remove(subject);
        }
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
        if (grades.isEmpty()) {
            studentGrades.remove(student);
        }
        System.out.println("Студент " + student.getName() + " удален из предмета " + subject.getName());
    }

    public void printAllSubjectsForStudent() {
        for (var entry : studentBySubject.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
