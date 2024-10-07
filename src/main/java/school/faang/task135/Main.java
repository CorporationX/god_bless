package school.faang.task135;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Student firstStudent = new Student(0, "Ilya");
        Student secondStudent = new Student(1, "Ivan");
        Student thirdStudent = new Student(2, "Pavel");
        Student fourthStudent = new Student(3, "Roma");
        Student fifthStudent = new Student(4, "Stepan");
        Student sixthStudent = new Student(5, "Semen");

        Subject firstSubject = new Subject(0, "Alchemy");
        Subject secondSubject = new Subject(1, "Physics");
        Subject thirdSubject = new Subject(2, "Biology");

        HashMap<Subject, Integer> testMap = new HashMap<>();
        testMap.put(firstSubject, 5);
        StudentService.addNewStudent(fifthStudent, testMap);
        StudentService.printAllInfoAboutStudent();
        StudentService.printAllSubjectAndStudent();
        System.out.println();

        StudentService.addNewSubjectAndGradeToStudent(fifthStudent, secondSubject, 5);
        StudentService.printAllInfoAboutStudent();
        StudentService.printAllSubjectAndStudent();
        System.out.println();

        HashMap<Subject, Integer> secondTestMap = new HashMap<>();
        secondTestMap.put(firstSubject, 1);
        secondTestMap.put(secondSubject, 1);
        StudentService.addNewStudent(firstStudent, secondTestMap);
        StudentService.printAllInfoAboutStudent();
        StudentService.printAllSubjectAndStudent();
        System.out.println();

        ArrayList<Student> students = new ArrayList<>();
        Stream.of(secondStudent, thirdStudent, fourthStudent)
                .forEach(students::add);
        StudentService.addNewSubjectAndStudents(thirdSubject, students);
        StudentService.printAllInfoAboutStudent();
        StudentService.printAllSubjectAndStudent();
        System.out.println();

        StudentService.addNewStudentToSubject(firstSubject, sixthStudent);
        StudentService.printAllInfoAboutStudent();
        StudentService.printAllSubjectAndStudent();
        System.out.println();

        StudentService.removeStudentFromSubject(fourthStudent, thirdSubject);
        StudentService.printAllInfoAboutStudent();
        StudentService.printAllSubjectAndStudent();
        System.out.println();

        StudentService.removeStudent(fifthStudent);
        StudentService.printAllInfoAboutStudent();
        StudentService.printAllSubjectAndStudent();

    }

}
