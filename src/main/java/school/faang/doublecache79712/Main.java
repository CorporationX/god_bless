package school.faang.doublecache79712;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentWithGrades(new Student("Дима"), new HashMap<>(Map.of(
                new Subject("Математика"), 5,
                new Subject("Физика"), 4)));
        System.out.println(studentDatabase.studentSubjects);
        System.out.println(studentDatabase.subjectStudents);
        studentDatabase.addStudentWithGrades(new Student("Дима"), new HashMap<>(Map.of(
                new Subject("История"), 5,
                new Subject("Обж"), 4)));
        studentDatabase.addStudentWithGrades(new Student("Витя"), new HashMap<>(Map.of(
                new Subject("История"), 4,
                new Subject("Обж"), 5)));
        System.out.println(studentDatabase.studentSubjects);
        System.out.println(studentDatabase.subjectStudents);
        System.out.println("*****************");
        studentDatabase.addSubjectForStudent(new Student("Олег"), new Subject("Физика"), 56);
        studentDatabase.addSubjectForStudent(new Student("Витя"), new Subject("Музыка"), 5);
        System.out.println(studentDatabase.studentSubjects);
        System.out.println(studentDatabase.subjectStudents);
        System.out.println("*****************");
        // studentDatabase.removeStudent(new Student("Дима"));
        System.out.println(studentDatabase.studentSubjects);
        System.out.println(studentDatabase.subjectStudents);

        studentDatabase.printAllSubjectsWithStudents();
        System.out.println("*****************");
        studentDatabase.addSubjectWithStudents(new Subject("Физ-ра"),
                new ArrayList<>(List.of(new Student("Пётр"), new Student("Витя"))));

        studentDatabase.printAllSubjectsWithStudents();
        System.out.println(studentDatabase.studentSubjects);
        System.out.println("*****************");

        studentDatabase.addStudentToSubject(new Student("Иван"), new Subject("Физика"));
        studentDatabase.addStudentToSubject(new Student("Иван"), new Subject("Литература"));
        studentDatabase.printAllSubjectsWithStudents();
        System.out.println(studentDatabase.studentSubjects);
        System.out.println("*****************");

        studentDatabase.removeStudentFromSubject(new Student("Витя"), new Subject("Физика"));
        studentDatabase.printAllSubjectsWithStudents();
        System.out.println(studentDatabase.studentSubjects);
    }
}
