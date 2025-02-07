package school.faang.task56944.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class StudentDatabase {
    /**
     * хранит информацию о студентах, их предметах и оценках.
     */
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    /**
     * хранит информацию о предметах и списке студентов, изучающих каждый предмет.
     */
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    //Добавление нового студента и его предметов с оценками.
    public void addStudent(Student student, Subject subject, Integer grade) {
        studentSubjects.computeIfAbsent(student, value -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
    }

    //Добавление нового предмета для существующего студента с оценкой.
    public void addSubject(Student student, Subject subject, Integer grade) {
        if (studentSubjects.containsKey(student)) {
            System.out.println("Есть такой студент");
            studentSubjects.get(student).put(subject, grade);
        } else {
            System.out.println("Нет такого студента");
        }

        subjectStudents.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
    }

    public void removeStudentSubject(Student student, Subject subject) {
        studentSubjects.remove(student);
        subjectStudents.remove(subject);
    }

    public void prinAllInfo() {
        System.out.println(getStudentSubjects());
        System.out.println(getSubjectStudents());
    }
}
