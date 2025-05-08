package school.faang.doubleCacheCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");

        Map<Subject, Integer> aliceSubjects = new HashMap<>();
        aliceSubjects.put(math, 90);
        aliceSubjects.put(physics, 85);

        Subject chemistry = new Subject("Chemistry");
        Map<Subject, Integer> bobSubjects = new HashMap<>();
        bobSubjects.put(physics, 78);
        bobSubjects.put(chemistry, 88);


        SubjectDatabase database = new SubjectDatabase();
        database.addStudentWithSubjects("Ivan", aliceSubjects);
        database.addStudentWithSubjects("Bob", bobSubjects);

        Student student1 = new Student("Ivan");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Kateryna");

        List<Student> studentsForChemistry = new ArrayList<>();
        studentsForChemistry.add(student1);
        studentsForChemistry.add(student2);
        studentsForChemistry.add(student3);

        database.addNewSubjectWithStudents("Chemistry", studentsForChemistry);

        database.addStudentToSubject("Math", student3);

        database.removeStudentFromSubject("Chemistry", "Bob");

        System.out.println("Students and their subjects:");
        database.printAllStudentsAndGrades();

        System.out.println("Subjects and their students:");
        database.printAllSubjectsAndStudents();
    }
}
