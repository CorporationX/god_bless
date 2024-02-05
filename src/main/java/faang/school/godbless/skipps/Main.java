package faang.school.godbless.skipps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<Student> students = new ArrayList<>() {{
        add(new Student("John", "Engineering", 2));
        add(new Student("Alice", "Medicine", 3));
        add(new Student("Bob", "Computer Science", 1));
    }};

    public static void main(String[] args) {
        add(new Student("Oleg", "Street Sweep", 4));
        delete("Alice", "Medicine", 3);
        printByStudentInfo("Engineering", 2);
        System.out.println();
        printAllGroupByInfo();
    }

    public static void add(Student student) {
        students.add(student);
    }

    public static void delete(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public static void printByStudentInfo(String faculty, int year) {
        Map<StudentInfo, List<Student>> studentsMap = convertToMap(students);
        List<Student> studentList = studentsMap.get(new StudentInfo(faculty, year));
        System.out.println(String.format("Студенты факультета \"%s\" %s-го курса:", faculty, year));
        for (Student student : studentList) {
            System.out.println(student.getName());
        }
    }

    public static void printAllGroupByInfo() {
        Map<StudentInfo, List<Student>> studentsMap = convertToMap(students);
        for (var entry : studentsMap.entrySet()) {
            System.out.println(String.format("Студенты факультета \"%s\" %s-го курса:", entry.getKey().getFaculty(),
                                                                                       entry.getKey().getYear()));
            for (var student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }

    private static Map<StudentInfo, List<Student>> convertToMap(List<Student> studentsList) {
        Map<StudentInfo, List<Student>> studentsMap = new HashMap<>();
        for (var student : studentsList) {
            StudentInfo studentInfo = new StudentInfo(student.getFaculty(), student.getYear());
            if (studentsMap.get(studentInfo)  == null) {
                List<Student> mapList = new ArrayList<>();
                mapList.add(student);
                studentsMap.put(studentInfo, mapList);
            }
            else {
                studentsMap.get(studentInfo).add(student);
            }
        }
        return studentsMap;
    }
}
