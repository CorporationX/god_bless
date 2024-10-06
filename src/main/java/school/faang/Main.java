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
        Map<Group, List<Student>> groups = groups(students);
    }

    private static Map<Group, List<Student>> groups(List<Student> students) {
        Map<Group, List<Student>> map = new HashMap<>();
        for (Student studentI : students) {
            List<Student> students1 = new ArrayList<>();
            Group group = new Group(studentI);
            System.out.println("\nGroup " + group.getFaculty());
            for (Student studentJ : students) {
                if (studentI.equals(studentJ)
                        && studentI.hashCode() == studentJ.hashCode()
                        && group.getFaculty() == studentJ.getFaculty()
                        && group.getYear() == studentJ.getYear()) {
                    students1.add(studentJ);
                    System.out.println("Student " + studentJ.getName());
                }
            }
            // map.put(group, )
        }
        return map;
    }

    public static void addStudent(String name, String faculty, String year) {
        students.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, String year) {
        students.remove(new Student(name, faculty, year));
    }
}

