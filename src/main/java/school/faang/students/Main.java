package school.faang.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static List<Student> listStudents = new ArrayList<>();

    public static void main(String[] args) {

        listStudents.add(new Student("Alex", "MehMat", 2011));
        listStudents.add(new Student("Olya", "Literature", 1999));
        listStudents.add(new Student("Anna", "Literature", 1999));
        listStudents.add(new Student("Kirill", "MehMat", 1999));
        listStudents.add(new Student("Egor", "MehMat", 1999));
        listStudents.add(new Student("Anton", "MehMat", 2002));

        printStudentsByCourseAndFaculty();

        System.out.println(findStudentsByCourseAndFaculty("MehMat", 1999));

        if (addStudent(new Student("Egor", "Literature", 1999))) {
            System.out.println("Students added");
        } else {
            System.out.println("Students was not add");
        }
    }

    public static Map<StudentKey, List<Student>> listToHashMap(List<Student> list) {
        Map<StudentKey, List<Student>> stMap = new HashMap<>();
        list.forEach(student ->
                stMap.computeIfAbsent(
                        new StudentKey(student.getFaculty(), student.getYear()),
                        st -> new ArrayList<>()
                ).add(student));
        return stMap;
    }

    public static Boolean addStudent(Student student) {
        return listStudents.add(student);
    }

    public static Boolean removeStudent(String name, String faculty, Integer year) {
        Student removeStudent = new Student(name, faculty, year);
        return listStudents.remove(removeStudent);
    }

    public static List<Student> findStudentsByCourseAndFaculty(String faculty, Integer year) {
        return listToHashMap(listStudents).get(new StudentKey(faculty, year));
    }

    public static void printStudentsByCourseAndFaculty() {
        listToHashMap(listStudents)
                .forEach((key, value) -> {
                    System.out.println("List of students for faculty: "
                            + key.getFaculty() + " and course: " + key.getYear());
                    value.forEach(System.out::println);
                });
    }
}
