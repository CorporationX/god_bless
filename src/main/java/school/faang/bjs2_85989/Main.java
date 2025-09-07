package school.faang.bjs2_85989;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {

        StudentDatabase database = new StudentDatabase();

        Student student1 = new Student("Иван Иванов");
        Student student2 = new Student("Петр Петров");
        Student student3 = new Student("Мария Сидорова");

        // Создаем предметы
        Subject math = new Subject("Математика");
        Subject physics = new Subject("Физика");
        Subject chemistry = new Subject("Химия");

        System.out.println("Добавление студентов с предметами");
        Map<Subject, Integer> subjects1 = new HashMap<>();
        subjects1.put(math, 5);
        subjects1.put(physics, 4);
        database.addStudent(student1, subjects1);

        Map<Subject, Integer> subjects2 = new HashMap<>();
        subjects2.put(math, 3);
        subjects2.put(chemistry, 5);
        database.addStudent(student2, subjects2);

        System.out.println("Студентов: " + database.getAllStudents().size());
        System.out.println("Предметов: " + database.getAllSubjects().size());

        System.out.println("\nДобавление предмета студенту");
        database.addSubject(student1, chemistry, 4);
        System.out.println("Предметов у студента 1: " + database.getStudentSubjects(student1).size());

        System.out.println("\nДобавление предмета со студентами");
        Map<Student, Integer> bioStudents = new HashMap<>();
        bioStudents.put(student1, 4);
        bioStudents.put(student3, 5);
        Subject biology = new Subject("Биология");
        database.addSubjectWithStudents(biology, bioStudents);
        System.out.println("Студентов у биологии: " + database.getSubjectStudents(biology).size());

        System.out.println("\nДобавление студента к предмету");
        database.addStudentToSubject(student2, biology, 3);
        System.out.println("Студентов у биологии: " + database.getSubjectStudents(biology).size());

        System.out.println("\nУдаление студента из предмета");
        database.removeStudentFromSubject(student1, physics);
        System.out.println("Предметов у студента 1: " + database.getStudentSubjects(student1).size());

        System.out.println("\nУдаление студента полностью");
        database.removeStudentAndSubjects(student2);
        System.out.println("Студентов в базе: " + database.getAllStudents().size());

        System.out.println("\nВывод студентов с оценками");
        database.printAllStudentsWithGrades();

        System.out.println("\nВывод предметов со студентами");
        database.printAllSubjectsWithStudents();

        System.out.println("\nОбработка ошибок");
        try {
            database.addStudent(null, new HashMap<>());
        } catch (IllegalArgumentException e) {
            log.error("Ошибка: {}", e.getMessage());
        }

        try {
            database.addSubject(student1, math, 6);
        } catch (IllegalArgumentException e) {
            log.warn("Предупреждение: {}", e.getMessage());
        }
    }
}
