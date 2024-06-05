package faang.school.godbless.counttruancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<FacultyYear, List<Student>> studentGroups;
    private static List<Student> students = new ArrayList<>();
    private static Map<Student, List<Integer>> indexStudents = new HashMap<>();

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

        studentGroups = groupStudents(students);
        System.out.println(students);

        removeStudent(new Student("Петя", "ЛФИ", 3));
        System.out.println(students);

        System.out.println(getStudents(new FacultyYear("ФРТК", 1)));
        showFacultyYearStudent();
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

        // if (!indexStudents.containsKey(student)) {
        //    indexStudents.put(student, new LinkedList<>(Arrays.asList(students.size())));
        // } else {
        //     indexStudents.get(student).add(students.size());
        // }
    }

    public static void removeStudent(Student student) {
        students.remove(student);
        // List<Integer> indexies = indexStudents.get(student);
        // for(int index : indexies) {
        //     students.remove(index);
        // }
        //indexStudents.remove(student);
    }

    public static List<Student> getStudents(FacultyYear facultyYear) {
        return studentGroups.get(facultyYear);
    }

    public static void showFacultyYearStudent() {
        for (Map.Entry<FacultyYear, List<Student>> entry : studentGroups.entrySet()) {
            System.out.println("Факультет-курс: " + entry.getKey() + " студенты: " + entry.getValue());
        }
    }
}
