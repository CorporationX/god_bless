package faang.school.godbless.uni;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.uni.StudentService.*;

public class Main {

    public static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student("BOB", "faculty", 1));
        studentList.add(new Student("TOM", "faculty", 1));
        studentList.add(new Student("ZAZ", "faculty", 2));
        studentList.add(new Student("Test", "Test", 2));
    }

    public static void main(String[] args) {
        Student student = new Student("new Test", "new Test", 1);
        addStudentInList(student);

        Student anotherStudent = new Student("Test", "Test", 2);
        removeStudentFromList(anotherStudent);

        Map<Map.Entry<String, Integer>, List<Student>> students = groupStudentsByFacultyAndYear(studentList);

        printGroupStudentsByFacultyAndYear(students);
    }
}
