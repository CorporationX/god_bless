package faang.school.godbless.Task8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Student> students = new ArrayList<>();

    public static void showMap(Map<Pair, List<Student>> table) {
        for (Map.Entry entry : table.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void showList() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static Map<Pair, List<Student>> createTable() {
        Map<Pair, List<Student>> table = new HashMap<>();
        for (Student student : students) {
            table.computeIfAbsent(new Pair(student.getFaculty(), student.getYear()),
                    k -> new ArrayList<>()).add(student);
        }
        return table;
    }

    public static void removeStudent(String name, String faculty, int year) {
        Map<Student, Integer> table = new HashMap<>();
        int i = 0;
        for (Student student : students) {
            table.put(student, i);
            i++;
        }
        if (table.get(new Student(name, faculty, year)) == null) {
            System.out.println("Student wasn't found");
        } else {
            int neededIndex = table.get(new Student(name, faculty, year));
            students.remove(neededIndex);
        }
    }

    public static void findStudents(String faculty, int year) {
        Map<Pair, List<Student>> table = createTable();
        if (table.get(new Pair(faculty, year)) == null) {
            System.out.println("No students for this faculty and year were found");
        } else {
            List<Student> neededStudents = table.get(new Pair(faculty, year));
            int i = 1;
            System.out.println("The following students were found:");
            for (Student student : neededStudents) {
                System.out.println(i +". " + student.getName());
                i++;
            }
        }
    }

    public static void showGroupedStudents() {
        Map<Pair, List<Student>> table = createTable();
        System.out.println("The list of students:");
        for (Map.Entry<Pair, List<Student>> entry : table.entrySet()) {
            System.out.println("faculty: " + entry.getKey().getFaculty() +
                    ", year: " + entry.getKey().getYear());
            int j = 1;
            for (Student student : entry.getValue()) {
                System.out.println(j + ". " + student.getName());
                j++;
            }
        }
    }

    public static void main(String[] args) {

        Student ivan = new Student("Ivan", "Math", 1);
        Student andrey = new Student("Andrey", "Math", 2);
        Student john = new Student("John", "Physics", 2);
        Student jane = new Student("Jane", "Physics", 2);
        Student jordan = new Student("Jordan", "Math", 1);
        //Student zero = new Student("", "Physics", 1);
        //Student doubleZero = new Student("", "", 1);

        students.add(ivan);
        students.add(andrey);
        students.add(john);
        students.add(jane);
        students.add(jordan);
        //students.add(zero);
        //students.add(doubleZero);

        Map<Pair, List<Student>> tableOfStudents = createTable();
        showMap(tableOfStudents);
        Student mike = new Student("Mike", "Physics", 1);
        mike.addToList(students);
        showList();
        System.out.println(); // для визуализации
        removeStudent("Mike", "Physics", 1);
        removeStudent("Steven", "Physics", 2);
        showList();
        System.out.println(); // для визуализации
        findStudents("Math", 1);
        findStudents("Math", 3);
        System.out.println(); // для визуализации
        showGroupedStudents();
    }

}
