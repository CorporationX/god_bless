package ru.kraiush.BJS2_19934;

import ru.kraiush.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App_Counting_absenteeism {

    public static void main(String[] args) {

        List<Student> students = Student.getStudens();

        Map<CompositeKey, List<Student>> map = new HashMap<>();

        for (Student student : students) {
            CompositeKey key = new CompositeKey(student.getFaculty(), student.getCourse());
            List<Student> st = map.get(key);
            if (map.get(key) == null) {
                map.computeIfAbsent(key, v -> new ArrayList<>()).add(student);
            } else {
                st.add(student);
                map.put(key, st);
            }
        }
        map.forEach((K,V) -> System.out.println("key: "+ K + " student: " + V));
    }
}
