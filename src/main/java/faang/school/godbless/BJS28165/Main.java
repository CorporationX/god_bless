package faang.school.godbless.BJS28165;

import java.util.ArrayList;
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
        if (mapStudents.containsKey(facultyYear)) {
            if (mapStudents.get(facultyYear).contains(student)) {
                System.out.println(student + " has already exists in the map");
            } else {
                mapStudents.get(facultyYear).add(student);
                System.out.println(student + " added successfully for existing FacultyYear");
            }
        } else {
            mapStudents.put(facultyYear, new ArrayList<>());
            mapStudents.get(facultyYear).add(student);
            System.out.println(student + " added successfully for new FacultyYear");
        }
    }

    public static void removeStudent(Student student, Map<FacultyYear, List<Student>> mapStudents) {
        FacultyYear facultyYear = new FacultyYear(student.getFaculty(), student.getYear());
        if (mapStudents.containsKey(facultyYear)) {
            if (mapStudents.get(facultyYear).contains(student)) {
                mapStudents.get(facultyYear).remove(student);
                System.out.println(student + " successfully removed");
            } else {
                System.out.println(student + " doesn't exist in the map, but FacultyYear is correct");
            }
        } else {
            System.out.println(student + " and even FacultyYear don't exist in the map");
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
            if (students.size() > 0) {
                students.forEach(student -> System.out.println(student));
            } else {
                System.out.println("There's no students in " + facultyYear.toString());
            }
        } else {
            System.out.println(facultyYear.toString() + " doesn't exist");
        }
    }
}
