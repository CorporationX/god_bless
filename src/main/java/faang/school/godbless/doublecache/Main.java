package faang.school.godbless.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserSubjectService userService = new UserSubjectService();
        SubjectService subjectService = new SubjectService();

        Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
        Map<Subject, List<Student>> subjectMap = new HashMap<>();

        Student ivan = new Student(1, "Ivan");
        Student petr = new Student(2, "Petr");
        Student oleg = new Student(3, "Oleg");

        Subject math = new Subject(1, "Math");
        Subject biology = new Subject(2, "Biology");

        userService.addStudentWithSubject(studentMap, ivan, Map.of(math, 5, biology, 4));
        userService.addStudentWithSubject(studentMap, petr, Map.of(math, 2, biology, 3));

        userService.showStudentsInfo(studentMap);
        System.out.println();

        subjectService.addStudentToSubject(subjectMap, biology, oleg);

        subjectService.showSubjectsInfo(subjectMap);
    }
}
