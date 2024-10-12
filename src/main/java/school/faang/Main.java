package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.StudentService.addStudent;
import static school.faang.StudentService.removeStudent;
import static school.faang.StudentService.searchStudentByGroup;
import static school.faang.StudentService.updateStudentsMap;
import static school.faang.StudentService.viewAllStudents;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static Map<FacultyYearGroup, List<Student>> groupsMap = new HashMap<>();

    public static void main(String[] args) {
        addStudent(students, "Ivan", "AVTI", "2015");
        addStudent(students, "Sergey", "INEI", "2013");
        addStudent(students, "Dima", "AVTI", "2015");
        updateStudentsMap(groupsMap, students);

        //viewAllStudents(groupsMap);
        System.out.println(searchStudentByGroup(groupsMap, "AVTI", "2015"));
        removeStudent(groupsMap, "Ivan", "AVTI", "2015");
        viewAllStudents(groupsMap);
    }


}

