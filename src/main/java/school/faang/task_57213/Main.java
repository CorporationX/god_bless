package school.faang.task_57213;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Subject math = new Subject(101, "Математика");
        Subject physics = new Subject(102, "Физика");

        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 85);
        grades1.put(physics, 90);

        Subject chemistry = new Subject(103, "Химия");

        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(math, 78);
        grades2.put(chemistry, 88);

        Student student1 = new Student(1, "Аня");
        Student student2 = new Student(2, "Миша");

        StudentDatabase database = new StudentDatabase();

        database.addStudentWithGrades(student1, grades1);
        database.addStudentWithGrades(student2, grades2);

        database.addSubjectForStudent(student1, chemistry, 92);

        System.out.println("printAllStudentsWithGrades()");
        database.printAllStudentsWithGrades();

        Student student3 = new Student(3, "Яна");

        List<Student> studentsForPhysics = new ArrayList<>(List.of(student1, student3));
        database.addSubjectWithStudents(physics, studentsForPhysics);

        System.out.println("\naddSubjectWithStudents(physics, studentsForPhysics) "
                + "and printAllSubjectsWithStudents()");
        database.printAllSubjectsWithStudents();

        database.removeStudent(student2);

        System.out.println("\nremoveStudent(student2) and printAllStudentsWithGrades()");
        database.printAllStudentsWithGrades();

        database.removeStudentFromSubject(student1, chemistry);

        System.out.println("\nremoveStudentFromSubject(student1, chemistry) "
                + "and printAllSubjectsWithStudents()");
        database.printAllSubjectsWithStudents();
    }
}
