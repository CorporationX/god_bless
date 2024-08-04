package faang.school.godbless.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {

        studentList.add(new Student("name", "faculty", 1));
        studentList.add(new Student("name1", "faculty", 1));
        studentList.add(new Student("name2", "faculty2", 2));
        studentList.add(new Student("name3", "faculty2", 2));
        studentList.add(new Student("name4", "faculty3", 3));

        Map<DataFilter, List<Student>> map = filterStudents(studentList);
        printAllStudents(map);

        addStudent(new Student("Name", "Faculty", 1));
        System.out.println(studentList.size());

        removeStudent("Name", "Faculty", 1);
        System.out.println(studentList.size());

        System.out.println(findAllByFilter(new DataFilter("faculty", 1)));

        printAllStudents(map);
    }

    public static Map<DataFilter, List<Student>> filterStudents(List<Student> studentList) {
        Map<DataFilter, List<Student>> studentMap = new HashMap<>();

        for (Student student : studentList) {
            DataFilter dataFilter = new DataFilter(student.getFaculty(), student.getYear());

            if (studentMap.containsKey(dataFilter)) {
                studentMap.get(dataFilter).add(student);
            } else {
                studentMap.put(dataFilter, new ArrayList<>(List.of(student)));
            }
        }

        return studentMap;
    }

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        studentList.remove(new Student(name, faculty, year));
    }

    public static List<Student> findAllByFilter(DataFilter dataFilter) {
        List<Student> students = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getFaculty().equals(dataFilter.getFaculty()) && student.getYear() == dataFilter.getYear()) {
                students.add(student);
            }
        }

        return students;
    }

    public static void printAllStudents(Map<DataFilter, List<Student>> map) {
        for (Map.Entry<DataFilter, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
