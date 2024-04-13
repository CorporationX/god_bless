package Double_cash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Student, Map<Subject, Integer>> gradesTable = new HashMap<>();
    static Map<Subject, List<Student>> studentsTable = new HashMap<>();

    public static void main(String[] args) {
        Student bob = new Student(1, "Bob");
        Student alex = new Student(2, "Alex");
        Student oleja = new Student(3, "Oleja");
        Student alesha = new Student(4, "Alesha");
        Student victor = new Student(5, "Victor");

        Subject math = new Subject(1, "Math");
        Subject chemistry = new Subject(2, "Chemistry");
        Subject biology = new Subject(3, "Biology");
        Subject it = new Subject(4, "IT");
        Subject english = new Subject(5, "English");

        bob.putSubjectWithGrade(math, 4);
        bob.putSubjectWithGrade(chemistry, 5);
        bob.addToGradesTable(gradesTable);
        alex.addToGradesTable(gradesTable);
        oleja.putSubjectWithGrade(it, 5);
        oleja.putSubjectWithGrade(chemistry, 4);
        oleja.putSubjectWithGrade(english, 3);
        oleja.putSubjectWithGrade(biology, 2);
        oleja.putSubjectWithGrade(math, 1);
        oleja.addToGradesTable(gradesTable);
        alesha.putSubjectWithGrade(it, 3);
        victor.studentExpulsion(gradesTable);
        Student.printGradesTable(gradesTable);

        math.addStudent(alesha);
        math.addStudent(alex);
        math.addStudent(victor);
        math.addToStudentsTable(studentsTable);
        chemistry.addToStudentsTable(studentsTable);
        it.deleteStudentFromSubject(alesha, studentsTable);
        biology.addStudent(bob);
        biology.addToStudentsTable(studentsTable);
        biology.deleteStudentFromSubject(bob, studentsTable);
        english.addStudent(oleja);
        english.addToStudentsTable(studentsTable);
        english.addStudent(alesha);
        english.deleteStudentFromSubject(alesha, studentsTable);
        Subject.printStudentsTable(studentsTable);
    }
}