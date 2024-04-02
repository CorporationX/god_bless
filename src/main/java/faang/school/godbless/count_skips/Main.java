package faang.school.godbless.count_skips;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student("Test1", "programming", 1));
        students.add(new Student("Test2", "programming", 1));
        students.add(new Student("Test3", "programming", 1));
        students.add(new Student("Test4", "programming", 2));
        students.add(new Student("Test5", "programming", 2));
        students.add(new Student("Test6", "drawing", 1));
    }

    public static void main(String[] args) {
        printStudents();
        addNewStudent(new Student("NewStudent", "NewFaculty", 1));

        System.out.println();

        printStudents();
        deleteStudent("NewStudent", "NewFaculty", 1);

        System.out.println();

        System.out.println(findAllStudentsByFacultyAndYear("programming", 1));
    }

    public static void addNewStudent(Student student) {
        students.add(student);
    }

    public static void deleteStudent(String name, String faculty, int year) {
        Student studentForRemove = new Student(name, faculty, year);
        for (Student student : students) {
            if (student.equals(studentForRemove)) {
                students.remove(studentForRemove);
                break;
            }
        }
    }

    public static List<Student> findAllStudentsByFacultyAndYear(String faculty, int year) {
        List<Student> ans = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                ans.add(student);
            }
        }
        return ans;
    }

    public static void printStudents() {
        Student.groupStudents(students).forEach(((key, value) -> System.out.printf("%s -> %s%n", key, value)));
    }


}
