package faang.school.godbless.BJS28165;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Max", "Java", 2024));
        students.add(new Student("Gena", "Java", 2024));
        students.add(new Student("Nikita", "Repair", 2020));
        students.add(new Student("Denya", "Repair", 2021));
        students.add(new Student("Antoha", "Production", 2020));
        students.add(new Student("Shkaf", "Production", 2021));

        Map<FacultyYear, List<Student>> sortedStudents = createMapStudents(students);
        printMap(sortedStudents);

        System.out.println("CHECK ADD METHOD\n " +
                "=================================================");
        addNewStudent(new Student("Max", "Java", 2024), sortedStudents);
        addNewStudent(new Student("Valek", "Java", 2024), sortedStudents);
        addNewStudent(new Student("Viet", "Sber", 2024), sortedStudents);
        printMap(sortedStudents);

        System.out.println("CHECK REMOVE METHOD\n " +
                "=================================================");

        removeStudent(new Student("Valek", "Java", 2024), sortedStudents);
        removeStudent(new Student("Valek", "Java", 2024), sortedStudents);
        removeStudent(new Student("Valek", "C#", 2024), sortedStudents);
        printStudentsFromFacultyYear(new FacultyYear("Java", 2024), sortedStudents);
        printStudentsFromFacultyYear(new FacultyYear("C#", 2024), sortedStudents);
        removeStudent(new Student("Viet", "Sber", 2024), sortedStudents);
        printStudentsFromFacultyYear(new FacultyYear("Sber", 2024), sortedStudents);
    }

    public static Map<FacultyYear, List<Student>> createMapStudents(List<Student> students) {
        Map<FacultyYear, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            FacultyYear facultyYear = new FacultyYear(student.getFaculty(), student.getYear());
            result.computeIfAbsent(facultyYear, key -> new ArrayList<Student>()).add(student);
        }
        return result;
    }

    public static void addNewStudent(Student student, Map<FacultyYear, List<Student>> mapStudents) {
        FacultyYear facultyYear = new FacultyYear(student.getFaculty(), student.getYear());
        List<Student> students = mapStudents.computeIfAbsent(facultyYear, key -> new ArrayList<>());
        if (students.contains(student)) {
            System.out.println(student + " has already exists in the map\n");
        } else {
            students.add(student);
            System.out.println(student + " added successfully\n");
        }
    }

    public static void removeStudent(Student student, Map<FacultyYear, List<Student>> mapStudents) {
        FacultyYear facultyYear = new FacultyYear(student.getFaculty(), student.getYear());
        if (!mapStudents.containsKey(facultyYear) || !mapStudents.get(facultyYear).removeIf(s -> s.equals(student))) {
            System.out.println(student + " doesn't exist in the map");
        }
    }

    public static void printMap(Map<FacultyYear, List<Student>> mapStudents) {
        System.out.println("Start printing students list group by FacultyYear:");
        mapStudents.forEach((key, value) -> {
            System.out.println(key + " Students: ");
            value.forEach(v -> System.out.println(v));
            System.out.println();
        });
        System.out.println("FInish printing students list group by FacultyYear");
        System.out.println();
    }

    public static void printStudentsFromFacultyYear(FacultyYear facultyYear, Map<FacultyYear, List<Student>> mapStudents) {
        if (mapStudents.containsKey(facultyYear)) {
            List<Student> students = mapStudents.get(facultyYear);
            System.out.println(facultyYear.toString() + " includes next students:");
            if (!students.isEmpty()) {
                students.forEach(student -> System.out.println(student));
            } else {
                System.out.println("There's no students in " + facultyYear.toString());
            }
        } else {
            System.out.println(facultyYear.toString() + " doesn't exist");
        }
    }
}
