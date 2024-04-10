package faang.school.godbless.hashMap.first;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    private final static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        add(new Student("Vadim", "IT", 1));
        add(new Student("Igor", "History", 4));
        add(new Student("Dmitry", "IT", 1));
        add(new Student("Elena", "Philological", 2));
        add(new Student("Sergey", "History", 3));
        add(new Student("Petr", "IT", 3));
        add(new Student("Vladimir", "Philological", 4));
        delete("Elena", "Philological", 2);
        distributedStudentToString(distributedStudents(students));
    }

    public static HashMap<String, List<Student>> distributedStudents(List<Student> students) {
        HashMap<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            if (groupedStudents.containsKey(student.getFaculty() + " " + student.getYear())) {
                groupedStudents.get(student.getFaculty() + " " + student.getYear()).add(student);
            } else {
                groupedStudents.put(student.getFaculty() + " " + student.getYear(), new ArrayList<>(Arrays.asList(student)));
            }
        }
        return groupedStudents;
    }

    public static void distributedStudentToString(HashMap<String, List<Student>> groupedStudent) {
        for () {

        }
    }

    public static void add(Student student) {
        students.add(student);
    }

    public static void delete(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (students.contains(student)) {
            students.remove(student);
        }
    }
}