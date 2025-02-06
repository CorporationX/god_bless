package school.faang.doublecache;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();
        Subject math = new Subject("Math");
        Subject history = new Subject("History");
        Subject chemistry = new Subject("Chemistry");
        Student masha = new Student("Masha");
        Student david = new Student("David");
        Student stepan = new Student("Stepan");
        Student vasya = new Student("Vasiliy");

        Map<Subject, Integer> mashaSubjects = new HashMap<>();
        mashaSubjects.put(math, 85);
        mashaSubjects.put(history, 30);
        mashaSubjects.put(chemistry, 61);
        db.addStudentWithGrates(masha, mashaSubjects);
        db.printAllStudentsWithSubjectsAndGrades();
        db.printAllSubjectsWithStudents();

        Map<Subject, Integer> davidSubjects = new HashMap<>();
        Map<Subject, Integer> stepanSubjects = new HashMap<>();
        Map<Subject, Integer> vasyaSubjects = new HashMap<>();
        davidSubjects.put(math, 64);
        davidSubjects.put(history, 82);
        davidSubjects.put(chemistry, 10);
        stepanSubjects.put(math, 74);
        stepanSubjects.put(history, 61);
        stepanSubjects.put(chemistry, 34);
        vasyaSubjects.put(math, 46);
        vasyaSubjects.put(history, 96);
        vasyaSubjects.put(chemistry, 47);
        db.addStudentWithGrates(david, davidSubjects);
        db.addStudentWithGrates(stepan, stepanSubjects);
        db.addStudentWithGrates(vasya, vasyaSubjects);
        db.printAllStudentsWithSubjectsAndGrades();
        db.deleteStudentAndHisSubjects(stepan);
        db.printAllStudentsWithSubjectsAndGrades();
    }
}
