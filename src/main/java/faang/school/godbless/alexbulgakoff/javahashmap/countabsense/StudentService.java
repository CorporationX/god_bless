package faang.school.godbless.alexbulgakoff.javahashmap.countabsense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public class StudentService {

    static List<Student> students;

    public static void main(String[] args) {
        students = new ArrayList<>();

        Student student1 = new Student("Jane", "Biology", "2018");
        Student student2 = new Student("Gorge", "Physical", "2020");
        Student student3 = new Student("Fil", "Computer Science", "2021");
        Student student4 = new Student("Holy", "Design", "2019");
        Student student5 = new Student("Kate", "Machine Learning", "2016");
        Student student6 = new Student("Tim", "Design", "2019");
        Student student7 = new Student("Mark", "Computer Science", "2021");

        addNewStudent(student1);
        addNewStudent(student2);
        addNewStudent(student3);
        addNewStudent(student4);
        addNewStudent(student5);
        addNewStudent(student6);
        addNewStudent(student7);

        System.out.println(students);

        System.out.println(groupingStudentsByFaculty(students));

        removeStudent("Tim", "Design", "2019");

        System.out.println(students);
    }

    public static void addNewStudent(Student newStudent) {
        if (newStudent != null && !students.contains(newStudent)) {
            students.add(newStudent);
        }
    }

    public static void removeStudent(String studentName, String studentFaculty, String studentCourse) {
        students.remove(new Student(studentName, studentFaculty, studentCourse));
    }

    public static Map<Faculty, List<Student>> groupingStudentsByFaculty(List<Student> students) {
        Map<Faculty, List<Student>> map = new HashMap<>();

        students.forEach(student -> {
            Faculty faculty = new Faculty(student.getFaculty(), student.getYear());
            map.putIfAbsent(faculty, new ArrayList<>());
            map.get(faculty).add(student);
        });
        return map;
    }
}
