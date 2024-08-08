package progul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public static Map<String, List<Student>> mapStudent(List<Student> studentList) {
        Map<String, List<Student>> testMap = new HashMap<>();
        for (Student s : studentList) {
            String key = s.faculty + " - " + s.year;
            if (!testMap.containsKey(key)) {
                List<Student> mapList = new ArrayList<>();
                mapList.add(s);
                testMap.put(key, mapList);
            }
            else {
                testMap.get(key).add(s);
            }
        }
        return testMap;
    }

    public static void outputMap(Map<String, List<Student>> studentMap) {
        for (Map.Entry<String, List<Student>> pair : studentMap.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    public static void addStudent(Map<String, List<Student>> studentMap, String name, String faculty, int year) {
        String key = faculty + " - " + year;
        if (!studentMap.containsKey(key)) {
            List<Student> mapList = new ArrayList<>();
            mapList.add(new Student(name, faculty, year));
            studentMap.put(key, mapList);
        }
        else {
            studentMap.get(key).add(new Student(name, faculty, year));
        }
    }

    public static void removeStudent(Map<String, List<Student>> studentMap, String name, String faculty, int year) {
        String key = faculty + " - " + year;
        if (studentMap.containsKey(key)) {
            studentMap.get(key).remove(new Student(name, faculty, year));
        }
    }

    public static void searchStudent(Map<String, List<Student>> studentMap, String faculty, int year) {
        String key = faculty + " - " + year;
        System.out.println(studentMap.get(key));
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
