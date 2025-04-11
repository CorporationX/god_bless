package school.faang.bjs2_68745;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final StudentDatabase database = new StudentDatabase();

    private static final Student ivan = new Student("Ivan");
    private static final Student petr = new Student("Petr");
    private static final Student semen = new Student("Semen");
    private static final Student fyedor = new Student("Fyedor");

    private static final Subject algebra = new Subject("Algebra");
    private static final Subject geometry = new Subject("Geometry");
    private static final Subject physics = new Subject("Physics");
    private static final Subject russian = new Subject("Russian");

    public static void main(String[] args) {

        Map<Subject, Integer> ivanSubjects = new HashMap<>();
        ivanSubjects.put(algebra, 5);
        ivanSubjects.put(geometry, 5);
        ivanSubjects.put(russian, 5);

        Map<Subject, Integer> petrSubjects = new HashMap<>();
        petrSubjects.put(algebra, 5);
        petrSubjects.put(geometry, 4);
        petrSubjects.put(physics, 3);

        database.addStudentWithSubjects(ivan, ivanSubjects);
        database.addStudentWithSubjects(petr, petrSubjects);
        database.addSubjectToStudent(semen, russian, 5);
        printAll(database);

        Map<Subject, Integer> ivanSubjectsNew = new HashMap<>();
        ivanSubjectsNew.put(physics, 4);
        ivanSubjectsNew.put(russian, 4);
        database.addStudentWithSubjects(ivan, ivanSubjectsNew);
        printAll(database);

        database.removeStudent(ivan);
        database.removeStudent(fyedor);
        database.removeStudentFromSubject(fyedor, algebra);
        printAll(database);
    }

    private static void printAll(StudentDatabase database) {
        database.printAllStudents();
        System.out.println("----------------------");
        database.printAllSubject();
        System.out.println("=======================\n=======================");
    }
}
