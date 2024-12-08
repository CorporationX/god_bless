package school.faang.sprint_1.task_45263;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Subject math = new Subject(101, "Math");
        Subject english = new Subject(102, "English");
        Subject history = new Subject(103, "History");
        Subject literature = new Subject(104, "Literature");
        Subject chemistry = new Subject(105, "Chemistry");

        Student tanya = new Student(201, "Tatiana Gritsenko");
        Student vanya = new Student(202, "Ivan Ivanov");
        Student vika = new Student(203, "Viktoriya Lebedeva");
        Student sasha = new Student(204, "Aleksandr Timofeev");
        Student vlad = new Student(205, "Vladislav Antonov");

        var db = new StudentDatabase();

        db.addStudentWithGrades(tanya, new HashMap<>());

        db.addGradeToStudent(tanya, math, 5);
        db.addGradeToStudent(tanya, english, 4);
        db.addGradeToStudent(tanya, history, 4);
        db.addGradeToStudent(tanya, literature, 5);
        db.addGradeToStudent(tanya, chemistry, 4);

        db.printAllStudentWithGrades();

        Map<Subject, Integer> sashaGrades = new HashMap<>();
        sashaGrades.put(math, 5);
        sashaGrades.put(history, 5);
        sashaGrades.put(english, 4);

        db.addStudentWithGrades(sasha, sashaGrades);

        db.printAllStudentWithGrades();

        db.printAllClasses();

        db.addStudentToClass(math, vika);

        db.printAllStudentWithGrades();

        db.removeStudentWithGrades(vika);

        db.addStudentWithGrades(vlad, new HashMap<>());
        db.addGradeToStudent(vlad, history, 5);

        db.printAllStudentWithGrades();

        Subject physics = new Subject(106, "Physics");
        db.addClass(physics, new ArrayList<>());

        db.addStudentToClass(physics, vanya);
        db.addStudentToClass(physics, vika);

        db.printAllStudentWithGrades();
        db.printAllClasses();

        db.removeStudentFromClass(chemistry, tanya);

        db.printAllClasses();
    }
}
