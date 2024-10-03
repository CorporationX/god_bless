package countAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final List<Student> STUDENTS = new ArrayList<>();
    public static final Map<Course, List<Student>> COURSES = new HashMap<>();

    public static void main(String[] args) {

        Student student1 = new Student("Petya", "IT", 2000);
        Student student2 = new Student("Masha", "OEP", 2000);
        Student student3 = new Student("Kolya", "OEP", 2002);
        Student student4 = new Student("Vasya", "RL", 2002);
        Student student5 = new Student("Irina", "IT", 2010);

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        addStudent(student5);

    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
    }

}
