package school.faang.double_cache;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        Subject math = new Subject(1, "Math");
        Subject geography = new Subject(2, "Geography");
        Subject russian = new Subject(3, "Russian Language");
        Subject sport = new Subject(5, "Sport");
        Subject physic = new Subject(6, "Physic");
        Subject literature = new Subject(7, "Literature");

        Student egor = new Student(1, "Egor");
        Student ruslan = new Student(2, "Ruslan");
        Student ilya = new Student(3, "Ilya");
        Student vlad = new Student(4, "Vlad");

        studentDatabase.printAllStudentsWithGrades();

        HashMap<Subject, Integer> egorSubjectsAndGrades = new HashMap<>();
        egorSubjectsAndGrades.put(math, 5);
        egorSubjectsAndGrades.put(geography, 4);
        egorSubjectsAndGrades.put(russian, 3);
        studentDatabase.addStudent(egor, egorSubjectsAndGrades);

        HashMap<Subject, Integer> ruslanSubjectsAndGrades = new HashMap<>();
        ruslanSubjectsAndGrades.put(math, 3);
        ruslanSubjectsAndGrades.put(russian, 4);
        ruslanSubjectsAndGrades.put(sport, 5);
        studentDatabase.addStudent(ruslan, ruslanSubjectsAndGrades);

        HashMap<Subject, Integer> ilyaSubjectsAndGrades = new HashMap<>();
        ilyaSubjectsAndGrades.put(math, 4);
        ilyaSubjectsAndGrades.put(russian, 5);
        ilyaSubjectsAndGrades.put(geography, 5);
        ilyaSubjectsAndGrades.put(sport, 5);
        ilyaSubjectsAndGrades.put(physic, 3);
        studentDatabase.addStudent(ilya, ilyaSubjectsAndGrades);

        studentDatabase.printAllStudentsWithGrades();

        System.out.println();
        studentDatabase.addSubjectToStudent(egor, sport, 5);
        studentDatabase.addSubjectToStudent(egor, physic, 3);

        System.out.println();
        studentDatabase.removeStudent(ruslan);

        studentDatabase.printAllStudentsWithGrades();

        System.out.println();
        ArrayList<Student> literatureStudents = new ArrayList<>();
        literatureStudents.add(ilya);
        literatureStudents.add(egor);
        studentDatabase.addSubject(literature, literatureStudents);

        studentDatabase.printAllStudentsWithGrades();

        System.out.println();
        studentDatabase.addStudentToSubject(vlad, sport, 5);

        studentDatabase.printAllStudentsWithGrades();
        System.out.println();
        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.removeStudentFromSubject(ruslan, physic);
        studentDatabase.removeStudentFromSubject(egor, russian);

        studentDatabase.printAllStudentsWithGrades();
        System.out.println();
        studentDatabase.printAllSubjectsWithStudents();
    }
}
