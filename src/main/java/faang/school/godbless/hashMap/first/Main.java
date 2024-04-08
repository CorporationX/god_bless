package faang.school.godbless.hashMap.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        add(new Student("Vadim", "IT", 1));
        add(new Student("Igor", "History", 4));
        add(new Student("Dmitry", "IT", 1));
        add(new Student("Elena", "Philological", 2));
        add(new Student("Sergey", "History", 3));
        add(new Student("Petr", "IT", 3));
        add(new Student("Vladimir", "Philological", 4));
        delete("Elena", "Philological", 2);
    }
    public static HashMap<String, Student> distributedStudents(List<Student> students) {

    }

    public static void add(Student student) {
        students.add(student);
    }

    public static void delete(String name, String faculty, int year) {
        for(Student student : students) {
            if(student.getName().equals(name)
            && student.getFaculty().equals(faculty)
            && student.getYear() == year) {
                students.remove(student);
            }
        }
    }
}
