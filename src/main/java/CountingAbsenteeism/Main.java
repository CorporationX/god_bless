package CountingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        STUDENTS.add(new Student("Mark", "Computer Science", 3));
        STUDENTS.add(new Student("Dima", "System design", 2));
        STUDENTS.add(new Student("Roma", "Mathematics", 1));
        STUDENTS.add(new Student("Bill", "Computer Science", 3));
        STUDENTS.add(new Student("Lora", "System design", 5));

        Map<String, List<Student>> studentsGroup = groupStudents(STUDENTS);
        printInfo(studentsGroup);
        addStudent(new Student("Sasha", "System design", 2), studentsGroup);
        addStudent(new Student("Albert", "Phisica", 4), studentsGroup);
        printInfo(studentsGroup);
        removeStudent("Roma", "Mathematics", 1, studentsGroup);
        printInfo(studentsGroup);
        System.out.println(searchStudent("Computer Science", 3, studentsGroup));
    }

    private static Map<String, List<Student>> groupStudents(List<Student> students) {
        Map<String, List<Student>> facultyStudents = new HashMap<>();
        for (Student student : students) {
            String key = getFacultyAndYear(student.getFaculty(), student.getYear());
            if (!facultyStudents.containsKey(key)) {
                facultyStudents.put(key, new ArrayList<>());
            }
            facultyStudents.get(key).add(student);
        }
        return facultyStudents;
    }

    private static void addStudent(Student student, Map<String, List<Student>> students) {
        String key = getFacultyAndYear(student.getFaculty(), student.getYear());
        if (!students.containsKey(key)) {
            students.put(key, new ArrayList<>());
            STUDENTS.add(student);
        }
        students.get(key).add(student);
    }

    private static void removeStudent(String name, String faculty, int year, Map<String, List<Student>> students) {
        Student removeStudent = new Student(name, faculty, year);
        String key = getFacultyAndYear(faculty, year);
        if (students.containsKey(key)) {
            STUDENTS.remove(removeStudent);
            students.get(key).remove(removeStudent);
            students.remove(key);
            System.out.println("\nСтудент удален.");
        } else {
            System.out.println("\nТакого студента в списке нет.");
        }
    }

    private static List<Student> searchStudent(String faculty, int year, Map<String, List<Student>> students) {
        String key = getFacultyAndYear(faculty, year);
        if (students.containsKey(key)) {
            System.out.println("Студнет(ы) найден(ы): ");
            return students.get(key);
        } else {
            System.out.println("\nСтудент(ы) не найден(ы).");
            return new ArrayList<>();
        }
    }

    private static String getFacultyAndYear(String faculty, int year) {
        return faculty + ", " + year;
    }

    private static void printInfo(Map<String, List<Student>> students) {
        System.out.println("--------------------");
        for (Map.Entry<String, List<Student>> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
