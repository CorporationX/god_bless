import ch.qos.logback.core.joran.sanity.Pair;
import faang.school.godbless.task8.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static String makeKey(String faculty, Integer year) {
        return faculty + " " + year;
    }
    public static Map<String, List<Student>> makeMap(List<Student> students) {
        Map<String, List<Student>> result = new HashMap<>();
        for (Student student: students) {
            String studentKey = makeKey(student.getFaculty(), student.getYear());
            result.computeIfAbsent(studentKey, k -> new ArrayList<>()).add(student);
        }
        return result;
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, Integer year) {
        students.remove(new Student(name, faculty, year));
    }

    public static List<Student> findStudents(Map<String, List<Student>> students, String faculty, Integer year) {
        return students.get(makeKey(faculty, year));
    }

    public static void allStudentsInfo(Map<String, List<Student>> students) {
       students.forEach(
               (key, value) -> System.out.println("Key - " + key + " Value - " + value)
        );
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Biba", "Grifindor", 2012));
        students.add(new Student("Boba", "Grifindor", 2012));
        students.add(new Student("Beba", "Grifindor", 2013));
        addStudent(students, (new Student("Buba", "Pufenduy", 2013)));
        removeStudent(students, "Beba", "Grifindor", 2013);
        Map<String, List<Student>> studentsMap = makeMap(students);
        findStudents(studentsMap,"Grifindor", 2012);
        allStudentsInfo(studentsMap);
    }
}