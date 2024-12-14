package school.faang.BJS2_32579;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) &&
                student.getFaculty().equals(faculty) &&
                student.getYear() == year);
    }

    public List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }

    public Map<String, List<Student>> groupStudentsByFacultyAndYear() {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    public void printGroupedStudents() {
        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear();
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("Faculty-Year: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
        }
    }

    public static void main(String[] args) {
        Main universityAdmin = new Main();

        universityAdmin.addStudent(new Student("Alice", "Engineering", 1));
        universityAdmin.addStudent(new Student("Bob", "Engineering", 2));
        universityAdmin.addStudent(new Student("Charlie", "Science", 1));
        universityAdmin.addStudent(new Student("David", "Science", 2));

        System.out.println("Students in Engineering, Year 1: " +
                universityAdmin.findStudentsByFacultyAndYear("Engineering", 1));

        universityAdmin.removeStudent("Alice", "Engineering", 1);

        universityAdmin.printGroupedStudents();
    }
}
