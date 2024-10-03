package school.faang.truancy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> allStudents = new ArrayList<>();

    public static void main(String[] args) {
        Student student = new Student("Aleksey", "IT", 1);
        Student student1 = new Student("Sergey", "HR", 2);
        Student student2 = new Student("Vladimir", "IT", 1);
        Student student3 = new Student("Anton", "IT", 4);
        Student student4 = new Student("Dmitry", "HR", 2);
        Student student5 = new Student("Igor", "IT", 6);
        Student student6 = new Student("FFF", "IT", 1);
        allStudents.add(student);
        allStudents.add(student1);
        allStudents.add(student2);
        allStudents.add(student3);
        allStudents.add(student4);
        allStudents.add(student5);

        Map<Map<String, Integer>, List<Student>> myMap = addStudents(allStudents);

        System.out.println(myMap);
        System.out.println("------------------------------------------------------------");

        addNewStudent(myMap, student6);
        System.out.println(myMap);
        System.out.println("------------------------------------------------------------");
        removeStudentByName(myMap, "John");
        System.out.println(myMap);
        System.out.println("------------------------------------------------------------");
        removeByFacultyAndCourse(myMap, student4);
        System.out.println(myMap);
        System.out.println("------------------------------------------------------------");
        findByCourseAndFaculty(myMap, "IT", 1);
        System.out.println(myMap);

    }

    public static Map<Map<String, Integer>, List<Student>> addStudents(List<Student> listStudents) {
        Map<Map<String, Integer>, List<Student>> result = new HashMap<>();
        for (Student st : listStudents) {
            Map<String, Integer> key = new HashMap<>();
            key.computeIfAbsent(st.getFaculty(), k -> st.getYear());
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(st);
        }
        return result;
    }

    public static Map<Map<String, Integer>, List<Student>> addNewStudent
            (Map<Map<String, Integer>, List<Student>> myMap, Student student) {
        Map<String, Integer> key = new HashMap<>();
        key.computeIfAbsent(student.getFaculty(), k -> student.getYear());
        myMap.computeIfPresent(key, (k, v) -> {
            v.add(student);
            return v;
        });
        myMap.computeIfAbsent(key, k -> Collections.singletonList(student));
        return myMap;
    }

    public static void removeStudentByName(Map<Map<String, Integer>,
            List<Student>> myMap, String name) {
        myMap.values().forEach(students -> students.
                removeIf(s -> s.getName().equals(name)));
    }

    public static void removeByFacultyAndCourse(Map<Map<String, Integer>, List<Student>> myMap, Student student) {
        myMap.entrySet().stream()
                .filter(entry -> entry.getKey().containsKey(student.getFaculty()) &&
                        entry.getKey().get(student.getFaculty()).equals(student.getYear()))
                .findFirst()
                .ifPresent(entry -> entry.getValue().remove(student));
    }

    public static void findByCourseAndFaculty(Map<Map<String, Integer>, List<Student>> myMap, String faculty, int course) {
        myMap.entrySet().stream().
                filter(entry -> entry.getKey()
                        .containsKey(faculty) && entry.getKey().get(faculty) == course)
                .forEach(v -> System.out.println(v.getValue()));
    }
}
