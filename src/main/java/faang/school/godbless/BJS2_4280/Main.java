package faang.school.godbless.BJS2_4280;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Map<Map<String, Integer>, Set<Student>> STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Student tony = new Student("Tony", "Economics", 1);
        Student john = new Student("John", "Psychology", 1);
        Student rob = new Student("Rob", "Economics", 1);
        Student mark = new Student("Mark", "Economics", 3);

        addNewStudent(tony);
        addNewStudent(john);
        addNewStudent(rob);
        addNewStudent(mark);
        printAllInfo();

        removeStudent(rob.getName(), rob.getFaculty(), rob.getYear());
        printAllInfo();

        findStudentByFacultyAndYear("Economics", 1);
    }

    private static void addNewStudent(Student student) {
        Map<String, Integer> key = new HashMap<>(Map.of(student.getFaculty(), student.getYear()));
        STUDENTS.putIfAbsent(key, new HashSet<>(Set.of(student)));
        if (!STUDENTS.containsKey(key)) {
            STUDENTS.computeIfPresent(key, (faculty, students) -> {
                students.add(student);
                return students;
            });
        }
    }

    private static void removeStudent(String name, String faculty, int year) {
        STUDENTS.computeIfPresent(Map.of(faculty, year), (key, value) -> {
            value.remove(new Student(name, faculty, year));
            return value;
        });
    }

    private static void findStudentByFacultyAndYear(String faculty, int year) {
        System.out.println(STUDENTS.get(Map.of(faculty, year)));
    }

    private static void printAllInfo() {
        for (var entry : STUDENTS.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
