package faang.school.godbless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }
    @Override
    public String toString() {
        return faculty + " " + name + " " + year;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;

    }
    public String getFaculty() {
        return faculty;
    }

    public static void addStudent(List<Student> students, Student newStudent) {
        students.add(newStudent);
    }

    public static void removeStudent(List<Student> students, Student removeStudent) {
        students.remove(removeStudent);
    }

    public static List<Student> getStudents(List<Student> students, String faculty, int year) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                studentList.add(student);
            } else {
                continue;
            }
        }
        return studentList;
    }

    public static Map<String, List<Student>> StudentsHash(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " " + student.getYear();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(student);
        }
        return map;
    }
}
