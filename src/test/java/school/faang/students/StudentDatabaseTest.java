package school.faang.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StudentDatabaseTest {

    private final StudentDatabase studentDatabase = new StudentDatabase();

    @Test
    void testAddStudentWithSubjectsAndGrades() {
        Student student1 = new Student("Миша");
        Map<Subject, Integer> subjectsOfStudent = new HashMap<>(Map.of(
                new Subject("Математика"), 5,
                new Subject("Русский"), 4,
                new Subject("Информатика"), 5
        ));

        studentDatabase.addStudentWithSubjectsAndGrades(student1, subjectsOfStudent);

        Map<Student, Map<Subject, Integer>> allStudents = studentDatabase.printStudents();
        final Map<Subject, List<Student>> allSubjectsFirstRequest = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(student1), subjectsOfStudent);
        subjectsOfStudent.keySet().forEach(subject -> Assertions.assertEquals(allSubjectsFirstRequest.get(subject),
                List.of(student1)));

        Student student2 = new Student("Катя");
        studentDatabase.addStudentWithSubjectsAndGrades(student2, subjectsOfStudent);

        allStudents = studentDatabase.printStudents();
        final Map<Subject, List<Student>> allSubjectsSecondRequest = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(student1), subjectsOfStudent);
        subjectsOfStudent.keySet().forEach(subject -> Assertions.assertEquals(allSubjectsSecondRequest.get(subject),
                List.of(student1, student2)));
    }

    @Test
    void testAddSubjectToExistingStudent() {
        Student student = new Student("Миша");
        Subject math = new Subject("Математика");
        Subject russian = new Subject("Русский");
        int grade = 5;

        String response = studentDatabase.addSubjectToExistingStudent(student, math, grade);
        Assertions.assertEquals(student + " does not exist", response);

        studentDatabase.addStudentWithSubjectsAndGrades(student, new HashMap<>(Map.of(russian, 4)));
        response = studentDatabase.addSubjectToExistingStudent(student, math, grade);
        Assertions.assertEquals(math + " was successfully added to " + student, response);

        Map<Student, Map<Subject, Integer>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(student), new HashMap<>(Map.of(russian, 4, math, 5)));
        allSubjects.keySet().forEach(subject -> Assertions.assertEquals(allSubjects.get(subject),
                List.of(student)));
    }

    @Test
    void testDeleteStudentAndHisSubjects() {
        Student student1 = new Student("Миша");
        Student student2 = new Student("Катя");

        Map<Subject, Integer> subjectsOfStudent1 = new HashMap<>(Map.of(
                new Subject("Математика"), 5,
                new Subject("Русский"), 4,
                new Subject("Физика"), 5
        ));

        Map<Subject, Integer> subjectsOfStudent2 = new HashMap<>(Map.of(
                new Subject("Математика"), 3,
                new Subject("Русский"), 5,
                new Subject("Литература"), 5
        ));

        studentDatabase.addStudentWithSubjectsAndGrades(student1, subjectsOfStudent1);
        studentDatabase.addStudentWithSubjectsAndGrades(student2, subjectsOfStudent2);

        studentDatabase.deleteStudentAndHisSubjects(student1);

        Map<Student, Map<Subject, Integer>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertNull(allStudents.get(student1));
        allSubjects.values().forEach((students) ->
                Assertions.assertFalse(students.contains(student1))
        );
    }

    @Test
    void testAddSubjectAndListStudents() {
        Student student1 = new Student("Миша");
        Student student2 = new Student("Катя");
        Subject math = new Subject("Математика");

        studentDatabase.addSubjectAndListStudents(math, List.of(student1, student2));

        Map<Student, Map<Subject, Integer>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(student1), Map.of(math, 0));
        Assertions.assertEquals(allStudents.get(student2), Map.of(math, 0));
        Assertions.assertEquals(allSubjects.get(math), List.of(student1, student2));
    }

    @Test
    void testAddStudentToExistingSubject() {
        Student student1 = new Student("Катя");
        Student student2 = new Student("Миша");
        Subject math = new Subject("Математика");

        String response = studentDatabase.addStudentToExistingSubject(student1, math);
        Assertions.assertEquals(math + " does not exist", response);

        studentDatabase.addStudentWithSubjectsAndGrades(student1, new HashMap<>(Map.of(math, 5)));

        response = studentDatabase.addStudentToExistingSubject(student2, math);
        Assertions.assertEquals(student2 + " was successfully added to " + math, response);

        Map<Student, Map<Subject, Integer>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertEquals(allStudents.get(student1), Map.of(math, 5));
        Assertions.assertEquals(allStudents.get(student2), Map.of(math, 0));
        Assertions.assertEquals(allSubjects.get(math), List.of(student1, student2));
    }

    @Test
    void testDeleteStudentFromSubject() {
        Student student1 = new Student("Миша");
        Subject math = new Subject("Математика");
        Subject russian = new Subject("Русский");

        String response = studentDatabase.deleteStudentFromSubject(student1, math);
        Assertions.assertEquals(student1 + " does not exist", response);

        studentDatabase.addStudentWithSubjectsAndGrades(student1, new HashMap<>(Map.of(math, 5)));

        response = studentDatabase.deleteStudentFromSubject(student1, russian);
        Assertions.assertEquals(russian + " does not exist", response);

        Student student2 = new Student("Катя");
        studentDatabase.addStudentWithSubjectsAndGrades(student2, new HashMap<>(Map.of(russian, 5)));

        response = studentDatabase.deleteStudentFromSubject(student1, russian);
        Assertions.assertEquals(student1 + " was successfully deleted from " + russian, response);

        Map<Student, Map<Subject, Integer>> allStudents = studentDatabase.printStudents();
        Map<Subject, List<Student>> allSubjects = studentDatabase.printSubjects();

        Assertions.assertEquals(1, allStudents.get(student1).size());
        Assertions.assertEquals(1, allStudents.get(student2).size());

        Assertions.assertEquals(allStudents.get(student1), Map.of(math, 5));
        Assertions.assertEquals(allStudents.get(student2), Map.of(russian, 5));

        Assertions.assertEquals(1, allSubjects.get(russian).size());
        Assertions.assertEquals(1, allSubjects.get(math).size());

        Assertions.assertEquals(allSubjects.get(math), List.of(student1));
        Assertions.assertEquals(allSubjects.get(russian), List.of(student2));
    }

}