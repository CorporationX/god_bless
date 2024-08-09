package faang.school.godbless.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        SubjectService subjectService = new SubjectService();

        Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
        Map<Subject, List<Student>> subjectMap = new HashMap<>();

        Student ivan = new Student(1, "Ivan");
        Student petr = new Student(2, "Petr");
        Student oleg = new Student(3, "Oleg");

        Subject math = new Subject(1, "Math");
        Subject biology = new Subject(2, "Biology");
        Subject geography = new Subject(3, "Geography");

        userService.addStudentWithSubject(studentMap, ivan, new HashMap<>(Map.of(math, 5, biology, 4)));
        userService.addStudentWithSubject(studentMap, petr, new HashMap<>(Map.of(math, 2, biology, 3)));
        userService.showStudentsInfo(studentMap);
        System.out.println();

        userService.addSubjectForStudent(studentMap, ivan, geography, 5);
        userService.showStudentsInfo(studentMap);
        System.out.println();

        userService.removeStudentWithSubjects(studentMap, petr);

        try {
            userService.addSubjectForStudent(studentMap, oleg, geography, 4);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        try {
            userService.removeStudentWithSubjects(studentMap, petr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        subjectService.addSubjectWithStudents(subjectMap, math, new ArrayList<>(List.of(oleg, petr)));
        subjectService.addSubjectWithStudents(subjectMap, geography, new ArrayList<>(List.of(oleg, petr)));
        subjectService.showSubjectsInfo(subjectMap);
        System.out.println();

        subjectService.addStudentToSubject(subjectMap, math, ivan);
        subjectService.showSubjectsInfo(subjectMap);
        System.out.println();

        subjectService.removeStudentFromSubject(subjectMap, math, oleg);
        subjectService.showSubjectsInfo(subjectMap);
        System.out.println();

        try {
            subjectService.addStudentToSubject(subjectMap, biology, ivan);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        try {
            subjectService.removeStudentFromSubject(subjectMap, biology, oleg);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
    }
}
