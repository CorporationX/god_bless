package school.faang.doublecash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static HashMap<Student, Map<Subject, Integer>> studentsGrade = new HashMap<>();
    public static HashMap<Subject, List<Student>> subjects = new HashMap<>();

    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        Student ivan = new Student("Иван");
        Student lyosha = new Student("Алексей");
        Student masha = new Student("Мария");
        Subject physics = new Subject("Физика");
        Subject math = new Subject("Математика");
        Subject chemistry = new Subject("Химия");

        studentDatabase.addStudentAndSubjects(ivan, math, 7);
        studentDatabase.addStudentAndSubjects(masha, physics, 4);
        studentDatabase.addStudentAndSubjects(lyosha, chemistry, 4);
        studentDatabase.printAllStudentsAndGrade();
        System.out.println("------------------------------------");
        studentDatabase.removeStudentAndSubjects(masha);
        studentDatabase.printAllStudentsAndGrade();
        studentDatabase.addSubjectForExistingStudent(ivan, physics, 9);
        System.out.println("------------------------------------");
        studentDatabase.printAllStudentsAndGrade();
        System.out.println("------------------------------------");

        studentDatabase.addSubjectAndStudents(chemistry, ivan);
        studentDatabase.addSubjectAndStudents(math, masha);
        studentDatabase.addSubjectAndStudents(physics, masha);
        studentDatabase.printAllSubjectsAndStudents();
        System.out.println("------------------------------------");
        studentDatabase.addStudentToSubject(math, lyosha);
        studentDatabase.printAllSubjectsAndStudents();
        System.out.println("------------------------------------");
        studentDatabase.removeStudentFromSubject(physics, masha);
        studentDatabase.printAllSubjectsAndStudents();
    }
}
