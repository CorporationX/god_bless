package school.faang.truancy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>() {{
        add(new Student("John Connor", HISTORY, 2000));
        add(new Student("Sara Connor", MATH, 1970));
        add(new Student("Jack Sparrow", SEA_WALKING, 1705));
        add(new Student("Black beard", SEA_WALKING, 1705));
        add(new Student("Isaak Newton", MATH, 1970));
    }};
    private static final String HISTORY = "History";
    private static final String ENGLISH = "English";
    private static final String MATH = "Math";
    private static final String SEA_WALKING = "Sea Walking";

    public static void main(String[] args) {
        printStudentsByGroups(STUDENTS);
        addStudent(new Student("John Week", ENGLISH, 2010));
        printStudentsByGroups(STUDENTS);
        printStudentsByGroups(receiveStudentByFacilityAndYear(MATH, 1970));
        deleteStudentByFacilityAndYear(MATH, 1970);
        printStudentsByGroups(receiveStudentByFacilityAndYear(MATH, 1970));
        printStudentsByGroups(receiveStudentByFacilityAndYear(HISTORY, 2000));
        deleteStudentByName("John Connor");
        printStudentsByGroups(receiveStudentByFacilityAndYear(HISTORY, 2000));
    }

    private static Map<StudentGrouper, List<Student>> groupStudents(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(student -> new StudentGrouper(student.getFaculty(), student.getYear())));

    }

    private static void addStudent(Student student) {
        STUDENTS.add(student);
    }

    private static void deleteStudentByName(String name) {
        STUDENTS.removeIf(student -> student.getName().equalsIgnoreCase(name));
    }

    private static void deleteStudentByFacilityAndYear(String facility, int year) {
        STUDENTS.removeIf(student -> student.getFaculty().equals(facility) && student.getYear() == year);
    }

    private static List<Student> receiveStudentByFacilityAndYear(String facility, int year) {
        return STUDENTS.stream()
                .filter(student -> student.getFaculty().equals(facility) && student.getYear() == year).toList();
    }

    private static void printStudentsByGroups(List<Student> students) {
        System.out.println(groupStudents(students));
    }
}
