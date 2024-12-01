package school.faang.BJS232461;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class StudentRegistry {
    private static final List<Student> STUDENT_LIST = new ArrayList<>();
    private static final Set<Student> STUDENT_SET = new HashSet<>();

    {
        STUDENT_LIST.add(new Student("Olga", "Math", 2));
        STUDENT_LIST.add(new Student("Murad", "Since", 3));
        STUDENT_LIST.add(new Student("Ekaterina", "Computer Technology", 4));
    }

    public static Map<Pair<String, Integer>, List<Student>> findAndGroupByFacultyAndYear(List<Student> students) {
        Map<Pair<String, Integer>, List<Student>> studentMap = new HashMap<>();

        for (Student student : students) {
            Pair<String, Integer> key = Pair.of(student.getFaculty(), student.getYear());
            studentMap.putIfAbsent(key, new ArrayList<>());
            studentMap.get(key).add(student);
        }
        return studentMap;
    }

    public static void addStudent(Student student) {
        STUDENT_LIST.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        STUDENT_SET.remove(student);
    }

    public static void findStudent(String name, String faculty, int year) {
        Student getStudent = new Student(name, faculty, year);
        for (Student st : STUDENT_LIST) {
            if (st.equals(getStudent)) {
                System.out.println(st);
            }
        }
    }

    public static void printAllStudents() {
        for (Student student : STUDENT_LIST) {
            System.out.println(student);
        }
    }
}
