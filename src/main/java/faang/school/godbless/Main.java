package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final int LAST_YEAR_TEACHING = 5;
    public static final int FIRST_YEAR_TEACHING = 1;
    private static final List<Student> allStudents = new ArrayList<>();

    static {
        allStudents.add(new Student("Bill", "Mathematics", 2));
        allStudents.add(new Student("Sam", "Physics", 3));
        allStudents.add(new Student("Tom", "Literature", 4));
        allStudents.add(new Student("Robert", "Mathematics", 2));
        allStudents.add(new Student("Jack", "Philosophy", 1));
        allStudents.add(new Student("Filip", "Physics", 4));
    }

    public static void main(String[] args) {
        addNewStudent("Sara", "Physics", 3);
        addNewStudent("Bob", "Physics", 3);
        addNewStudent("Masha", "Physics", 3);

        HashMap<String, List<Student>> test = groupingByFacultyAndCourse(allStudents);
        for (Map.Entry<String, List<Student>> x : test.entrySet())
            System.out.println(x.getKey() + " " + x.getValue());
        System.out.println();

        removeStudent(new Student("Masha", "Physics", 3));

        List<Student> testMethod = searchStudentAboutFacultyAndYears("Mathematics", 2);
        testMethod.forEach(System.out::println);

        printStudentAboutFacultyAndYears("Physics", 3);
    }

    public static HashMap<String, List<Student>> groupingByFacultyAndCourse(List<Student> students) {
        if (students == null)
            throw new IllegalArgumentException("Invalid list of students submitted");

        HashMap<String, List<Student>> result = new HashMap<>();
        String facultyAndYear;

        for (Student student : students) {
            facultyAndYear = student.getFaculty() + "_" + student.getYear();

            if (!result.containsKey(facultyAndYear)) {
                List<Student> valueMap = new ArrayList<>();
                valueMap.add(student);
                result.put(facultyAndYear, valueMap);
            } else
                result.get(facultyAndYear).add(student);
        }
        return result;
    }

    public static void addNewStudent(String name, String faculty, int year) {
        if (checkingInformation(name, faculty, year)) {
            allStudents.add(new Student(name, faculty, year));
        }
    }

    public static void removeStudent(Student student) {
        if (student != null) {
            if (allStudents.contains(student)) {
                allStudents.remove(student);
            } else {
                throw new IllegalArgumentException("Student not on the list");
            }
        } else {
            throw new IllegalArgumentException("Student is null");
        }
    }

    public static List<Student> searchStudentAboutFacultyAndYears(String faculty, int year) {
        if (checkingInformation(faculty,year)) {
            String facultyAndYear = faculty + "_" + year;
            return groupingByFacultyAndCourse(allStudents).get(facultyAndYear);
        } else {
            return new ArrayList<>();
        }
    }

    public static void printStudentAboutFacultyAndYears(String faculty, int year) {
        if (checkingInformation(faculty, year)) {
            String facultyAndYear = faculty + "_" + year;
            List<Student> students = groupingByFacultyAndCourse(allStudents).get(facultyAndYear);
            students.forEach(System.out::println);
        }
    }

    public static boolean checkingInformation(String name, String faculty, int year) {
        if (name != null) {
            if (faculty != null) {
                if (year >= FIRST_YEAR_TEACHING && year <= LAST_YEAR_TEACHING) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Not true years");
                }
            } else {
                throw new IllegalArgumentException("Faculty is null");
            }
        } else {
            throw new IllegalArgumentException("Name is null");
        }
    }

    public static boolean checkingInformation(String faculty, int year) {
        if (faculty != null) {
            if (year >= FIRST_YEAR_TEACHING && year <= LAST_YEAR_TEACHING) {
                return true;
            } else {
                throw new IllegalArgumentException("Not true years");
            }
        } else {
            throw new IllegalArgumentException("Faculty is null");
        }
    }

}
