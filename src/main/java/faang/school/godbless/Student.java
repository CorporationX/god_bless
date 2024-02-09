package src.main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    String name;
    String faculty;
    int year;

    Student(String name, String faculty, int year){
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    Map<String, List<Student>> addHashmap(List<Student> studentList){
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : studentList){
            String key = student.getFaculty() + " " + student.getYear();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(student);
        }
        return map;

    }
}
