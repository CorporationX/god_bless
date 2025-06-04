package school.faang.bjs2_79648_hash_hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- Testing student methods ---");
        Subject math = new Subject("Math");
        Subject chemistry = new Subject("Chemistry");
        Subject logics = new Subject("Logics");

        Map<Subject, Integer> goodGrades = new HashMap<>();
        goodGrades.put(math, 100);
        goodGrades.put(chemistry, 95);
        goodGrades.put(logics, 90);
        Student studentGood = new Student("Welly");
        StudentDatabase.addStudentWithSubjects(studentGood, goodGrades);

        Map<Subject, Integer> sosoGrades = new HashMap<>();
        sosoGrades.put(math, 70);
        sosoGrades.put(chemistry, 75);
        sosoGrades.put(logics, 65);
        Student studentSoso = new Student("Avery");
        StudentDatabase.addStudentWithSubjects(studentSoso, sosoGrades);

        Map<Subject, Integer> badGrades = new HashMap<>();
        badGrades.put(math, 10);
        badGrades.put(chemistry, 9);
        badGrades.put(logics, 5);
        Student studentBad = new Student("Absent");
        StudentDatabase.addStudentWithSubjects(studentBad, badGrades);

        StudentDatabase.printStudentsWithSubjects();

        System.out.println("\n- Removing Absent -");
        StudentDatabase.removeStudent(studentBad);
        StudentDatabase.printStudentsWithSubjects();

        System.out.println("\n--- Testing subject methods ---");
        StudentDatabase.printSubjectsWithStudents();

        System.out.println("\n- Adding Physics to Absent and Welly -");
        Subject physics = new Subject("Physics");
        StudentDatabase.addSubjectWithStudents(physics, List.of(studentGood, studentBad));
        StudentDatabase.printSubjectsWithStudents();
        StudentDatabase.printStudentsWithSubjects();

        System.out.println("\n- Removing Absent from Physics -");
        StudentDatabase.removeStudentFromSubject(studentBad, physics);
        StudentDatabase.printSubjectsWithStudents();
        StudentDatabase.printStudentsWithSubjects();
    }
}
