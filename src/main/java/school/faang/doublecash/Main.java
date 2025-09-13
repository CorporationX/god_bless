package school.faang.doublecash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database;
        Student student1;
        Student student2;

        database = new StudentDatabase();
        student1 = new Student("Петя");
        student2 = new Student("Иван");

        Subject mathematica = new Subject("Математика");
        Subject russianLang = new Subject("Русский язык");
        Subject literature = new Subject("Литература");
        Subject informatics = new Subject("Информатика");

        Map<Subject, Integer> student1Subjects = new HashMap<>();
        student1Subjects.put(mathematica, 3);
        student1Subjects.put(russianLang, 4);
        student1Subjects.put(literature, 4);
        student1Subjects.put(informatics, 5);
        database.addStudent(student1, student1Subjects);

        Map<Subject, Integer> student2Subjects = new HashMap<>();
        student2Subjects.put(mathematica, 5);
        student2Subjects.put(russianLang, 4);
        student2Subjects.put(literature, 4);
        database.addStudent(student2, student2Subjects);

        // Добавление предметов для студентов с помощью метода addSubjectToStudent
        database.addSubjectToStudent(student1, mathematica, 4);
        database.addSubjectToStudent(student2, literature, 5);

        // Добавление нового предмета и студентов с начальной оценкой 3
        Subject history = new Subject("История");
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2));
        database.addSubject(history, students, 3);  // Устанавливаем начальную оценку 3 для всех студентов

        // Вывод всех студентов и их оценок
        System.out.println("Все студенты и их оценки:");
        database.printStudents();

        // Вывод всех предметов и студентов, изучающих их
        System.out.println("\nВсе предметы и студенты, изучающие их:");
        database.printAllSubjectsAndStudents();

        // Удаление студента
        database.removeStudent(student1);
        System.out.println("\nСписок студентов после удаления:");
        database.printStudents();

        // Удаление студента из предмета
        database.removeStudentFromSubject(student1, history);
        System.out.println("\nПосле удаления студента из предмета:");
        database.printAllSubjectsAndStudents();
    }
}