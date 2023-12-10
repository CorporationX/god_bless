package faang.school.godbless.counting_absenteeism;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Main {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Вася", "Факультет1", 2),
                new Student("Петя", "Факультет2", 1),
                new Student("Сеня", "Факультет1", 2),
                new Student("Коля", "Факультет2", 1));


        //Student.removeStudent(students,"Коля","Факультет2",1);
        Student.infoGroupedStudents(Main.sortStudents(students));
        System.out.println(Student.searchAllStudentsGroup(students, "Факультет2", 1));
    }

    public static Map<Course, List<Student>> sortStudents(List<Student> students) {
        Map<Course, List<Student>> classmates = new HashMap<>();
        for (Student student : students) {
            Course course = new Course(student.getFaculty(), student.getYear());
            classmates.putIfAbsent(course, new ArrayList<>());
            classmates.get(course).add(student);
        }
        return classmates;
    }


}


