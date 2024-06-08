package faang.school.godbless.Task8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void showMap(Map<Pair, List<Student>> table) {
        for (Map.Entry entry: table.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static HashMap<Pair, List<Student>> createTable(List<Student> students) {
        Map<Pair, List<Student>> table = new HashMap<>();
        for (Student student : students) {
            table.computeIfAbsent(new Pair(student.getFaculty(), student.getYear()),
                    k->new ArrayList<>()).add(student);
        }
        return (HashMap<Pair, List<Student>>) table;
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student ivan = new Student("Ivan", "Math", 1);
        Student andrey = new Student("Andrey", "Math", 2);
        Student john = new Student("John", "Physics", 2);
        Student jane = new Student("Jane", "Physics", 2);
        Student jordan = new Student("Jordan", "Math", 1);
        students.add(ivan);
        students.add(andrey);
        students.add(john);
        students.add(jane);
        students.add(jordan);
        Map<Pair, List<Student>> tableOfStudents = createTable(students);
        showMap(tableOfStudents);

    }

}
