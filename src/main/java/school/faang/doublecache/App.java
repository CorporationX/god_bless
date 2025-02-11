package school.faang.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        final StudentDatabase db = new StudentDatabase();

        Subject math = new Subject("Math");
        Subject history = new Subject("History");
        Subject chemistry = new Subject("Chemistry");

        final Student masha = new Student("Masha");
        final Student david = new Student("David");
        final Student stepan = new Student("Stepan");
        final Student vasya = new Student("Vasiliy");
        final Student kolya = new Student("Nikolay");
        final Student misha = new Student("Michael");
        final Student petya = new Student("Petr");
        final Student nastya = new Student("Anastasiya");
        final Student tanya = new Student("Tatyana");
        final Student anton = new Student("Anton");

        final Map<Subject, Integer> mashaSubjects = new HashMap<>();
        mashaSubjects.put(math, 85);
        mashaSubjects.put(history, 30);
        mashaSubjects.put(chemistry, 61);
        db.addStudentWithGrades(masha, mashaSubjects);
        db.printAllStudentsWithSubjectsAndGrades();
        db.printAllSubjectsWithStudents();

        final Map<Subject, Integer> davidSubjects = new HashMap<>();
        final Map<Subject, Integer> stepanSubjects = new HashMap<>();
        final Map<Subject, Integer> vasyaSubjects = new HashMap<>();
        davidSubjects.put(math, 64);
        davidSubjects.put(history, 82);
        davidSubjects.put(chemistry, 10);
        stepanSubjects.put(math, 74);
        stepanSubjects.put(history, 61);
        stepanSubjects.put(chemistry, 34);
        vasyaSubjects.put(math, 46);
        vasyaSubjects.put(history, 96);
        vasyaSubjects.put(chemistry, 47);
        db.addStudentWithGrades(david, davidSubjects);
        db.addStudentWithGrades(stepan, stepanSubjects);
        db.addStudentWithGrades(vasya, vasyaSubjects);
        db.printAllStudentsWithSubjectsAndGrades();
        db.deleteStudentAndHisSubjects(stepan);
        db.printAllStudentsWithSubjectsAndGrades();

        db.addSubjectWithGrade(math, kolya, 99);
        db.printAllSubjectsWithStudents();
        db.printAllStudentsWithSubjectsAndGrades();

        db.addStudentToSubject(misha, history);
        db.printAllSubjectsWithStudents();
        db.printAllStudentsWithSubjectsAndGrades();

        List<Student> students = List.of(petya, nastya, tanya, anton);
        Subject biology = new Subject("Biology");
        db.addSubjectWithStudents(biology, students);
        db.printAllSubjectsWithStudents();
        db.printAllStudentsWithSubjectsAndGrades();
    }
}
