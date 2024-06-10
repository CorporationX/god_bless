package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> allStudents = new ArrayList<>();

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

        deleteStudent("Masha", "Physics", 3);

        List<Student> testMethod = searchStudentAboutFacultyAndYears("Mathematics", 2);
        for (Student student : testMethod)
            System.out.println(student);
        System.out.println();

        printStudentAboutFacultyAndYears("Physics", 3);
    }

    public static HashMap<String, List<Student>> groupingByFacultyAndCourse(List<Student> students) {
        HashMap<String, List<Student>> result = new HashMap<>();
        String facultyAndYear;

        for (Student student : students) {
            facultyAndYear = student.getFaculty() + "_" + String.valueOf(student.getYear());

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
        if (name != null && faculty != null && year > 0 && year <= 5) {
            allStudents.add(new Student(name, faculty, year));
        } else {
            System.out.println("Введенные данные не верны");
        }
    }

    public static void deleteStudent(String name, String faculty, int years) {
        if (name != null && faculty != null && years > 0 && years <= 5) {
            Student deletStudent = new Student(name, faculty, years);
            if (allStudents.contains(deletStudent)) {
                allStudents.remove(deletStudent);
            } else {
                System.out.println("Такого студента не существует");
            }
        } else {
            System.out.println("Введенные данные не верны либо такого студента не существует");
        }
    }

    public static List<Student> searchStudentAboutFacultyAndYears(String faculty, int year) {
        if (faculty != null && year > 0 && year <= 5) {
            HashMap<String, List<Student>> x = groupingByFacultyAndCourse(allStudents);
            String facultyAndYear = faculty + "_" + year;
            return x.get(facultyAndYear);
        } else {
            System.out.println("Данные не верны");
            return null;
        }
    }

    public static void printStudentAboutFacultyAndYears(String faculty, int year) {
        if (faculty != null && year > 0 && year <= 5) {
            HashMap<String, List<Student>> x = groupingByFacultyAndCourse(allStudents);
            String facultyAndYear = faculty + "_" + year;
            List<Student> students = x.get(facultyAndYear);
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("Данные не верны");
        }
    }
}
