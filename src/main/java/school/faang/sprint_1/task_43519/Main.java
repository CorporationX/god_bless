package school.faang.sprint_1.task_43519;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Subject math = new Subject(1, "Mathematics");
    private static final Subject physics = new Subject(2, "Physics");
    private static final Subject biology = new Subject(3, "Biology");
    private static final Subject chemistry = new Subject(4, "Chemistry");

    private static final Student ksusha = new Student(1, "Ksusha");
    private static final Student nastya = new Student(2, "Nastya");
    private static final Student tanya = new Student(3, "Tanya");

    public static void main(String[] args) {
        StudentDatabase studentDb = new StudentDatabase();

        studentDb.addNewStudentWithGrades(ksusha, new HashMap<>(Map.of(math, 10, physics, 9)));
        studentDb.addNewStudentWithGrades(nastya, new HashMap<>(Map.of(biology, 8, chemistry, 10)));
        studentDb.addNewStudentWithGrades(tanya, new HashMap<>(Map.of(math, 7)));

        studentDb.printStudentsGrades();

        studentDb.addGradeForExistStudent(tanya, chemistry, 7);
        studentDb.removeStudent(ksusha);
        studentDb.printStudentsGrades();

        studentDb.addNewSubject(math, new HashSet<>(Set.of(tanya)));
        studentDb.addNewSubject(chemistry, new HashSet<>(Set.of(nastya)));
        studentDb.addNewSubject(biology, new HashSet<>(Set.of(nastya)));

        studentDb.printAllSubjects();

        studentDb.addStudentToSubject(math, ksusha);
        studentDb.addStudentToSubject(chemistry, tanya);
        studentDb.addStudentToSubject(chemistry, ksusha);
        studentDb.printAllSubjects();

        studentDb.removeStudentFromSubject(chemistry, ksusha);
        studentDb.printAllSubjects();
    }
}
