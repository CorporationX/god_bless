package school.faang.double_cache_cache_BJS2_32377;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Main main = new Main();

        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(3, "Charlie");

        Subject math = new Subject(101, "Math");
        Subject physics = new Subject(102, "Physics");
        Subject chemistry = new Subject(103, "Chemistry");

        Map<Subject, Integer> student1Subjects = new HashMap<>();
        student1Subjects.put(math, 85);
        student1Subjects.put(physics, 90);

        Map<Subject, Integer> student2Subjects = new HashMap<>();
        student2Subjects.put(math, 80);
        student2Subjects.put(chemistry, 75);

        List<Student> studentsForMath = new ArrayList<>(List.of(student1, student2));
        List<Student> studentsForPhysics = new ArrayList<>(List.of(student1));

        main.addNewStudent(student1, student1Subjects, main.getStudentsListWithSubjects());
        main.printAllStudentsWithSubjectsGrades(main.getStudentsListWithSubjects());
        printGaps();

        main.addNewSubjectForExistingStudent(chemistry, 76, student1, main.getStudentsListWithSubjects());
        main.printAllStudentsWithSubjectsGrades(main.getStudentsListWithSubjects());
        printGaps();

        main.addNewStudent(student2, student2Subjects, main.getStudentsListWithSubjects());
        main.printAllStudentsWithSubjectsGrades(main.getStudentsListWithSubjects());
        printGaps();

        main.deleteStudentWithGrades(student1, main.getStudentsListWithSubjects());
        main.printAllStudentsWithSubjectsGrades(main.getStudentsListWithSubjects());
        printGaps();


        main.addNewSubjectAndStudyingStudents(math, studentsForMath, main.getSubjectsListWithStudents());
        main.printAllSubjectsAndStudyingStudents(main.getSubjectsListWithStudents());
        printGaps();

        main.addNewStudentToExistingSubject(student3, math, main.getSubjectsListWithStudents());
        main.addNewSubjectAndStudyingStudents(physics, studentsForPhysics, main.getSubjectsListWithStudents());
        main.printAllSubjectsAndStudyingStudents(main.getSubjectsListWithStudents());
        printGaps();

        main.deleteStudentFromSubject(student1, math, main.getSubjectsListWithStudents());
        main.printAllSubjectsAndStudyingStudents(main.getSubjectsListWithStudents());
    }

    public static void printGaps() {
        System.out.println();
    }
}
