package school.faang.countAbsenteeism;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<Map.Entry<String, Integer>, List<Student>> groupStudents(List<Student> students) {
        Map<Map.Entry<String, Integer>, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            AbstractMap.SimpleEntry<String, Integer> key = new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear());
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Abzalkhan", "IT", 5);
        Student student2 = new Student("Olzhas", "Math", 2);
        Student student3 = new Student("Aida", "Biology", 3);
        Student student4 = new Student("Ruslan", "Physics", 4);
        Student student5 = new Student("Madi", "IT", 5);
    }
}
