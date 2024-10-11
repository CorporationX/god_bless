package school.faang.countAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final List<Student> STUDENTS = new ArrayList<>();

    private static final Map<String, List<Student>> GROUPED_STUDENTS = new HashMap<>();

    public static Map<String, List<Student>> groupStudents(List<Student> students) {
        for (Student student : students) {
            String keyValue = student.getFaculty() + " " + student.getYear();
            GROUPED_STUDENTS.computeIfAbsent(keyValue, k -> new ArrayList<>()).add(student);
        }
        return GROUPED_STUDENTS;
    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public static void deleteStudent(String name, String faculty, Integer year) {
        STUDENTS.remove(new Student(name, faculty, year));
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, Integer year) {
        String keyValue = faculty + " " + year;
        for (Map.Entry<String, List<Student>> entry : GROUPED_STUDENTS.entrySet()) {
            if (entry.getKey().equals(keyValue)) {
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException("There are no students");
    }


    public static void showGroupedStudents() {
        System.out.println(GROUPED_STUDENTS);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Abzalkhan", "IT", 5);
        Student student2 = new Student("Olzhas", "Math", 2);
        Student student3 = new Student("Aida", "Math", 2);
        Student student4 = new Student("Ruslan", "Physics", 4);
        Student student5 = new Student("Madi", "IT", 5);

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        addStudent(student5);
        System.out.println(STUDENTS);
        System.out.println();

        deleteStudent("Ruslan", "Physics", 4);
        System.out.println(STUDENTS);
        System.out.println();

        groupStudents(STUDENTS);
        showGroupedStudents();
        System.out.println();

        System.out.println(findStudentsByFacultyAndYear("IT", 5));
    }
}
