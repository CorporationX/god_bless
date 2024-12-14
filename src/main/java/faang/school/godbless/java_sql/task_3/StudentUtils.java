package faang.school.godbless.java_sql.task_3;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentUtils {

    static void addStudent(ArrayList<Student> students, Student student) {
        students.add(student);
    }

    static void deleteStudent(ArrayList<Student> students, Student student) {
        students.remove(student);
    }

    static void printGroupedStudents(HashMap<FacultyYearPair, ArrayList<Student>> students) {
        System.out.println(students);
    }


}
