package faang.school.godbless.university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {

        addStudent(studentList, new Student("Mark", "CS", 4));
        addStudent(studentList, new Student("Michael", "Biology", 1));
        addStudent(studentList, new Student("Leonardo", "CS", 2));
        addStudent(studentList, new Student("Sandra", "CS", 2));
        addStudent(studentList, new Student("Elena", "Biology", 1));
        addStudent(studentList, new Student("Bob", "CS", 2));
        addStudent(studentList, new Student("Bill", "Biology", 1));
        addStudent(studentList, new Student("Clod", "Biology", 3));

        deleteStudent(studentList, new Student("Mark", "CS", 4));

        List<Student> resultOfSearch = searchAllStudent("CS", 2);
        //System.out.println(resultOfSearch);

        printAllStudents();
    }

    private static void printAllStudents() {
        Map<GroupOfStudents, List<Student>> facultyAndYear = groupByFacultyAndYear();

        for (Map.Entry<GroupOfStudents, List<Student>> entry : facultyAndYear.entrySet()) {
            GroupOfStudents group = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("Faculty: " + group.getFaculty() + ", Year: " + group.getYear());

            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    private static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    private static void deleteStudent(List<Student> students, Student student) {
        students.add(student);
    }

    private static List<Student> searchAllStudent(String faculty, int year) {
        GroupOfStudents groupOfStudents = new GroupOfStudents(faculty, year);
        return groupByFacultyAndYear().get(groupOfStudents);
    }

    public static Map<GroupOfStudents, List<Student>> groupByFacultyAndYear() {
        Map<GroupOfStudents, List<Student>> mapFacultyAndYear = new HashMap<>();

        for (Student student : studentList) {
            List<Student> listFacultyAndYear = new ArrayList<>();
            if (!mapFacultyAndYear.containsKey(student.getFacultyAndYear())) {
                mapFacultyAndYear.put(student.getFacultyAndYear(), listFacultyAndYear);
            }
            mapFacultyAndYear.get(student.getFacultyAndYear()).add(student);
        }
        return mapFacultyAndYear;
    }
}