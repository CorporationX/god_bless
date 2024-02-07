package faang.school.godbless.JHMCountingNoShows2005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("Harry", "Griffie", 1));
        studentsList.add(new Student("Someguy", "Somefaculty", 2));
        studentsList.add(new Student("Legend", "Faang", 3));
        studentsList.add(new Student("Hero", "Faang", 3));

        // tests
        Map<FacultyYearPair, List<Student>> testMap = groupStudents(studentsList);
        System.out.println("Test 1: Default Map");
        printAllStudentsInfo(testMap);
        addStudentToMap(testMap, new Student("Dima", "Faang", 1));
        addStudentToMap(testMap, new Student("Kamil", "Faang", 2));

        System.out.println("Test 2: Added 2 students");
        printAllStudentsInfo(testMap);
        removeStudentFromMap(testMap, "Harry", "Griffie", 1);
        removeStudentFromMap(testMap, "Someguy", "Somefaculty", 2);

        System.out.println("Test 3: Removed 2 imaginary students");
        printAllStudentsInfo(testMap);
        addStudentToMap(testMap, new Student("Victor", "Faang", 1));
        addStudentToMap(testMap, new Student("Rostik", "Faang", 1));

        System.out.println("Test 4: Added 2 REAL students");
        printAllStudentsInfo(testMap);

        System.out.println("Test 5: Show me Faang's youngest talents");
        printGroupedStudentsInfo(testMap, "Faang", 1);
    }

    public static Map<FacultyYearPair, List<Student>> groupStudents(List<Student> students) {
        Map<FacultyYearPair, List<Student>> result = new HashMap<>();

        for (Student student : students) {
            FacultyYearPair key = new FacultyYearPair(student.getFaculty(), student.getYear());
            if (!(result.containsKey(key))) {
                result.put(key, new ArrayList<>());
                result.get(key).add(student);
            } else {
                result.get(key).add(student);
            }
        }
        return result;
    }

    public static void addStudentToMap(Map<FacultyYearPair, List<Student>> map, Student student) {
        if (student != null) {
            FacultyYearPair key = new FacultyYearPair(student.getFaculty(), student.getYear());
            if (map.containsKey(key)) {
                map.get(key).add(student);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(student);
            }
        } else {
            System.out.println("Not possible to put a Student with no info in my precious map");
        }
    }

    public static void removeStudentFromMap(Map<FacultyYearPair, List<Student>> map, String name, String faculty, int year) {
        FacultyYearPair key = new FacultyYearPair(faculty, year);
        map.get(key).remove(new Student(name, faculty, year));
    }

    public static void printAllStudentsInfo(Map<FacultyYearPair, List<Student>> map) {
        int count = 1;
        for (var entry : map.entrySet()) {
            System.out.printf("%d. Faculty: %s, Year: %d. List of Students: %s%n",
                    count,
                    entry.getKey().getFaculty(),
                    entry.getKey().getYear(),
                    entry.getValue().toString());
            count++;
        }
    }

    public static void printGroupedStudentsInfo(Map<FacultyYearPair, List<Student>> map, String faculty, int year) {
        FacultyYearPair key = new FacultyYearPair(faculty, year);
        System.out.printf("Faculty: %s, year: %d. Students: %s",
                faculty,
                year,
                map.get(key).toString());
    }
}