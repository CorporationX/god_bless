package school.faang.absenteeism_BJS2_32424;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> allStudents = new ArrayList<>(List.of(
            new Student("Ivan Ivanov", "Computer Science", "1"),
            new Student("Maria Smirnova", "Mathematics", "2"),
            new Student("Alexey Petrov", "Physics", "3"),
            new Student("Anna Kuznetsova", "Computer Science", "1"),
            new Student("Olga Sokolova", "Chemistry", "4"),
            new Student("Petr Volkov", "Physics", "3")
    ));

    public static void main(String[] args) {
        System.out.println(sortStudentByFacultyAndCourse(allStudents));
        printDivider();

        printAllGroupedStudentsByFacultyAndCourse();
        printDivider();

        System.out.println(findAllStudentsByFacultyAndCourse("Physics", "3"));
        printDivider();

        addNewStudent(new Student("Aleksey Petrov", "Chemistry", "4"));
        printDivider();

        printAllGroupedStudentsByFacultyAndCourse();
        printDivider();

        deleteStudentByNameFacultyYear("Maria Smirnova", "Mathematics", "2");
        printAllGroupedStudentsByFacultyAndCourse();
    }

    public static Map<String, List<Student>> sortStudentByFacultyAndCourse(List<Student> students) {
        Map<String, List<Student>> sortedStudents = new HashMap<>();

        for (Student student : students) {
            String faultyAndCourse = student.getFaculty() + student.getYear();
            sortedStudents.computeIfAbsent(faultyAndCourse, k -> new ArrayList<>()).add(student);
        }
        return sortedStudents;
    }

    public static void addNewStudent(Student student) {
        allStudents.add(student);
        System.out.printf("Student %s was successfully added \n", student.getName());
    }

    public static void deleteStudentByNameFacultyYear(String name, String faculty, String year) {
        allStudents.remove(new Student(name, faculty, year));
        System.out.printf("Student %s was successfully deleted \n", name);
    }

    public static List<Student> findAllStudentsByFacultyAndCourse(String faculty, String course) {
        List<Student> sortedStudents = new ArrayList<>();
        String facultyAndCourseFromParam = faculty + course;

        for (Student student : allStudents) {
            String facultiesAndCoursesFromList = student.getFaculty() + student.getYear();

            if (facultiesAndCoursesFromList.equals(facultyAndCourseFromParam)) {
                sortedStudents.add(student);
            }
        }
        return sortedStudents;
    }

    public static void printAllGroupedStudentsByFacultyAndCourse() {
        Map<String, List<Student>> allSortedStudents = sortStudentByFacultyAndCourse(allStudents);

        for (Map.Entry<String, List<Student>> entryStudent : allSortedStudents.entrySet()) {
            System.out.println(entryStudent.getValue());
        }
    }

    public static void printDivider() {
        System.out.println("-".repeat(15));
    }
}
