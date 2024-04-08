package faang.school.godbless.BJS2_4959;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Student john = new Student("John", "engineer", 1);
        Student aik = new Student("Aik", "engineer", 1);
        Student marie = new Student("John", "economy", 2);
        Student eric = new Student("eric", "economy", 2);
        Student fill = new Student("fill", "economy", 3);
        Student herc = new Student("herc", "economy", 3);
        Student mike = new Student("mike", "transport", 3);
        Student stan = new Student("Stan", "transport", 2);

        students.add(john);
        students.add(aik);
        students.add(marie);
        students.add(eric);
        students.add(fill);
        students.add(herc);
        students.add(mike);
        students.add(stan);

        System.out.println("группируем студентов");
        Map<Map<String, Integer>, Set<Student>> newStudents = Student.addStudentsByGroups(students);
        Student.printAllStudents(newStudents);

        Student tiler = new Student("tiler", "transport", 2);
        System.out.println("добавляем нового студента");
        Student.addStudent(newStudents, tiler);
        Student.printAllStudents(newStudents);


        System.out.println("удаляем студента");
        Student.deleteStudent(newStudents, tiler);
        Student.printAllStudents(newStudents);

        System.out.println("выводим студентов определенного факультета и курса");
        System.out.println(Student.findStudentsByFaculty(newStudents, "economy", 3));
    }
}
