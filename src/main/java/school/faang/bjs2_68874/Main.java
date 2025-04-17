package school.faang.bjs2_68874;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Задача "Двойной кэш-кэш"
 */
public class Main {
    private static final Subject MATH = new Subject("Математика");
    private static final Subject PHYSICS = new Subject("Физика");
    private static final Subject CHEMISTRY = new Subject("Химия");
    private static final Subject ENGLISH = new Subject("Английский язык");
    public static final Subject ASTRONOMY = new Subject("Астрономия");
    private static final Subject UNKNOWN_SUBJECT = new Subject("Неизвестный предмет");

    public static final Student PETYA = new Student("Петя");
    public static final Student DIMA = new Student("Дима");
    public static final Student SERGEY = new Student("Серёжа");
    public static final Student NIKITA = new Student("Никита");
    private static final Student UNKNOWN_STUDENT = new Student("Неизвестный студент");

    public static void main(String[] args) {
        var studentDb = new StudentDatabase();

        studentDb.addStudent(PETYA, getSubjectsWithMarks(new Subject[]{MATH, PHYSICS, ENGLISH}, new int[]{5, 5, 3}));
        studentDb.addStudent(DIMA, getSubjectsWithMarks(new Subject[]{MATH, PHYSICS, ENGLISH}, new int[]{4, 4, 4}));
        studentDb.addStudent(SERGEY, getSubjectsWithMarks(new Subject[]{MATH, CHEMISTRY, ENGLISH}, new int[]{3, 3, 5}));
        studentDb.addStudent(NIKITA, getSubjectsWithMarks(new Subject[]{PHYSICS, ENGLISH}, new int[]{5, 5}));
        studentDb.printAllStudents();
        studentDb.printAllSubjects();

        System.out.println("\nДобавили Пете химию");
        studentDb.addStudentToSubject(PETYA, CHEMISTRY);
        studentDb.printAllStudents();
        studentDb.printAllSubjects();

        System.out.println("\nУбрали у Димы английский язык");
        studentDb.removeStudentFromSubject(DIMA, ENGLISH);
        studentDb.printAllStudents();
        studentDb.printAllSubjects();

        System.out.println("\nУбрали у Димы неизвестный предмет");
        studentDb.removeStudentFromSubject(DIMA, UNKNOWN_SUBJECT);
        studentDb.printAllStudents();
        studentDb.printAllSubjects();

        System.out.println("\nОтчислили Серёжу");
        studentDb.removeStudent(SERGEY);
        studentDb.printAllStudents();
        studentDb.printAllSubjects();

        System.out.println("\nОтчисляем неизвестного студента");
        studentDb.removeStudent(UNKNOWN_STUDENT);
        studentDb.printAllStudents();
        studentDb.printAllSubjects();

        System.out.println("\nДобавили новый предмет (Астрономия) и добавили его Диме, Сереже (отчислен) и Никите");
        studentDb.addSubject(ASTRONOMY, new ArrayList<>(List.of(DIMA, SERGEY, NIKITA)));
        studentDb.printAllStudents();
        studentDb.printAllSubjects();
    }

    public static Map<Subject, Integer> getSubjectsWithMarks(Subject[] subjects, int[] marks) {
        var subjectsWithMarks = new HashMap<Subject, Integer>();

        for (int i = 0; i < subjects.length; i++) {
            subjectsWithMarks.put(subjects[i], marks[i]);
        }

        return subjectsWithMarks;
    }
}
