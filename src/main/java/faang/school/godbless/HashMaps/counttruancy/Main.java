package faang.school.godbless.HashMaps.counttruancy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println((students));
        addStudent(new Student("Саша", "ФРТК", 1));
        addStudent(new Student("Миша", "ФПМИ", 2));
        addStudent(new Student("Петя", "ЛФИ", 3));
        addStudent(new Student("Ваня", "ФБМФ", 4));
        addStudent(new Student("Саша2", "ФРТК", 1));
        addStudent(new Student("Миша2", "ФПМИ", 2));
        addStudent(new Student("Петя2", "ЛФИ", 3));
        addStudent(new Student("Ваня2", "ФБМФ", 4));

        Map<FacultyYear, List<Student>> studentGroups = groupStudents(students);
        System.out.println(students);

        removeStudent(new Student("Петя", "ЛФИ", 3));
        System.out.println(students);

        System.out.println(getStudents(studentGroups, new FacultyYear("ФРТК", 1)));
        showFacultyYearStudent(studentGroups);
    }

    public static Map<FacultyYear, List<Student>> groupStudents(List<Student> students) {
        Map<FacultyYear, List<Student>> facultyYearStudent = new HashMap<>();
        for (Student student: students) {
            FacultyYear facultyYear = new FacultyYear(student.faculty(), student.year());
            if (!facultyYearStudent.containsKey(facultyYear)) {
                facultyYearStudent.put(facultyYear, new ArrayList<>(List.of(student)));
            } else {
                facultyYearStudent.get(facultyYear).add(student);
            }
        }

        return facultyYearStudent;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(Student student) {
        students.remove(student);
    }

    public static List<Student> getStudents(Map<FacultyYear, List<Student>> studentGroups, FacultyYear facultyYear) {

        return studentGroups.get(facultyYear);
    }

    public static void showFacultyYearStudent(Map<FacultyYear, List<Student>> studentGroups) {
        for (Map.Entry<FacultyYear, List<Student>> entry : studentGroups.entrySet()) {
            System.out.println("Факультет-курс: " + entry.getKey() + " студенты: " + entry.getValue());
        }
    }
}
