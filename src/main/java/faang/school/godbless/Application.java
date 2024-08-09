package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("God Bless!");

        Student st1 = new Student("name1", "fac1", 1);
        Student st2 = new Student("name2", "fac1", 1);
        Student st3 = new Student("name3", "fac1", 1);
        Student st4 = new Student("name4", "fac2", 2);
        Student st5 = new Student("name5", "fac2", 2);
        Student st6 = new Student("name6", "fac2", 2);
        Student st7 = new Student("name7", "fac3", 2);
        Student st8 = new Student("name8", "fac3", 2);

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);

        allStudents(groupStudents(students));
        addStudent(st7);
        addStudent(st8);
        System.out.println();
        allStudents(groupStudents(students));

        delStudents("name2", "fac1", 1);

        System.out.println();

        allStudents(groupStudents(students));

        System.out.println();

        researchStudent("fac2", 2);
    }

    public static Map<String, List<Student>> groupStudents(List<Student> students) {
        Map<String, List<Student>> studentsMap = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " " + student.getYear();
            if (studentsMap.containsKey(key)) {
                studentsMap.get(key).add(student);
            } else {
                studentsMap.put(key, new ArrayList<>());
                studentsMap.get(key).add(student);
            }
        }
        return studentsMap;
    }

    public static void allStudents(Map<String, List<Student>> map) {
        for (Map.Entry<String, List<Student>> pair : map.entrySet()) {

    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void delStudents(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public static void researchStudent(String faculty, int year) {
        System.out.println(groupStudents(students).get(faculty + " " + year));
    }
}