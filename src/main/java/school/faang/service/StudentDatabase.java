package school.faang.service;

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
        subjectStudents.computeIfAbsent(subject,value -> new ArrayList<>()).add(student);

    }

    //Добавление нового предмета для существующего студента с оценкой.
    //
    //Удаление студента и его предметов.
    //
    //Вывод списка всех студентов и их оценок по предметам.
}
