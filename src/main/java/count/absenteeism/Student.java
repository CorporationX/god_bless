package count.absenteeism;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Student {
    private String name;
    private String faculty;
    private int year;
    private String keyPair;

    public Student(String name, String faculty, int year) {
        if (name == null) {
            throw new IllegalArgumentException("Заполните имя");
        }
        if (faculty == null) {
            throw new IllegalArgumentException("Заполните факультет");
        }
        if (year == 0) {
            throw new IllegalArgumentException("Заполните курс");
        }
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public static Map<String, List<Student>> groupStudents(ArrayList<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " " + student.getYear();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(student);
        }
        return map;
    }

    public static void printAll(Map<String, List<Student>> map) {
        System.out.println("\n" + "Вывод всех студентов:");
        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
            System.out.println("Группа: " + "(" + entry.getKey() + ")" + " Cтудент: " + entry.getValue());
        }
    }

    public static void addStudent(ArrayList<Student> list, Student student) {
        list.add(student);
    }

    public static void removeStudent(ArrayList<Student> students, String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) && student.getFaculty().equals(faculty) &&
                student.getYear() == year);
        System.out.println("\n" + "Студент " + name + " удален!");
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Факультет: " + faculty + ", Курс: " + year;
    }

    public static void searchStudent(ArrayList<Student> students, String faculty, int year) {
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                System.out.println("\n" + "Студент найден: " + "\n" + student);
            }
        }
    }
}
