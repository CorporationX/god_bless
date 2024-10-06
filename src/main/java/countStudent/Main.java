package countStudent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("Tom Riddle", "Slipperiness", 7);
        studentList.add(student1);
        studentList.add(new Student("Hermione", "Gryffindor", 3));
        studentList.add(new Student("Garry", "Gryffindor", 5));
        studentList.add(new Student("Draco", "Slipperiness", 2));
        studentList.add(new Student("Ron", "Gryffindor", 5));
        studentList.add(new Student("Luna", "Kogtevran", 5));
        studentList.add(new Student("Kreb", "Slipperiness", 2));

        StudentOrganize studentOrganize = new StudentOrganize();


        System.out.println(studentOrganize.organizeStudent(studentList));
        studentOrganize.printMap();


        System.out.println("\n");
        System.out.println(studentOrganize.addStudent(new Student("Jinny", "Gryffindor", 4)));
        studentOrganize.printMap();


        System.out.println("\n");
        studentOrganize.removeStudent("Tom Riddle", "Slipperiness", 7);
        studentOrganize.printMap();


        System.out.println("\n");
        try {
            studentOrganize.removeStudent("ss s", "sss s", 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n");
        System.out.println(studentOrganize.findAllStudent("Gryffindor", 5));
    }
}
