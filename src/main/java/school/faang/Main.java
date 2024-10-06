package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addStudent("Ivan", "AVTI", "2015");
        addStudent("Sergey", "INEI", "2013");
        addStudent("Dima", "AVTI", "2015");
        Map<Group, List<Student>> groupsMap = groups(students);
        viewAllStudents(groupsMap);
//        System.out.println(searchStudentByGroup(groupsMap, "AVTI", "2015"));
//        removeStudent(groupsMap, "Ivan", "AVTI", "2015");
//        searchStudentByGroup(groupsMap, "AVTI", "2015");
    }

    private static Map<Group, List<Student>> groups(List<Student> students) {
        Map<Group, List<Student>> map = new HashMap<>();
        for (Student studentI : students) {
            List<Student> studentsIList = new ArrayList<>();
            Group group = new Group(studentI);
//            System.out.println("\nGroup " + group.getFaculty());
            for (Student studentJ : students) {
                if (group.getFaculty() == studentJ.getFaculty()
                        && group.getYear() == studentJ.getYear()) {
                    studentsIList.add(studentJ);
//                    System.out.println("Student " + studentJ.getName());
                }
            }
            map.put(group, studentsIList);
        }
        return map;
    }

    public static void addStudent(String name, String faculty, String year) {
        students.add(new Student(name, faculty, year));
    }

    public static void removeStudent(Map<Group, List<Student>> map, String name, String faculty, String year) {
        Group group = new Group(faculty, year);
        List<Student> bufferList = map.get(group);
        bufferList.remove(new Student(name, faculty, year));
        map.put(group, bufferList);
    }

    public static String searchStudentByGroup(Map<Group, List<Student>> map, String faculty, String year) {
        Group group = new Group(faculty, year);
        List<Student> studentList = map.get(group);
       return group.toString() + ":\n" + studentList.toString();
    }
    public static void viewAllStudents(Map<Group, List<Student>> map){
        map.forEach((k, v) -> v.forEach((student -> student.getName())));
                //System.out.println(k + "=" + v));
    }
}

