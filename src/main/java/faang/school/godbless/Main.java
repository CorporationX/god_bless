package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<FacultyAndYear, List<Student>> methodResult = facultyAndYearListMap(students);
        System.out.println(methodResult);
        deleteStudentByYear(methodResult, 1);
        System.out.println(methodResult);
    }

    public static Map<FacultyAndYear, List<Student>> facultyAndYearListMap(List<Student> students) {
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

    public static void deleteStudentByName(Map<FacultyAndYear, List<Student>> students, String name) {
        for (Map.Entry<FacultyAndYear, List<Student>> facultyAndYearEntry : students.entrySet()) {
            for (Student studentFromEntryKey : facultyAndYearEntry.getValue()) {
                if (studentFromEntryKey.getName().equals(name)) {
                    facultyAndYearEntry.getValue().remove(studentFromEntryKey);
                }
            }
        }
    }

    public static void deleteStudentByFaculty(Map<FacultyAndYear, List<Student>> students, String faculty) {
        for (Map.Entry<FacultyAndYear, List<Student>> facultyAndYearEntry : students.entrySet()) {
            for (Student studentFromEntryKey : facultyAndYearEntry.getValue()) {
                if (studentFromEntryKey.getFaculty().equals(faculty)) {
                    facultyAndYearEntry.getValue().remove(studentFromEntryKey);
                }
            }
        }
    }

    public static void deleteStudentByYear(Map<FacultyAndYear, List<Student>> students, int year) {
        for (Map.Entry<FacultyAndYear, List<Student>> facultyAndYearEntry : students.entrySet()) {
            for (Student studentFromEntryKey : facultyAndYearEntry.getValue()) {
                if (studentFromEntryKey.getYear() == year) {
                    facultyAndYearEntry.getValue().remove(studentFromEntryKey);
                }
            }
        }
    }
}