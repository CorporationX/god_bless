package ru.kraiush.BJS2_19557;

import ru.kraiush.model.Student;

import java.util.*;
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
        System.out.println("\n\nstudents grouping by <faculty> and <course>");
        map.forEach((K,V) -> System.out.println("key: "+ K + " student: " + V));

        Set<Student> res = Student.findStudentsByFacultyAndCourse(students, "automatic & electronic", 2017);
        System.out.println("\n students found by <faculty> and <course>:\n " + res);

        System.out.println("\n add a new student");
        students.add(new Student("Karrambe", "author", 79));
        System.out.println("\n size before remove a student: " + students.size());

        Student.removeStudent(students, "Lulu", "automatic & electronic", 2017);
        System.out.println(" Size after remove a student: " + students.size());


    }
}
