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
        Student student2 = new Student("Masha", "IT", 2000);
        Student student3 = new Student("Masha", "OEP", 2000);
        Student student4 = new Student("Kolya", "OEP", 2002);
        Student student5 = new Student("Vasya", "RL", 2002);
        Student student6 = new Student("Vasilisa", "RL", 2002);
        Student student7 = new Student("Irina", "IT", 2010);

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        addStudent(student5);
        addStudent(student6);
        addStudent(student7);
        STUDENTS.forEach(System.out::println);

        groupStudentsByCourse(STUDENTS);
        System.out.println();
        COURSES.forEach((k, v) -> System.out.println("course: " + k.getFaculty() + "-" + k.getYear() + " students: " + v));

        removeStudent("Irina", "IT", 2010);
        System.out.println();
        STUDENTS.forEach(System.out::println);

        List<Student> findStudents = findStudent("IT", 2000);
        System.out.println();
        findStudents.forEach(System.out::println);

    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public static void groupStudentsByCourse(List<Student> students) {
        for (Student student : students) {
            Course course = new Course(student.getFaculty(), student.getYear());
            COURSES.computeIfAbsent(course, k -> new ArrayList<>()).add(student);
        }
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        STUDENTS.removeIf(student::equals);
    }

    public static List<Student> findStudent(String faculty, int year) {
        return COURSES.get(new Course(faculty, year));
    }

}
