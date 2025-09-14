package school.faang.bjs2_86039;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        final StudentDatabase studentDatabase = new StudentDatabase();

        final Student studentAnna = new Student("Anna");
        final Student studentIvan = new Student("Ivan");
        final Student studentAnton = new Student("Anton");
        final Student studentBill = new Student("Bill");

        final Subject biology = new Subject("Biology");
        final Subject science = new Subject("Science");


        studentDatabase.addStudent(studentAnna, new HashMap<>(Map.of(
                biology, 5,
                science, 5
        )));

        studentDatabase.addStudent(studentAnna, new HashMap<>(Map.of(
                biology, 6,
                science, 7
        )));

        studentDatabase.addStudent(studentIvan, new HashMap<>(Map.of(
                biology, 3,
                science, 2
        )));

        studentDatabase.addSubjectForExistStudent(studentAnna, biology, 6);
        studentDatabase.addSubjectForExistStudent(studentAnton, science, 7);

        studentDatabase.addSubject(biology, new ArrayList<>(List.of(studentAnna, studentIvan, studentBill)));
        studentDatabase.addSubject(biology, new ArrayList<>(List.of(studentAnna, studentIvan, studentBill)));

        studentDatabase.printAllStudentsWithSubjects();
        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.removeStudent(studentAnna);

        System.out.println("\n**********");
        System.out.println("After remove Anna\n");
        studentDatabase.printAllStudentsWithSubjects();
        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.removeStudentFromSubject(biology, studentIvan);

        System.out.println("\n**********");
        System.out.println("After remove Ivan from biology\n");
        studentDatabase.printAllStudentsWithSubjects();
        studentDatabase.printAllSubjectsWithStudents();
    }
}