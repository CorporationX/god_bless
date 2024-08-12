package progul;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public static Map<String, List<Student>> mapStudent(List<Student> studentList) {
        Map<String, List<Student>> nameByStudent= new HashMap<>();
        for (Student student : studentList) {
          Student.realiseCheck(nameByStudent, student);
        }
        return nameByStudent;
    }

    public static void outputMap(Map<String, List<Student>> nameByStudent) {
        for (Map.Entry<String, List<Student>> pair : nameByStudent.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    public static void addStudent(Map<String, List<Student>> nameByStudent, Student student) {
       Student.realiseCheck(nameByStudent, student);
    }

    public static void realiseCheck(Map<String, List<Student>> nameByStudent, Student student) {
        String key = student.getFaculty() + " - " + student.getYear();
        if (!nameByStudent.containsKey(key)) {
            List<Student> mapList = new ArrayList<>();
            mapList.add(student);
            nameByStudent.put(key, mapList);
        }
        else {
            nameByStudent.get(key).add(student);
        }
    }

    public static void removeStudent(Map<String, List<Student>> nameByStudent, String name, String faculty, int year) {
        String key = faculty + " - " + year;
        nameByStudent.get(key).remove(new Student(name, faculty, year));
    }

    public static void searchStudent(Map<String, List<Student>> nameByStudent, String faculty, int year) {
        String key = faculty + " - " + year;
        System.out.println(nameByStudent.get(key));
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
