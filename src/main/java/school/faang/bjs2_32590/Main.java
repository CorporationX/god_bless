package school.faang.bjs2_32590;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>() {{
            add(new Student("Alex", "Engineering", 2));
            add(new Student("Maria", "Arts", 1));
            add(new Student("John", "Science", 3));
            add(new Student("Emily", "Business", 4));
            add(new Student("Michael", "Law", 2));
            add(new Student("Alice", "Engineering", 1));
            add(new Student("Bob", "Science", 2));
            add(new Student("Charlie", "Business", 3));
            add(new Student("Diana", "Arts", 1));
            add(new Student("Eve", "Law", 4));
            add(new Student("Frank", "Engineering", 2));
            add(new Student("Grace", "Science", 3));
            add(new Student("Henry", "Business", 1));
            add(new Student("Isabel", "Arts", 3));
            add(new Student("Jack", "Law", 2));
        }};
        testGroupStudentsByFacultyAndYear(students);
        testAddStudentToList();
    }

    private static void testGroupStudentsByFacultyAndYear(List<Student> students) {
        System.out.println("\ntestGroupStudentsByFacultyAndYear\n");
        Map<FacultyYearPair, List<Student>> facultyYearPairListMap = StudentManager.groupStudentsByFacultyAndYear(students);
        printAllGroupedStudentsByFacultyAndYear(facultyYearPairListMap);
    }

    private static void printAllGroupedStudentsByFacultyAndYear(Map<FacultyYearPair, List<Student>> facultyYearPairListMap) {
        for (Map.Entry<FacultyYearPair, List<Student>> facultyYearPairListEntry : facultyYearPairListMap.entrySet()) {
            System.out.println(facultyYearPairListEntry.getKey());
            List<Student> groupStudent = facultyYearPairListEntry.getValue();
            for (Student student : groupStudent) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    private static void testAddStudentToList() {
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("Jack", "Law", 2);

        System.out.println("\ntestAddStudentToList\n");
        System.out.println("list students before: " + students);

        StudentManager.addStudentToList(student, students);
        System.out.println("add student: " + student);
        System.out.println("list students after: " + students);

        System.out.println("adding the same student again");
        StudentManager.addStudentToList(student, students);
        System.out.println("list students after: " + students);

    }
}
