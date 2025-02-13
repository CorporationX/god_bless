package school.faang.task_57052;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Subject defenseDarkArts = new Subject("Защита от тёмных искусств");

        Map<Subject, Integer> harryGrades = new HashMap<>();
        harryGrades.put(defenseDarkArts, 4);
        Map<Subject, Integer> ronGrades = new HashMap<>();
        ronGrades.put(defenseDarkArts, 3);
        Map<Subject, Integer> hermioneGrades = new HashMap<>();
        hermioneGrades.put(defenseDarkArts, 5);
        Map<Subject, Integer> nevilleGrades = new HashMap<>();
        nevilleGrades.put(defenseDarkArts, 4);

        Student harry = new Student("Гарри");
        Student ron = new Student("Рон");
        Student hermione = new Student("Гермиона");
        Student neville = new Student("Невилл");

        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentWithGrades(harry, harryGrades);
        studentDatabase.addStudentWithGrades(ron, ronGrades);
        studentDatabase.addStudentWithGrades(hermione, hermioneGrades);
        studentDatabase.addStudentWithGrades(neville, nevilleGrades);


        Subject flyingOnBroomsticks = new Subject("Полёты на мётлах");
        studentDatabase.addSubjectGrades(harry, flyingOnBroomsticks, 5);
        studentDatabase.removeStudent(neville);
        studentDatabase.printAllStudentsWithGrades();

        Set<Student> students = new HashSet<>(Set.of(harry, ron, hermione));
        studentDatabase.addSubjectWithStudents(flyingOnBroomsticks, students);
        studentDatabase.addStudentToSubject(neville, flyingOnBroomsticks);
        studentDatabase.removeStudentFromSubject(hermione, flyingOnBroomsticks);
        studentDatabase.printAllSubjectsWithStudents();
    }
}
