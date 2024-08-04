package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {


        Student student1 = new Student("Student1", "Faculty1", 1991);
        Student student2 = new Student("Student2", "Faculty2", 1992);
        Student student3 = new Student("Student3", "Faculty3", 1993);
        Student student4 = new Student("Student4", "Faculty4", 1994);
        Student student5 = new Student("Student5", "Faculty5", 1995);
        Student student6 = new Student("Student6", "Faculty6", 1996);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Map<Faculty, List<Student>> map = groupStudentsByFacultyAndYear(students);

        addStudent(student6);
        deleteStudent("Student3", "Faculty3", 1993);
        searchStudent("Faculty4", 1994, map);
        printAllStudents(map);

    }

    public static Map<Faculty, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {

        Map<Faculty, List<Student>> facultyListMap = new HashMap<>();

        for (Student student : students) {
            Faculty faculty = new Faculty(student.getFaculty(), student.getYear());
            facultyListMap.computeIfAbsent(faculty, stu -> new ArrayList<>()).add(student);
        }
        return facultyListMap;
    }

    public static void addStudent(Student student) {
        students.add(student);
        System.out.println("Студент добавлен: " + student);
    }

    public static void deleteStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove(student);
        System.out.println("Студент " + name + " был удален");
    }

    public static void searchStudent(String facultyName, int year, Map<Faculty, List<Student>> facultyListMap) {
        List<Student> studentList = facultyListMap.get(new Faculty(facultyName, year));

        if (studentList == null) {
            return;
        }

        for (Student student : studentList) {
            System.out.println("Студенты " + facultyName + ", " + year);
            System.out.println(student);
        }
    }

    public static void printAllStudents(Map<Faculty, List<Student>> facultyListMap) {
        System.out.println("Список всех студентов: ");
        for (Map.Entry<Faculty, List<Student>> entry : facultyListMap.entrySet()) {
            String facultyName = entry.getKey().getFaculty();
            for (Student student : entry.getValue()) {
                System.out.println(student + " - " + facultyName);
            }
        }
    }
}
