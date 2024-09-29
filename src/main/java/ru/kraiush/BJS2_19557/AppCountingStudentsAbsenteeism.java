package ru.kraiush.BJS2_19557;

import java.util.*;

public class AppCountingStudentsAbsenteeism {

    public static void main(String[] args) {

        List<Student> students = Student.getStudens();

        Map<CompositeKey, List<Student>> mapStudents = new HashMap<>();

        for (Student student : students) {
            CompositeKey key = new CompositeKey(student.getFaculty(), student.getCourse());
            mapStudents.computeIfAbsent(key, v -> new ArrayList<>()).add(student);
        }
        System.out.println("\n\nstudents grouping by <faculty> and <course>");
        mapStudents.forEach((K, V) -> System.out.println("key: " + K + " student: " + V));

        Set<Student> res = Student.findStudentsByFacultyAndCourse(students, "automatic & electronic", 2017);
        System.out.println("\n students found by <faculty> and <course>:\n " + res);

        System.out.println("\n add a new student");
        students.add(new Student("Karrambe", "author", 79));
        System.out.println("\n size before remove a student: " + students.size());

        Student.removeStudent(students, "Lulu", "automatic & electronic", 2017);
        System.out.println(" Size after remove a student: " + students.size());


    }
}