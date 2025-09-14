package school.faang.bjs2_86940_1_1_3_4_double_cache_cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        Subject math = new Subject("Математика");
        Subject physics = new Subject("Физика");
        Subject history = new Subject("История");
        Subject biology = new Subject("Биология");

        Student ivan = new Student("Иван");
        Student maria = new Student("Мария");
        Student petr = new Student("Пётр");
        Student olga = new Student("Ольга");

        // Добавляем студентов с оценками (у Иванa и Марии уже есть предметы)
        Map<Subject, Integer> ivanInfo = new HashMap<>();
        ivanInfo.put(math, 5);
        ivanInfo.put(physics, 4);
        db.addNewStudentInfo(ivan, ivanInfo);

        Map<Subject, Integer> mariaInfo = new HashMap<>();
        mariaInfo.put(math, 3);
        mariaInfo.put(history, 5);
        db.addNewStudentInfo(maria, mariaInfo);

        // Добавляем новый предмет "Биология" и сразу список его студентов
        List<Student> bioStudents = new ArrayList<>(Arrays.asList(petr, olga));
        db.addNewSubjectWithStudents(biology, bioStudents);

        // Добавляем Петра на физику
        db.addStudentToSubject(petr, physics);

        // Добавляем Ивану историю
        db.addSubjectForStudent(ivan, history, 5);

        System.out.println("=== Студенты с оценками ===");
        db.printStudentsWithGrades();
        System.out.println("\n=== Предметы и студенты ===");
        db.printSubjectsAndStudents();

        // Удаляем Петра с физики
        System.out.println("\nУдаляем Петра с физики...");
        db.removeStudentFromSubject(petr, physics);
        db.printSubjectsAndStudents();

        // Полностью удаляем Марию из базы
        System.out.println("\nПолностью удаляем Марию...");
        db.removeStudent(maria);
        db.printStudentsWithGrades();
        db.printSubjectsAndStudents();
    }
}
