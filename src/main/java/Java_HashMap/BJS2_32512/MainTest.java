package Java_HashMap.BJS2_32512;

import Java_HashMap.BJS2_32512.Exception.StudentAlreadyExistsException;
import Java_HashMap.BJS2_32512.Exception.StudentNotFoundException;
import Java_HashMap.BJS2_32512.Manager.StudentManager;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

    public static void main(String[] args) {
        Student studentOne = new Student(15, "Боб");
        Student studentTwo = new Student(34, "Алекс");
        Student studentThree = new Student(11, "Мартин");


        Subject math = new Subject(33, "Math");
        Subject chemistry = new Subject(34, "Chemistry");


        Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();

        try {
            StudentManager.addNewStudent(studentGrades, studentOne, Map.of(math, 111));
            System.out.println("Студент добавлен - " + studentOne.getName());

            StudentManager.addNewStudent(studentGrades, studentTwo, Map.of(chemistry, 34));
        } catch (StudentAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            StudentManager.removeStudent(studentGrades, studentOne);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Тестируем добавление нового студента
            StudentManager.addNewStudent(studentGrades, studentTwo, Map.of(chemistry, 90));
            System.out.println("Студент добавлен: " + studentTwo.getName());

            // Тестируем удаление несуществующего студента
            StudentManager.removeStudent(studentGrades, studentThree);
        } catch (StudentNotFoundException | StudentAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        // Выводим всех студентов и их оценки
        StudentManager.printAllStudents(studentGrades);
    }
}