package university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> students = new LinkedList<>();

    public static void main(String[] args) {
        students.add(new Student("Ivan", "Math", 2));
        students.add(new Student("Vlad", "Pedagogical", 1));
        students.add(new Student("Irina", "Medical", 4));
        students.add(new Student("Anna", "Pedagogical", 1));
        students.add(new Student("Igor", "Polytechnic", 3));
        students.add(new Student("Oleg", "Polytechnic", 2));

        removeStudent("Oleg", "Polytechnic", 2);
        addStudent(new Student("Ivan", "Pedagogical", 3));

        System.out.println(findStudents("Polytechnic", 3));
        System.out.println(findStudents("Pedagogical", 1));
        System.out.println(findStudents("Pedagogical", 5));
        System.out.println(transformListToMap(students));
    }

    static List<Student> findStudents(String faculty, int year) {
        List<Student> findStudents = new LinkedList<>();

        for (Student student: students) {
            if ( student.getFaculty().equals(faculty) && student.getYear() == year) {
                findStudents.add(student);
            }
        }

        return findStudents;
    }

    static void addStudent(Student student) {
        students.add(student);
    }

    static void removeStudent(String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name)
                && student.getFaculty().equals(faculty)
                && student.getYear() == year);
    }

    static Map<String, List<Student>> transformListToMap(List<Student> students) {
        Map<String, List<Student>> grouppedStudentsMap = new HashMap<>();
        for (Student student: students) {
            String key = String.format("%s_%d", student.getFaculty(), student.getYear());

            if (!grouppedStudentsMap.containsKey(key)) {
                grouppedStudentsMap.put(key, new ArrayList<>());
            }

            grouppedStudentsMap.get(key).add(student);
        }

        return grouppedStudentsMap;
    }
}
