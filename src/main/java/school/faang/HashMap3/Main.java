package school.faang.HashMap3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static school.faang.HashMap3.StudentService.addStudent;
import static school.faang.HashMap3.StudentService.deleteStudent;
import static school.faang.HashMap3.StudentService.printGroupedStudents;
import static school.faang.HashMap3.StudentService.searchStudents;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();
        addStudent(new Student("Anton", 1, "physics"), studentsList);
        addStudent(new Student("Denis", 2, "Marketing"), studentsList);
        addStudent(new Student("Lev", 1, "physics"), studentsList);
        addStudent(new Student("Bogdan", 1, "IT"), studentsList);
        addStudent(new Student("Max", 2, "Marketing"), studentsList);
        addStudent(new Student("Sergey", 1, "IT"), studentsList);

        printGroupedStudents(studentsList);
        searchStudents(1, "physics", studentsList);
        deleteStudent("Anton", 1, "physics", studentsList);
        printGroupedStudents(studentsList);
        searchStudents(1, "physics", studentsList);
    }
}
