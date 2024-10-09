package school.faang;

import school.faang.university.Student;
import school.faang.university.Subject;
import school.faang.university.UniversityServices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static UniversityServices universityServices = new UniversityServices();
    public static void main(String[] args) {
        Student firstStudent = new Student(12, "John");
        Student secondStudent = new Student(208, "Mark");
        Student thirdStudent = new Student(35, "Ada");

        Subject chemistry = new Subject(2, "Chemistry");
        Subject pe = new Subject(15, "PE");
        Subject maths = new Subject(26, "Maths");

        universityServices.addNewStudent(firstStudent, new HashMap<>(Map.of(chemistry, 8, pe, 12, maths, 3)));
        universityServices.addNewStudent(secondStudent, new HashMap<>(Map.of(pe, 10, chemistry, 7)));
        universityServices.addNewStudent(thirdStudent, new HashMap<>(Map.of(maths, 12)));

        universityServices.printAllStudSubj();
        System.out.println("==============================================");

        universityServices.addNewSubjectToStudent(thirdStudent, pe, 6);

        universityServices.addNewSubjectToStudent(firstStudent, chemistry, 7);

        universityServices.deleteStudent(secondStudent);

        universityServices.printAllStudSubj();

        universityServices.addNewSubject(
                new Subject(12, "Physics"),
                List.of(firstStudent, thirdStudent)
        );
        universityServices.addStudentToASubject(chemistry, thirdStudent);

        universityServices.detachStudFromSubj(chemistry, firstStudent);
        System.out.println("=========================================");

        universityServices.printAllSubjects();
    }
}