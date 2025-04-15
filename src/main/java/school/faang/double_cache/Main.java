package school.faang.double_cache;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {

        log.info("Test1: 'Добавление студентов с предметами'");
        Map<Subject, Integer> subjects1 = new HashMap<>();
        Subject math = new Subject("Математика");
        Subject physics = new Subject("Физика");
        Subject chemistry = new Subject("Химия");
        subjects1.put(math, 5);
        subjects1.put(physics, 4);
        subjects1.put(chemistry, 3);
        StudentDatabase database = new StudentDatabase();
        Student student1 = new Student("Иван Иванов", "1001");
        Student student2 = new Student("Петр Петров", "1002");
        Student student3 = new Student("Мария Сидорова", "1003");

        database.addStudentWithSubjectsAndGrades(student1, subjects1);
        database.addStudentWithSubjectsAndGrades(student2, subjects1);
        database.addStudentWithSubjectsAndGrades(student3, subjects1);

        Map<Subject, Integer> subjects2 = new HashMap<>();
        subjects2.put(math, 3);
        subjects2.put(chemistry, 5);
        database.addStudentWithSubjectsAndGrades(student2, subjects2);

        log.info(database.getAllStudentsWithGrades());

        log.info("Test2: 'Добавление предмета студенту'");
        database.addSubjectForStudent(student1, chemistry, 4);
        log.info("После добавления химии Ивану:");
        log.info(database.getAllStudentsWithGrades());

        log.info("Test3: 'Добавление предмета с группой студентов'");
        Subject biology = new Subject("Биология");
        database.addSubjectWithStudents(biology, List.of(student1, student3));
        log.info("После добавления биологии:");
        database.printAllSubjectsWithStudents();

        log.info("Test4: 'Добавление студента к предмету'");
        database.addStudentToSubject(student2, biology);
        log.info("После добавления Петра к биологии:");
        database.printAllSubjectsWithStudents();

        log.info("Test5: 'Удаление студента из предмета'");
        database.removeStudentFromSubject(student1, biology);
        log.info("После удаления Ивана из биологии:");
        database.printAllSubjectsWithStudents();

        log.info("Test6: 'Удаление студента'");
        database.removeStudent(student2);
        log.info("После удаления Петра:");
        log.info(database.getAllStudentsWithGrades());
        database.printAllSubjectsWithStudents();

        log.info("Test7: 'Обработка ошибок'");
        try {
            database.addStudentWithSubjectsAndGrades(null, new HashMap<>());
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            database.addSubjectForStudent(student1, null, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            database.removeStudent(new Student("Несуществующий", "9999"));
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
    }
}
