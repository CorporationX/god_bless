package faang.school.godbless.BJS2_8197;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Gennady", "Faculty1", 2010));
        students.add(new Student("Mihail", "Faculty1", 2010));
        students.add(new Student("Elena", "Faculty2", 2010));
        students.add(new Student("Victor", "Faculty2", 2010));
        students.add(new Student("Alexey", "Faculty2", 2011));

        var map = toMap(students);
        printAllStudents(map);
        removeStudent(map, "Elena", "Faculty2", 2010);
        System.out.println();
        printStudents(map, "Faculty2", 2010);
        System.out.println();
        addStudent(map, new Student("Elena", "Faculty2", 2010));
        printAllStudents(map);
    }

    public static Map<FacultyYear, List<Student>> toMap(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(key -> new FacultyYear(key.getFaculty(), key.getYear())));
    }

    public static void addStudent(Map<FacultyYear, List<Student>> map, Student student) {
        if (student.getFaculty() == null || student.getName() == null){
            return;
        }
        map.get(new FacultyYear(student.getFaculty(), student.getYear())).add(student);
    }

    public static void removeStudent(Map<FacultyYear, List<Student>> map, String name, String faculty, int year) {
        map.get(new FacultyYear(faculty, year)).remove(new Student(name, faculty, year));
    }

    public static void printStudents(Map<FacultyYear, List<Student>> map, String faculty, int year) {
        if (map.containsKey(new FacultyYear(faculty, year))){
            map.get(new FacultyYear(faculty, year)).forEach(System.out::println);
        }

    }

    public static void printAllStudents(Map<FacultyYear, List<Student>> map) {
        map.keySet().forEach(fac -> {
            System.out.println(fac.getFaculty() + ", " + fac.getYear() + ": ");
            map.get(fac).forEach(System.out::println);
        });
    }
}
