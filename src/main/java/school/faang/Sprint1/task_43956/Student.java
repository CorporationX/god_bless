package school.faang.Sprint1.task_43956;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String faculty;
    private int age;

    public Student(String name, String faculty, int age) {
        this.name = name;
        this.faculty = faculty;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<Student>> groupStudents(List<Student> students) {
        Map<Integer, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            if (!groupedStudents.containsKey(student.getAge())) {
                groupedStudents.put(student.getAge(), new ArrayList<>());
            }
            groupedStudents.get(student.getAge()).add(student);
        }
        return groupedStudents;
    }


}
