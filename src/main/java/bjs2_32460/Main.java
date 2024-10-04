package bjs2_32460;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static List<Student> students = new ArrayList<>();
    public static Map<String, List<Student>> groups = new HashMap<>();
    //key - name-faculty-year, value - [index in common list, index in group list]
    public static Map<String, int[]> index = new HashMap<>();

    public static Map<String, List<Student>> getGroups(List<Student> students) {
        groups = students
                .stream()
                .collect(Collectors.groupingBy(student -> student.getFaculty() + "-" + student.getYear()));
        return groups;
    }

    public static void addStudent(Student student) {
        String group = student.getFaculty() + "-" + student.getYear();
        String indexKey = student.getName() + "-" + group;
        index.put(indexKey, new int[]{students.size(), 0});

        students.add(student);

        if (groups.containsKey(group)) {
            index.get(indexKey)[1] = groups.get(group).size();
            groups.get(group).add(student);
        } else {
            groups.put(group, new ArrayList<>(List.of(student)));
        }
    }

    public static void deleteStudent(String name, String faculty, Integer year) {
        String group = faculty + "-" + year;
        String indexKey = name + "-" + group;
        if (index.containsKey(indexKey)) {
            students.remove(index.get(indexKey)[0]);
            groups.get(group).remove(index.get(indexKey)[1]);
        }
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, Integer year) {
        return groups.get(faculty + "-" + year);
    }

    public static void printAllGroups() {
        for (var entry : groups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addStudent(new Student("name1", "faculty1", 1));
        addStudent(new Student("name2", "faculty2", 3));
        addStudent(new Student("name3", "faculty1", 1));
        addStudent(new Student("name4", "faculty1", 4));

        System.out.println(groups);
        System.out.println("===============================");
        System.out.println(students);
        System.out.println("===============================");
        System.out.println(findStudentsByFacultyAndYear("faculty1", 1));
        System.out.println("===============================");
        deleteStudent("name3", "faculty1", 1);
        System.out.println("===============================");
        System.out.println(students);
        System.out.println("===============================");
        System.out.println(groups);
        System.out.println("===============================");
        printAllGroups();
    }
}
