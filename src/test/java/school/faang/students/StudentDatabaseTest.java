package school.faang.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.students.Grade.A;
import static school.faang.students.Grade.B;
import static school.faang.students.Grade.C;
import static school.faang.students.Grade.D;
import static school.faang.students.Grade.NOT_GRADED;

class StudentDatabaseTest {

    private final StudentDatabase studentDatabase = new StudentDatabase();
    private final Student mike = new Student("Mike");
    private final Student kate = new Student("Kate");
    private final Subject math = new Subject("Math");
    private final Subject computerScience = new Subject("Computer Science");
    private final Subject english = new Subject("English");
    private final Subject biology = new Subject("Biology");

    @Test
    void testAddStudentWithSubjectsAndGrades() {
        Map<Subject, Grade> subjectsOfStudent = new HashMap<>(Map.of(
                math, A,
                computerScience, B,
                english, C
        ));

        studentDatabase.addStudentWithSubjectsAndGrades(mike, subjectsOfStudent);

        Map<Student, Map<Subject, Grade>> allStudents = studentDatabase.printStudents();
        final Map<Subject, List<Student>> allSubjectsFirstRequest = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(mike), subjectsOfStudent);
        subjectsOfStudent.keySet().forEach(subject -> Assertions.assertEquals(allSubjectsFirstRequest.get(subject),
                List.of(mike)));

        studentDatabase.addStudentWithSubjectsAndGrades(kate, subjectsOfStudent);

        allStudents = studentDatabase.printStudents();
        final Map<Subject, List<Student>> allSubjectsSecondRequest = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(mike), subjectsOfStudent);
        subjectsOfStudent.keySet().forEach(subject -> Assertions.assertEquals(allSubjectsSecondRequest.get(subject),
                List.of(mike, kate)));
    }

    @Test
    void testAddSubjectToExistingStudent() {
        studentDatabase.addStudentWithSubjectsAndGrades(mike, new HashMap<>(Map.of(english, D)));
        studentDatabase.addSubjectToExistingStudent(mike, math, A);

        Map<Student, Map<Subject, Grade>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(mike), new HashMap<>(Map.of(english, D, math, A)));
        allSubjects.keySet().forEach(subject -> Assertions.assertEquals(allSubjects.get(subject),
                List.of(mike)));
    }

    @Test
    void testDeleteStudentAndHisSubjects() {
        Map<Subject, Grade> subjectsOfMike = new HashMap<>(Map.of(
                math, A,
                english, B,
                computerScience, A
        ));

        Map<Subject, Grade> subjectsOfKate = new HashMap<>(Map.of(
                math, C,
                english, B,
                biology, D
        ));

        studentDatabase.addStudentWithSubjectsAndGrades(mike, subjectsOfMike);
        studentDatabase.addStudentWithSubjectsAndGrades(kate, subjectsOfKate);

        studentDatabase.deleteStudentAndHisSubjects(mike);

        Map<Student, Map<Subject, Grade>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertNull(allStudents.get(mike));
        allSubjects.values().forEach((students) ->
                Assertions.assertFalse(students.contains(mike))
        );
    }

    @Test
    void testAddSubjectAndListStudents() {
        studentDatabase.addSubjectAndListStudents(math, List.of(mike, kate));

        Map<Student, Map<Subject, Grade>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(mike), Map.of(math, NOT_GRADED));
        Assertions.assertEquals(allStudents.get(kate), Map.of(math, NOT_GRADED));
        Assertions.assertEquals(allSubjects.get(math), List.of(mike, kate));
    }

    @Test
    void testAddStudentToExistingSubject() {
        studentDatabase.addStudentWithSubjectsAndGrades(mike, new HashMap<>(Map.of(math, A)));
        studentDatabase.addStudentToExistingSubject(kate, math);

        Map<Student, Map<Subject, Grade>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(mike), Map.of(math, A));
        Assertions.assertEquals(allStudents.get(kate), Map.of(math, NOT_GRADED));
        Assertions.assertEquals(allSubjects.get(math), List.of(mike, kate));
    }

    @Test
    void testDeleteStudentFromSubject() {
        studentDatabase.addStudentWithSubjectsAndGrades(mike, new HashMap<>(Map.of(math, A)));
        studentDatabase.addStudentWithSubjectsAndGrades(kate, new HashMap<>(Map.of(english, A)));
        studentDatabase.deleteStudentFromSubject(mike, english);

        Map<Student, Map<Subject, Grade>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertEquals(1, allStudents.get(mike).size());
        Assertions.assertEquals(1, allStudents.get(kate).size());
        Assertions.assertEquals(allStudents.get(mike), Map.of(math, A));
        Assertions.assertEquals(allStudents.get(kate), Map.of(english, A));
        Assertions.assertEquals(1, allSubjects.get(english).size());
        Assertions.assertEquals(1, allSubjects.get(math).size());
        Assertions.assertEquals(allSubjects.get(math), List.of(mike));
        Assertions.assertEquals(allSubjects.get(english), List.of(kate));
    }

    @Test
    void testExceptionAddStudentToExistingSubject() {
        Assertions.assertThrows(StudentException.class, () -> studentDatabase.addStudentToExistingSubject(mike, math));
    }

    @Test
    void testExceptionAddSubjectToExistingStudent() {
        Assertions.assertThrows(StudentException.class,
                () -> studentDatabase.addSubjectToExistingStudent(mike, math, A));
    }

    @Test
    void testExceptionDeleteStudentFromSubject() {
        Assertions.assertThrows(StudentException.class, () -> studentDatabase.deleteStudentFromSubject(mike, english));
    }

}