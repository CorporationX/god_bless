package school.faang.sprint1.doublecashe;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentDatabaseImplTest {

    //test obj
    private StudentDatabaseImpl database;
    // test data
    private Student student1;
    private Student student2;
    private Student student3;

    private Subject math;
    private Subject history;
    private Subject ela;


    @BeforeEach
    void setUp() {
        database = new StudentDatabaseImpl();

        student1 = new Student("Ava");
        student2 = new Student("Bob");
        student3 = new Student("Cid");

        math = new Subject("Math");
        history = new Subject("History");
        ela = new Subject("ELA");

    }

    @Test
    void addStudentWithGrades() {
        Map<Subject, Integer> grades = Map.of(math, 90, history, 95);
        database.addStudentWithGrades(student1, grades);

        String studentActual = database.printAllStudentsWithGrades();
        String subjectActual = database.printAllSubjects();

        Assertions.assertThat(studentActual).contains(student1.getName())
            .contains(math.getName()).contains(history.getName()).contains("90").contains("95");

        Assertions.assertThat(subjectActual).contains(math.getName()).contains(history.getName())
            .contains(student1.getName());
    }

    @Test
    void addSubjectForStudent() {
        database.addSubjectForStudent(student1, math, 67);

        String studentActual = database.printAllStudentsWithGrades();
        String subjectActual = database.printAllSubjects();

        Assertions.assertThat(studentActual).contains(student1.getName())
            .contains(math.getName()).contains("67");

        Assertions.assertThat(subjectActual).contains(math.getName())
            .contains(student1.getName());
    }

    @Test
    void removeStudent() {
        database.addStudentWithGrades(student1, Map.of(math, 90, ela, 80));
        database.addStudentWithGrades(student2, Map.of(math, 70));

        database.removeStudent(student1);

        String studentsActual = database.printAllStudentsWithGrades();
        String subjectsActual = database.printAllSubjects();

        Assertions.assertThat(studentsActual).doesNotContain(student1.getName())
            .contains(student2.getName());
        Assertions.assertThat(subjectsActual).doesNotContain(student1.getName())
            .contains(student2.getName());
    }

    @Test
    void addSubjectWithStudents() {
        database.addSubjectWithStudents(math, List.of(student1, student2));

        String studentsActual = database.printAllStudentsWithGrades();
        String subjectsActual = database.printAllSubjects();

        Assertions.assertThat(studentsActual).contains(student1.getName()).contains(student2.getName())
            .contains(math.getName());
        Assertions.assertThat(subjectsActual).contains(math.getName())
            .contains(student1.getName()).contains(student2.getName());

    }

    @Test
    void addStudentToSubject() {
        database.addStudentToSubject(student1, history);

        String studentsActual = database.printAllStudentsWithGrades();
        String subjectsActual = database.printAllSubjects();

        Assertions.assertThat(studentsActual).contains(student1.getName()).contains(history.getName());
        Assertions.assertThat(subjectsActual).contains(history.getName()).contains(student1.getName());
    }

    @Test
    void removeStudentFromSubject() {
        database.addStudentWithGrades(student1, Map.of(math, 90, ela, 80));

        database.removeStudentFromSubject(student1, math);

        String studentsActual = database.printAllStudentsWithGrades();
        String subjectsActual = database.printAllSubjects();

        Assertions.assertThat(studentsActual).contains(student1.getName())
            .doesNotContain(math.getName()).contains(ela.getName());
        Assertions.assertThat(subjectsActual)
            .doesNotContain(math.getName() + "\n\tStudent: " + student1.getName())
            .contains(ela.getName(), student1.getName());
    }
}