package school.faang.doublecash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static HashMap<Student, Map<Subject, Integer>> studentsGrade = new HashMap<>();
    public static HashMap<Subject, List<Student>> subjects = new HashMap<>();

    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase(studentsGrade, subjects);

        Student ivan = new Student(1, "Иван");
        Student lyosha = new Student(2, "Алексей");
        Student masha = new Student(3, "Мария");
        Subject physics = new Subject(1, "Физика");
        Subject math = new Subject(3, "Математика");
        Subject chemistry = new Subject(2, "Химия");

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
