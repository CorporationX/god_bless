package HashMap3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Sam", "it", 2024);
        Student student2 = new Student("Tom", "economy", 2024);
        Student student3 = new Student("Artem", "it", 2023);
        Student student4 = new Student("Anna", "economy", 2024);
        Student student5 = new Student("Mike", "it", 2024);

        List<Student> students = List.of(student1, student2, student4, student5);
        Map<String, List<Student>> stringListMap = groupStudents(students);
        System.out.println(stringListMap);
        put(stringListMap, student3);
        System.out.println(stringListMap);
        remove(stringListMap, student2);
        List<Student> it2024 = getListStudents(stringListMap, "it2024");
        System.out.println(it2024);
        getAllList(stringListMap);


    }

    public static Map<String, List<Student>> groupStudents(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + student.getYear();
            if (map.containsKey(key)) {
                List<Student> list = map.get(key);
                list.add(student);
                map.put(key, list);
            } else {
                List<Student> list = new ArrayList<>();
                list.add(student);
                map.put(key, list);
            }
        }
        return map;
    }

    public static void put(Map<String, List<Student>> map, Student student) {
        String key = student.getFaculty() + student.getYear();
        if (map.containsKey(key)) {
            List<Student> students = map.get(key);
            students.add(student);
            map.put(key, students);
        } else {
            List<Student> students = new ArrayList<>();
            students.add(student);
            map.put(key, students);
        }
    }

    public static void remove(Map<String, List<Student>> map, Student student) {
        String key = student.getFaculty() + student.getYear();
        if (map.containsKey(key)) {
            List<Student> students = map.get(key);
            students.remove(student);
            map.put(key, students);
        } else {
            System.out.println("Студент не найден");
        }
    }

    public static List<Student> getListStudents(Map<String, List<Student>> map, String key) {
        List<Student> list = map.get(key);
        return list;
    }

    public static void getAllList(Map<String, List<Student>> map) {
        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
            System.out.println("Группа " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }

}
