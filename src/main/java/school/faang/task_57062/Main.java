package school.faang.task_57062;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final StudentDatabase db = new StudentDatabase();

        final Student anna = new Student("Анна");
        final Student vova = new Student("Вова");

        Subject math = new Subject("Математика");
        Subject history = new Subject("История");
        Subject biology = new Subject("Биология");

        Map<Subject, Integer> annaSubjects = new HashMap<>();
        annaSubjects.put(math, 90);
        annaSubjects.put(history, 85);
        annaSubjects.put(biology, 80);

        Map<Subject, Integer> vovaSubjects = new HashMap<>();
        vovaSubjects.put(math, 75);
        vovaSubjects.put(history, 83);
        vovaSubjects.put(biology, 91);

        db.addStudent(anna, annaSubjects);
        db.addStudent(vova, vovaSubjects);

        db.printAllStudents();

        db.addNewSubjectForStudent(vova, new Subject("Физика"), 80);
        db.printAllStudents();

        db.removeStudentAndHisSubject(vova);
        db.printAllStudents();
    }
}
