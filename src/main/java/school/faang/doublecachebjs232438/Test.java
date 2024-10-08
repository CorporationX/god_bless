package school.faang.doublecachebjs232438;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        StudentRegistration studentRegistration = new StudentRegistration();

        var music = new Subject(2, "Music");
        var math = new Subject(1, "Math");
        var history = new Subject(3, "History");

        studentRegistration.addSubjectWithStudents(math,
                List.of(
                        new Student(10, "Alex"),
                        new Student(11, "Nick"),
                        new Student(12, "Pete")
                ));

        studentRegistration.addSubjectWithStudents(music,
                List.of(
                        new Student(12, "Kate"),
                        new Student(13, "Mary"),
                        new Student(14, "Mike")
                ));

        studentRegistration.printSubjects();

        System.out.println();
        studentRegistration.pushStudentsToSubjects(new Student(12, "Kseniya"), math);
        studentRegistration.printSubjects();


        System.out.println();
        studentRegistration.extractStudentsFromSubjects(new Student(12, "Kate"), music);
        studentRegistration.printSubjects();


        var subjects = Map.of(
                math, 4,
                music, 3,
                history, 5
        );

        var jeni = new Student(15, "Jeni");
        System.out.println();
        studentRegistration.addStudent(jeni, subjects);
        studentRegistration.printStudents();
        studentRegistration.printSubjects();
        System.out.println();


        var rating = 5;
        System.out.println();
        studentRegistration.addSubjectWithStudents(history, new ArrayList<>());
        studentRegistration.addSubjectForExistStudent(jeni, history, rating);
        studentRegistration.printStudents();
    }
}
