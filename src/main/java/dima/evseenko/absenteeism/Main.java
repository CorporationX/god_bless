package dima.evseenko.absenteeism;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        university.addStudents(getStudents());
        university.addStudent(new Student("Kirill", Student.Faculty.IT, 1));
        university.printStudents();

        System.out.println(university.findStudents(Student.Faculty.PHYSICS, 3));

        university.deleteStudent("Dima", Student.Faculty.IT, 1);
        university.deleteStudent(new Student("Polina", Student.Faculty.PHYSICS, 3));
        university.printStudents();

        System.out.println(university.findStudents(new Student.KeyPair(Student.Faculty.PHYSICS, 3)));
    }

    private static List<Student> getStudents() {
        return List.of(
                new Student("Dima", Student.Faculty.IT, 1),
                new Student("Vasya", Student.Faculty.IT, 2),
                new Student("Kolya", Student.Faculty.MATH, 1),
                new Student("Sasha", Student.Faculty.PHYSICS, 2),
                new Student("Masha", Student.Faculty.MATH, 1),
                new Student("Polina", Student.Faculty.PHYSICS, 3),
                new Student("Danil", Student.Faculty.IT, 1)
        );
    }
}
