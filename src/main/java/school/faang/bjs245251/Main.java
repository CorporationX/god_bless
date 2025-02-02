package school.faang.bjs245251;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final  StudentDataBase dataBaseStudents = new StudentDataBase();

    public static void main(String[] args) {
        final Student petr = new Student(1, "Petr");
        final Student sergey = new Student(2, "Sergey");
        final Student anna = new Student(3, "Anna");

        Map<Subject, Integer> petrGrade = new HashMap<>();
        petrGrade.put(new Subject(111, "Math"), 4);
        petrGrade.put(new Subject(222, "Economic"), 6);
        petrGrade.put(new Subject(333, "English language"), 3);
        dataBaseStudents.addStudentWithGrades(petr, petrGrade);

        Map<Subject, Integer> sergeyGrade = new HashMap<>();
        sergeyGrade.put(new Subject(333, "English language"), 5);
        dataBaseStudents.addStudentWithGrades(sergey, sergeyGrade);

        Map<Subject, Integer> annaGrade = new HashMap<>();
        annaGrade.put(new Subject(222, "Economic"), 5);
        dataBaseStudents.addStudentWithGrades(anna, annaGrade);

        dataBaseStudents.printAllStudents();
        System.out.println("-----------------------");
        dataBaseStudents.addSubjectForStudent(sergey, new Subject(333, "English language"), 8);
        dataBaseStudents.printAllStudents();
        System.out.println("-----------------------");
        dataBaseStudents.printAllSubjectsWithStudents();
    }
}
