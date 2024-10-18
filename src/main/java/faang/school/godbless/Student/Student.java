package faang.school.godbless.Student;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class Student {
    private String name;
    private String faculty;
    private int year;
    private Map<String, List<Student>> mapStudent = new HashMap<>();

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public Map<String, List<Student>> createMap(List<Student> studentsList) {
        String key;
        Student student;
        for (int i = 0; i < studentsList.size(); i++) {
            student = studentsList.get(i);
            key = student.faculty + "-" + student.year;
            if (mapStudent.containsKey(key)) {
                mapStudent.get(key).add(student);
            } else {
                mapStudent.put(key, new ArrayList<>(Arrays.asList(student)));
            }
        }
        return mapStudent;
    }

    public Map<String, List<Student>> addStudent(Student student) {
        String key;
        key = student.faculty + "-" + student.year;
        if (mapStudent.containsKey(key)) {
            mapStudent.get(key).add(student);
        } else {
            mapStudent.put(key, new ArrayList<>(Arrays.asList(student)));
        }
        return mapStudent;
    }

    public Map<String, List<Student>> removeStudent(String studentName) {
        String key;
        Set<String> d = mapStudent.keySet();
        List<Student> studentList;
        for (String i : d) {
            studentList = mapStudent.get(i);
            key = studentList.get(0).faculty + "-" + studentList.get(0).year;
            for (int j = 0; j < mapStudent.get(i).size(); j++) {
                if (mapStudent.get(i).get(j).name.equals(studentName)) {
                    mapStudent.remove(key, mapStudent.get(key).remove(studentList.get(j)));
                    if (mapStudent.get(i).size() == 0) {
                        mapStudent.remove(key);
                    }
                    return mapStudent;
                }
            }
        }
        return mapStudent;
    }

    public Map<String, List<Student>> deleteByFacultyAndCourse(String facultyAndCourseKey) {
        if (mapStudent.containsKey(facultyAndCourseKey)) {
            mapStudent.remove(facultyAndCourseKey);
        }
        return mapStudent;
    }

    public void lookForStudents(String facultyAndCourseKey) {
        if (mapStudent.containsKey(facultyAndCourseKey)) {
            System.out.print(facultyAndCourseKey + "\t= ");
            for (int j = 0; j < mapStudent.get(facultyAndCourseKey).size(); j++) {
                System.out.print(mapStudent.get(facultyAndCourseKey).get(j).name + ", ");
            }
        }
    }

    public static void printMap(Map<String, List<Student>> map) {
        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
            System.out.println("\n\t\t\t\tфакультет и курс - " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("имя= " + student.getName() + " факультет= " + student.getFaculty() + " курс= " + student.getYear());
            }
        }
    }
}