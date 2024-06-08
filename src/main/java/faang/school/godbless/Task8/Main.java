package faang.school.godbless.Task8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

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
        Student john = new Student("John", "Physics", 3);
        Student jane = new Student("Jane", "physics", 2);
        students.add(ivan);
        students.add(andrey);
        students.add(john);
        students.add(jane);



    }

}
