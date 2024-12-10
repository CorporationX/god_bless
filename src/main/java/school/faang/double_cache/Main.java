package school.faang.double_cache;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.printAllStudentsWithGrades();

        Subject math = new Subject(1, "Math");
        Subject geography = new Subject(2, "Geography");
        Subject russian = new Subject(3, "Russian Language");

        HashMap<Subject, Integer> egorSubjectsAndGrades = new HashMap<>();
        egorSubjectsAndGrades.put(math, 5);
        egorSubjectsAndGrades.put(geography, 4);
        egorSubjectsAndGrades.put(russian, 3);
        Student egor = new Student(1, "Egor");
        studentDatabase.addStudent(egor, egorSubjectsAndGrades);

        HashMap<Subject, Integer> ruslanSubjectsAndGrades = new HashMap<>();
        ruslanSubjectsAndGrades.put(math, 3);
        ruslanSubjectsAndGrades.put(russian, 4);
        Subject sport = new Subject(5, "Sport");
        ruslanSubjectsAndGrades.put(sport, 5);
        Student ruslan = new Student(2, "Ruslan");
        studentDatabase.addStudent(ruslan, ruslanSubjectsAndGrades);

        HashMap<Subject, Integer> ilyaSubjectsAndGrades = new HashMap<>();
        ilyaSubjectsAndGrades.put(math, 4);
        ilyaSubjectsAndGrades.put(russian, 5);
        ilyaSubjectsAndGrades.put(geography, 5);
        ilyaSubjectsAndGrades.put(sport, 5);
        Subject physic = new Subject(6, "Physic");
        ilyaSubjectsAndGrades.put(physic, 3);
        Student ilya = new Student(3, "Ilya");
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
        Subject literature = new Subject(7, "Literature");
        studentDatabase.addSubject(literature, literatureStudents);

        studentDatabase.printAllStudentsWithGrades();

        System.out.println();
        Student vlad = new Student(4, "Vlad");
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
