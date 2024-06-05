package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex", "IT", 1));
        students.add(new Student("Sanches", "Psychology", 3));
        students.add(new Student("Rysbek", "IT", 1));
        students.add(new Student("Beibarys", "International relations", 2));
        students.add(new Student("Azhar", "Math", 4));
        students.add(new Student("Aruzhan", "Art", 2));
        students.add(new Student("Rauan", "Art", 2));
        students.add(new Student("Ali", "Math", 4));

        Map<FacultyAndYear, List<Student>> facultyAndYearStudents = studentsByFacultyAndYear(students);
        addStudent(facultyAndYearStudents, new Student("Katya", "Physics", 5));
        addStudent(facultyAndYearStudents, new Student("Tomiris", "Art", 2));
        deleteStudent(facultyAndYearStudents, "Tomiris", "Art", 2);
        printStudentsByFacultyAndYear(facultyAndYearStudents);
    }

    public static Map<FacultyAndYear, List<Student>> studentsByFacultyAndYear(List<Student> students) {
        Objects.requireNonNull(students);
        Map<FacultyAndYear, List<Student>> result = new HashMap<>();

        for (Student student : students) {
            FacultyAndYear current = new FacultyAndYear(student.getFaculty(), student.getYear());
            if (!result.containsKey(current)) {
                result.put(current, new ArrayList<>());
                result.get(current).add(student);
            } else {
                result.get(current).add(student);
            }
        }
        return result;
    }

    public static void printStudentsByFacultyAndYear(Map<FacultyAndYear, List<Student>> facultyAndYearListMap) {
        Objects.requireNonNull(facultyAndYearListMap);

        for (Map.Entry<FacultyAndYear, List<Student>> entry : facultyAndYearListMap.entrySet()) {
            System.out.printf("Faculty: %s, Year: %s {%s}\n", entry.getKey().getFaculty(), entry.getKey().getYear(), entry.getValue());
        }

    }

    public static void addStudent(Map<FacultyAndYear, List<Student>> facultyAndYearMap, Student student) {
        Objects.requireNonNull(facultyAndYearMap);
        FacultyAndYear studentParam = new FacultyAndYear(student.getFaculty(), student.getYear());

        if (facultyAndYearMap.containsKey(studentParam)) {
            facultyAndYearMap.get(studentParam).add(student);
        } else {
            facultyAndYearMap.put(studentParam, new ArrayList<>());
            facultyAndYearMap.get(studentParam).add(student);
        }
    }

    public static void deleteStudent(Map<FacultyAndYear, List<Student>> facultyAndYearMap, String name, String faculty, int year) {
        Objects.requireNonNull(facultyAndYearMap);
        Objects.requireNonNull(name);
        Objects.requireNonNull(faculty);

        FacultyAndYear pairFromParam = new FacultyAndYear(faculty, year);
        List<Student> currentList = facultyAndYearMap.get(pairFromParam);

        if (currentList != null) {
            facultyAndYearMap.get(pairFromParam).remove(new Student(name, faculty, year));
        } else {
            throw new RuntimeException(String.format("There is no key {%s, %d}", faculty, year));
        }
    }

    public static List<Student> findStudentsByFacultyAndYear(Map<FacultyAndYear, List<Student>> facultyAndYearMap, String faculty, int year) {
        Objects.requireNonNull(faculty);

        FacultyAndYear facultyAndYear = new FacultyAndYear(faculty, year);
        List<Student> result = facultyAndYearMap.get(facultyAndYear);

        if (result != null) {
            return result;
        } else {
            throw new RuntimeException(String.format("There is no key {%s, %d}", faculty, year));
        }
    }
}