package school.faang.counting.missings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, List<Student>> STUDENT_LIST_MAP = new HashMap<>();
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>(List.of(
                new Student("Peter", "chimestry", 2024),
                new Student("Jenny", "Engineering", 1),
                new Student("John", "Engineering", 2),
                new Student("Andy", "math", 1),
                new Student("Lisa", "Science", 2),
                new Student("Mark", "math", 3),
                new Student("Filin", "design", 2),
                new Student("Mary", "math", 4),
                new Student("Abdul", "management", 2),
                new Student("Sasha", "design", 2),
                new Student("Greg", "Engineering", 2),
                new Student("John", "math", 3),
                new Student("Katy", "design", 1),
                new Student("Mihael", "math", 4)
        ));
        STUDENTS.addAll(studentList);

        System.out.println(listStudentsByFacilityAndYear(studentList));
        addStudent(new Student("Misha", "design", 1));
        removeStudent("John", "math", 3);
        searchStudentByFacilityAndYear("design", 2);
        System.out.println(listStudentsByFacilityAndYear(STUDENTS));

    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
        System.out.println();
    }

    public static void removeStudent(String name, String facility, int year) {
        Student studentForRemoval = new Student(name, facility, year);
        STUDENTS.remove(studentForRemoval);
    }

    public static List<Student> searchStudentByFacilityAndYear(String facility, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : STUDENTS) {
            if (student.getFacility().equals(facility) && student.getYear() == year) {
                result.add(student);
                System.out.println("The students : " + student.getName() + " " + student.getFacility() + " " + student.getYear());
            }
        }

        return result;
    }

    public static Map<String, List<Student>> listStudentsByFacilityAndYear(List<Student> students) {

        for (Student student : students) {
            String key = student.getFacility() + " - Year " + student.getYear();
            if (!STUDENT_LIST_MAP.containsKey(key)) {
                STUDENT_LIST_MAP.putIfAbsent(key, new ArrayList<>());
            }
            STUDENT_LIST_MAP.get(key).add(student);
        }
        return STUDENT_LIST_MAP;
    }
}


