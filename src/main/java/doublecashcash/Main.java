package doublecashcash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Реализуйте методы для следующих действий: добавление нового студента и его предметов с оценками; добавление нового
предмета для существующего студента с оценкой; удаление студента и его предметов с оценками; вывод списка всех студентов
и их оценок по предметам.

Реализуйте методы для работы со второй HashMap: добавление нового предмета и списка студентов, изучающих его; добавление
студента к существующему предмету; удаление студента из предмета; вывод списка всех предметов и студентов, изучающих их.
данных и требованиями к производительности.*/

public class Main {

    public static void addStudentWithSubjectsAndGrades(Map<Student, Map<Subject, Integer>> studentGradesSubjects,
                                                Map<Subject, List<Student>> subjectAndGrade,
                                                Student student, Subject subject, Integer grade) {
        List<Student> students = new ArrayList<>();
        students.add(student);
        subjectAndGrade.put(subject, students);
        Map<Subject, Integer> subjectWithGrade = new HashMap<>();
        subjectWithGrade.put(subject, grade);
        studentGradesSubjects.put(student, subjectWithGrade);
        System.out.println(studentGradesSubjects);
    }

    public static void addSubject(Map<Student, Map<Subject, Integer>> studentGradesSubjects,
                           Student student, Subject subject, Integer grade) throws Exception {
        if (studentGradesSubjects.get(student) == null) {
            throw new Exception("Student not found!");
        }
        Map<Subject, Integer> newSubjectWithGrade = new HashMap<>();
        newSubjectWithGrade.put(subject, grade);
        studentGradesSubjects.put(student, newSubjectWithGrade);
        System.out.println(studentGradesSubjects);
    }

    public static void deleteStudentWithSubjectsAndGrades(Map<Student, Map<Subject, Integer>> studentGradesSubjects,
                                                   Student student) {
        studentGradesSubjects.remove(student);
        System.out.println(studentGradesSubjects);
    }

    public static void main(String[] args) throws Exception {

        Student student = new Student(1, "Vova");
        Student student2 = new Student(2, "Max");
        Subject subject = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Info");
        Subject subject3 = new Subject(3, "Physic");
        Subject subject4 = new Subject(4, "History");
        Map<Student, Map<Subject, Integer>> studentGradesSubjects = new HashMap<>();
        Map<Subject, List<Student>> studentsOnSubject = new HashMap<>();

        addStudentWithSubjectsAndGrades(studentGradesSubjects, studentsOnSubject, student, subject, 5);
        addStudentWithSubjectsAndGrades(studentGradesSubjects, studentsOnSubject, student, subject2, 4);
        addStudentWithSubjectsAndGrades(studentGradesSubjects, studentsOnSubject, student, subject3, 3);
        addStudentWithSubjectsAndGrades(studentGradesSubjects, studentsOnSubject, student2, subject3, 3);

        System.out.println("!!!!!!!!!!!!!!!");
        addSubject(studentGradesSubjects, student2, subject4, 5);

        System.out.println("!!!!!!!!!!!!!!!");
        deleteStudentWithSubjectsAndGrades(studentGradesSubjects, student2);

    }
}
