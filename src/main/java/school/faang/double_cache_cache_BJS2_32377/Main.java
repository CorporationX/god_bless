package school.faang.double_cache_cache_BJS2_32377;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        University main = new University();

        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(3, "Charlie");

        Subject math = new Subject(101, "Math");
        Subject physics = new Subject(102, "Physics");
        Subject chemistry = new Subject(103, "Chemistry");

        Map<Subject, Integer> student1Subjects = new HashMap<>(Map.of(math, 85, physics, 90));
        Map<Subject, Integer> student2Subjects = new HashMap<>(Map.of(math, 80, chemistry, 75));
        List<Student> studentsForMath = new ArrayList<>(List.of(student1, student2));
        List<Student> studentsForPhysics = new ArrayList<>(List.of(student1));

        main.addStudent(student1, student1Subjects, main.getStudentsWithSubjects(), main.getSubjectsWithStudents());
        main.printStudentsWithSubjectsGrades(main.getStudentsWithSubjects());
        main.printSubjectsAndStudyingStudents(main.getSubjectsWithStudents());

        main.addSubjectForStudent(chemistry, 76, student1, main.getStudentsWithSubjects());
        main.printStudentsWithSubjectsGrades(main.getStudentsWithSubjects());

        main.addStudent(student2, student2Subjects, main.getStudentsWithSubjects(), main.getSubjectsWithStudents());
        main.printStudentsWithSubjectsGrades(main.getStudentsWithSubjects());

        main.deleteStudentWithGrades(student1, main.getStudentsWithSubjects());
        main.printStudentsWithSubjectsGrades(main.getStudentsWithSubjects());

        main.addSubjectAndStudyingStudents(math, studentsForMath, main.getSubjectsWithStudents());
        main.printSubjectsAndStudyingStudents(main.getSubjectsWithStudents());

        main.addStudentToSubject(student3, math, main.getSubjectsWithStudents());
        main.addSubjectAndStudyingStudents(physics, studentsForPhysics, main.getSubjectsWithStudents());
        main.printSubjectsAndStudyingStudents(main.getSubjectsWithStudents());

        main.deleteStudentFromSubject(student1, math, main.getSubjectsWithStudents());
        main.printSubjectsAndStudyingStudents(main.getSubjectsWithStudents());
    }
}