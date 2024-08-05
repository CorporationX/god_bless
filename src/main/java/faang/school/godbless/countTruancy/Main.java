package faang.school.godbless.countTruancy;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<FacultyAndYear, List<Student>> GROUPED_STUDENTS = new HashMap<>();
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        STUDENTS.add(new Student("valera", "iit", 2));
        STUDENTS.add(new Student("sanya", "iit", 2));
        STUDENTS.add(new Student("gleb", "iit", 3));
        STUDENTS.add(new Student("peter", "ooo", 1));
        STUDENTS.add(new Student("misha", "iit", 4));

        groupStudents(STUDENTS);
        printGroupedStudents();
        System.out.println();

        addStudent(new Student("ilya", "iit", 4));
        printGroupedStudents();
        System.out.println();

        printStudentsByFacultyAndYear("iit", 4);
        System.out.println();

        deleteStudentByNameFacultyAndYear("ilya", "iit", 4);
        printGroupedStudents();

        STUDENTS.forEach(student -> System.out.println(student.getName()));

    }

    private static void addStudent(Student student) {
        STUDENTS.add(student);
        addStudentToGroups(student);
    }

    private static void groupStudents(List<Student> students) {
        students.forEach(student -> {
            FacultyAndYear facultyAndYear = new FacultyAndYear(student.getFaculty(), student.getYear());
            GROUPED_STUDENTS.putIfAbsent(facultyAndYear, new ArrayList<>());
            GROUPED_STUDENTS.get(facultyAndYear).add(student);
        });
    }

    private static void addStudentToGroups(Student student) {
        FacultyAndYear facultyAndYear = new FacultyAndYear(student.getFaculty(), student.getYear());
        GROUPED_STUDENTS.putIfAbsent(facultyAndYear, new ArrayList<>());
        GROUPED_STUDENTS.get(facultyAndYear).add(student);
    }

    private static void deleteStudentByNameFacultyAndYear(String name, String faculty, int year) {
        FacultyAndYear facultyAndYear = new FacultyAndYear(faculty, year);
        Student studentToDelete = new Student(name, faculty, year);
        GROUPED_STUDENTS.get(facultyAndYear).remove(studentToDelete);
        STUDENTS.remove(studentToDelete);
    }

    private static void printGroupedStudents() {
        GROUPED_STUDENTS.forEach((facultyAndYear, students) -> {
            System.out.println(facultyAndYear.faculty + " " + " " + facultyAndYear.year);
            students.forEach((student) -> {
                System.out.println(student.getName());
            });
            System.out.println("________________");
        });
    }

    private static void printStudentsByFacultyAndYear(String faculty, int year) {
        FacultyAndYear facultyAndYear = new FacultyAndYear(faculty, year);
        System.out.println(facultyAndYear.faculty + " " + facultyAndYear.year);
        GROUPED_STUDENTS.get(facultyAndYear).forEach(student -> {
            System.out.println(student.getName());
        });
    }

    @EqualsAndHashCode    // через ломбок сделал, потому что не сказано что нужно вручную переопределять
    @AllArgsConstructor
    private static class FacultyAndYear {
        String faculty;
        int year;
    }
}
