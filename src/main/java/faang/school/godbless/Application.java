package faang.school.godbless;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Application {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Hermione Granger", "Gryffindor", 1);
        Student student2 = new Student("Harry Pooter", "Gryffindor", 1);
        Student student3 = new Student("Ron Weasley", "Gryffindor", 1);

        Student student4 = new Student("Draco Malfoy", "Slytherin", 1);

        Student.addStudent(students, student1);
        Student.addStudent(students, student2);
        Student.addStudent(students, student3);
        Student.addStudent(students, student4);

        System.out.println("Студенты");
        System.out.println(students);


        Student.removeStudent(students, student2);

        System.out.println(students);

        List<Student> searchedStudents = Student.getStudents(students, "Slytherin", 1);
        System.out.println(searchedStudents);

        Map<FacultyYear, List<Student>> groupedStudents = Student.StudentsHash(students);
        System.out.println(groupedStudents);
    }
}