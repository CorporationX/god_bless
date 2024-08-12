package cashcash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@ToString
@Getter
public class Student {
    private int id;
    private String name;

    public static void addStudent(Map<Student, Map<Subject, Integer>> studentMark, Student student, Map<Subject, Integer> markMark) {
        if(!studentMark.containsKey(student)) {
            studentMark.put(student, markMark);
        }
        else {
            System.out.println("Пользователь уже зарегестрирован в базе!");
        }
    }

    public static void addSubject(Map<Student, Map<Subject, Integer>> studentMark, Student student, Subject subject, int mark) {
        if(studentMark.containsKey(student)) {
            studentMark.get(student).put(subject, mark);
        }
        else {
            System.out.println("Пользователь не найден!");
        }
    }

    public static void removeStudent(Map<Student, Map<Subject, Integer>> studentMark, Student student) {
        studentMark.remove(student);
    }
    public static void outputStudent(Map<Student, Map<Subject, Integer>> studentMark) {
        for (Map.Entry<Student, Map<Subject, Integer>> pair : studentMark.entrySet()) {
            System.out.println(pair.getKey().getName() + ": " + pair.getValue());
        }
    }
}
