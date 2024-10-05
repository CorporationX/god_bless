package dima.evseenko.absenteeism;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.addStudents(getStudents());
        studentService.addStudent(new Student("Kirill", Faculty.IT, 1));
        studentService.printStudents();

        System.out.println(studentService.findStudents(Faculty.PHYSICS, 3));

        studentService.deleteStudent("Dima", Faculty.IT, 1);
        studentService.deleteStudent(new Student("Polina", Faculty.PHYSICS, 3));
        studentService.printStudents();

        System.out.println(studentService.findStudents(new FacultyYearKeyPair(Faculty.PHYSICS, 3)));
    }

    private static List<Student> getStudents() {
        return List.of(
                new Student("Dima", Faculty.IT, 1),
                new Student("Vasya", Faculty.IT, 2),
                new Student("Kolya", Faculty.MATH, 1),
                new Student("Sasha", Faculty.PHYSICS, 2),
                new Student("Masha", Faculty.MATH, 1),
                new Student("Polina", Faculty.PHYSICS, 3),
                new Student("Danil", Faculty.IT, 1)
        );
    }
}
