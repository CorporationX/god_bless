package school.faang.doublecash.main;

import school.faang.doublecash.maincode.Student;
import school.faang.doublecash.maincode.StudentService;
import school.faang.doublecash.maincode.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentsMap = new HashMap<>();
    private static Map<Subject, List<Student>> subjectsMap = new HashMap<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        Student firstStudent = new Student(1, "Gadhi");
        Student secondStudent = new Student(2, "Andrey");
        Student thirdStudent = new Student(3, "Vanya");

        Subject firstSubject = new Subject(1, "Math");
        Subject secondSubject = new Subject(2, "Geografic");
        Subject thirdSubject = new Subject(3, "english");

        Map<Subject, Integer> firstMap = new HashMap<>();
        firstMap.put(firstSubject, 3);
        Map<Subject, Integer> secondMap = new HashMap<>();
        secondMap.put(secondSubject, 4);
        Map<Subject, Integer> thirdMap = new HashMap<>();
        thirdMap.put(thirdSubject, 5);


        StudentService.addStudent(firstStudent, firstMap, studentsMap);
        StudentService.addStudent(secondStudent, secondMap, studentsMap);
        StudentService.addStudent(thirdStudent, thirdMap, studentsMap);

        StudentService.addSubjectForStudent(firstStudent, firstSubject, 6, studentsMap);

        StudentService.removeStudent(thirdStudent, studentsMap);

        StudentService.printAll(studentsMap);

        StudentService.addSubject(firstSubject, firstStudent, subjectsMap, students);
        StudentService.addSubject(secondSubject, secondStudent, subjectsMap, students);
        StudentService.addSubject(thirdSubject, thirdStudent, subjectsMap, students);

        StudentService.addStudentForSubject(secondStudent, secondSubject, subjectsMap);

        StudentService.removeStudent(firstSubject, firstStudent, subjectsMap);

        StudentService.printAllSubjects(subjectsMap);
    }
}
