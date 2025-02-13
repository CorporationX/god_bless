package school.faang.task57079;

import school.faang.task57079.student.Student;
import school.faang.task57079.student.StudentDatabase;
import school.faang.task57079.student.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Subject english = new Subject("Английский язык");
        Subject history = new Subject("История");

        Map<Subject, Integer> nikitaEnglish = new HashMap<>();
        nikitaEnglish.put(english, 5);
        Map<Subject, Integer> nikitaHistory = new HashMap<>();
        nikitaHistory.put(history, 3);
        Map<Subject, Integer> pavelEnglish = new HashMap<>();
        pavelEnglish.put(english, 4);

        StudentDatabase studentDatabase = new StudentDatabase();
        Student nikita = new Student("Никита");
        Student pavel = new Student("Павел");
        Student irina = new Student("Ирина");
        studentDatabase.addStudentWithSubject(nikita, nikitaEnglish);
        studentDatabase.addStudentWithSubject(nikita, nikitaHistory);
        studentDatabase.addStudentWithSubject(pavel, pavelEnglish);
        Subject algebra = new Subject("Алгебра");
        studentDatabase.addStudentToSubject(irina, algebra);
        studentDatabase.addSubjectForStudents(algebra, List.of(nikita, new Student("Дмитрий")));
        studentDatabase.deleteStudent(new Student("Вася"));
        studentDatabase.addSubjectWithStudent(algebra, irina, 5);
        studentDatabase.printAllStudentWithScores();
        studentDatabase.deleteStudentFromSubject(irina, algebra);
        studentDatabase.printAllSubjectsAndStudents();
    }
}
