package doublecashcash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Создайте класс Student, который будет содержать поля id (ID студента) и name (имя студента).

        Создайте класс Subject, который будет содержать поля id (ID предмета) и name (название предмета).

        В классе Main, создайте две HashMap: Первая HashMap с ключом типа Student и значением типа Map<Subject, Integer>
(список предметов и оценок студента по каждому предмету); Вторая HashMap с ключом типа Subject и значением типа List<Student>
(список студентов, изучающих данный предмет).*/

/*Реализуйте методы для следующих действий: добавление нового студента и его предметов с оценками; добавление нового
предмета для существующего студента с оценкой; удаление студента и его предметов с оценками; вывод списка всех студентов
и их оценок по предметам.

Реализуйте методы для работы со второй HashMap: добавление нового предмета и списка студентов, изучающих его; добавление
студента к существующему предмету; удаление студента из предмета; вывод списка всех предметов и студентов, изучающих их.
данных и требованиями к производительности.*/

public class Main {

    Map<Student, Map<Subject, Integer>> studentGradesSubjects = new HashMap<>();
    Map<Subject, List<Student>> studentsOnSubject = new HashMap<>();

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> subjectsWithGrades) {
        studentGradesSubjects.put(student, subjectsWithGrades);
        System.out.println(studentGradesSubjects);
    }

    public void addSubject(Map<Subject, Integer> subjectsWithGrades, Student student) {
        if (studentGradesSubjects.containsKey(student)) {
            Map<Subject, Integer> subjects = studentGradesSubjects.get(student);
            subjects.putAll(subjectsWithGrades);
        }
        System.out.println(studentGradesSubjects);
    }

    public static void deleteStudentWithSubjectsAndGrades(Map<Student, Map<Subject, Integer>> studentGradesSubjects,
                                                          Student student) {
        studentGradesSubjects.remove(student);
        System.out.println(studentGradesSubjects);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        Student student = new Student(1, "Vova");
        Student student2 = new Student(2, "Max");
        Subject subject = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Info");
        Subject subject3 = new Subject(3, "Physic");
        Subject subject4 = new Subject(4, "History");
        Map<Subject, Integer> subjectsWithGrades = new HashMap<>();
        Map<Student, Map<Subject, Integer>> studentGradesSubjects = new HashMap<>();

        System.out.println("*** Adding students with subjects and grades ***");
        main.addStudentWithSubjectsAndGrades(student, subjectsWithGrades);

        System.out.println();
        System.out.println("*** Adding subject and grade for student ***");
//        main.addSubject();

        System.out.println();
        System.out.println("*** Deleting specific student ***");

    }
}
