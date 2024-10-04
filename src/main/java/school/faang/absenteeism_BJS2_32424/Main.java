package school.faang.absenteeism_BJS2_32424;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> allStudents = new ArrayList<>();

    public static void main(String[] args) {

        addNewStudent(new Student("Ivan Ivanov", "Computer Science", "1"));
        addNewStudent(new Student("Maria Smirnova", "Mathematics", "2"));
        addNewStudent(new Student("Alexey Petrov", "Physics", "3"));
        addNewStudent(new Student("Anna Kuznetsova", "Computer Science", "1"));
        addNewStudent(new Student("Olga Sokolova", "Chemistry", "4"));
        addNewStudent(new Student("Petr Volkov", "Physics", "3"));

        System.out.println(groupStudentsByFacultyAndCourse(allStudents));
        printGroupedStudents();
        System.out.println(findAllStudentsByFacultyAndCourse("Physics", "3"));
        addNewStudent(new Student("Aleksey Petrov", "Chemistry", "4"));
        printGroupedStudents();
        deleteStudentByNameFacultyYear("Maria Smirnova", "Mathematics", "2");
        printGroupedStudents();
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndCourse(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : students) {
            String faultyAndCourse = student.getFaculty() + student.getYear();
            groupedStudents.computeIfAbsent(faultyAndCourse, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    public static void addNewStudent(Student student) {
        if (allStudents.contains(student)) {
            System.out.println("Student is already in the list");
        } else {
            allStudents.add(student);
        }
    }

    public static void deleteStudentByNameFacultyYear(String name, String faculty, String year) {
        allStudents.remove(new Student(name, faculty, year));
    }

    public static List<Student> findAllStudentsByFacultyAndCourse(String faculty, String course) {
        List<Student> sortedStudents = new ArrayList<>();
        String facultyAndCourseFromParam = faculty + course;

        for (Student student : allStudents) {
            String valueToCompare = student.getFaculty() + student.getYear();

            if (valueToCompare.equals(facultyAndCourseFromParam)) {
                sortedStudents.add(student);
            }
        }
        return sortedStudents;
    }

    public static void printGroupedStudents() {
        Map<String, List<Student>> allGroupedStudents = groupStudentsByFacultyAndCourse(allStudents);

        for (Map.Entry<String, List<Student>> entryStudent : allGroupedStudents.entrySet()) {
            System.out.printf("\nFaculty and course: %s | Students: ", entryStudent.getKey());
            for (Student student : entryStudent.getValue()) {
                System.out.printf("%s, ", student.getName());
            }
        }
    }

}
