package school.faang;



import java.util.HashMap;
import java.util.List;

import static school.faang.Student.groupedStudents;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsList = List.of(new Student("Anton", 1, "physics"),
                new Student("Denis", 2, "Marketing"),
                new Student("Lev", 1, "physics"),
                new Student("Bogdan", 1, "IT"),
                new Student("Max", 2, "Marketing"),
                new Student("Sergey", 1, "IT"));

        HashMap<Student, List<Student>> result = groupedStudents(studentsList);

        for (var entry : result.entrySet()) {
            System.out.println(entry.getKey().getFaculty() + entry.getKey().getYear() + entry.getValue());
        }


    }
}
