package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServices {
    public static Map<KeyForStudentsMap, List<Student>> createStudentMap(List<Student> list) {
        Map<KeyForStudentsMap, List<Student>> classmates = new HashMap<>();

        for (Student student : list) {
            KeyForStudentsMap key = new KeyForStudentsMap(student.getYear(), student.getFaculty());
            if (classmates.get(key) != null) {
                classmates.get(key).add(student);
            } else {
                List<Student> students = new ArrayList<>();
                students.add(student);
                classmates.put(key, students);
            }
        }
        return classmates;
    }

    public static Map<KeyForStudentsMap, List<Student>> addNewStudent(Map<KeyForStudentsMap, List<Student>> map, Student student) {
        KeyForStudentsMap newKey = new KeyForStudentsMap(student.getYear(), student.getFaculty());
        map.putIfAbsent(newKey, new ArrayList<>());
        map.get(newKey).add(student);
        return map;
    }

    public static void deleteStudent(Map<KeyForStudentsMap, List<Student>> map, String name, String faculty, int year) {
        KeyForStudentsMap deleteKey = new KeyForStudentsMap(year, faculty);
        if (map.containsKey(deleteKey)) {
            List<Student> students = map.get(deleteKey);
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getName().equals(name)) {
                    students.remove(i);
                    i--;
                }
            }
            if (students.isEmpty()) {
                map.remove(deleteKey);
            }
        }
    }

    public static void searchStudents(Map<KeyForStudentsMap, List<Student>> map, KeyForStudentsMap searchKey) {
        List<Student> students = map.get(searchKey);
        System.out.println(searchKey.getFaculty() + " " + searchKey.getYear() + " :");
        for (Student student : students) {
            System.out.print(student.getName() + " ");
        }
        System.out.println();
    }

    public static void gropedList(Map<KeyForStudentsMap, List<Student>> map) {
        for (Map.Entry<KeyForStudentsMap, List<Student>> entry : map.entrySet()) {
            System.out.println("Faculty: " + entry.getKey().getFaculty() +
                    " Year: " + entry.getKey().getYear() + " ");
            for (Student student : entry.getValue()) {
                System.out.print(student.getName() + " ");
            }
            System.out.println();
        }
    }
}
