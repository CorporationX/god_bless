package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList());
        students.add(new Student("John", "FCTI", 2));
        students.add(new Student("Max", "ILGIS", 1));
        students.add(new Student("Stan", "FCTI", 2));
        students.add(new Student("Amanda", "CRANCH", 4));
        students.add(new Student("Ada", "CRANCH", 1));
        students.add(new Student("Stela", "ILGIS", 6));

        Map<KeyForHashMap, List<Student>> studentsMap = createStudentMap(students);

        addNewStudent(studentsMap);
        System.out.println(studentsMap);
        System.out.println("-----------------------------------------");

        deleteStudent(studentsMap, "Amanda", "CRANCH", 4);

        KeyForHashMap searchKey = new KeyForHashMap(1, "ILGIS");

        searchStudents(studentsMap, searchKey);
        System.out.println("-----------------------------------------");

        gropedList(studentsMap);
    }

    public static Map<KeyForHashMap, List<Student>> createStudentMap(List<Student> list) {
        Map<KeyForHashMap, List<Student>> classmates = new HashMap<>();

        for (Student student : list) {
            KeyForHashMap key = new KeyForHashMap(student.getYear(), student.getFaculty());
            if (classmates.containsKey(key)) {
                if (classmates.get(key) != null) {
                    classmates.get(key).add(student);
                } else {
                    List<Student> students = new ArrayList<>(Arrays.asList());
                }
            }
        }
        return classmates;
    }

    public static void addNewStudent(Map<KeyForHashMap, List<Student>> map) {
        Student newStudent = new Student("Victor", "CRANCH", 1);
        KeyForHashMap newKey = new KeyForHashMap(newStudent.getYear(), newStudent.getFaculty());
        map.putIfAbsent(newKey, new ArrayList<>());
        map.get(newKey).add(newStudent);
    }

    public static void deleteStudent(Map<KeyForHashMap, List<Student>> map, String name, String faculty, int year) {
        KeyForHashMap deleteKey = new KeyForHashMap(year, faculty);


        if (map.containsKey(deleteKey) && map.get(deleteKey).equals(name)) {
            map.remove(deleteKey, name);
        }
        if (!map.containsKey(deleteKey)) {
            map.remove(deleteKey);
        }
    }

    public static void searchStudents(Map<KeyForHashMap, List<Student>> map, KeyForHashMap searchKey) {
        System.out.println(map.get(searchKey));
    }

    public static void gropedList(Map<KeyForHashMap, List<Student>> map) {
        for (Map.Entry<KeyForHashMap, List<Student>> entry : map.entrySet()) {
            System.out.println("Faculty: " + entry.getKey().getFaculty() +
                    " Year: " + entry.getKey().getYear() + " ");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());

            }
        }

    }
}
