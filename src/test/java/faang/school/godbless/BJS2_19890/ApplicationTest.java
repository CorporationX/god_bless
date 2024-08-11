package faang.school.godbless.BJS2_19890;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Map<Student, Map<Subject, Integer>> studentsEvaluates;
    Map<Subject, List<Student>> subjectsAndStudents;
    Student student1;
    Student student2;
    Student addingStudent;
    Subject math;
    Subject physics;
    Subject chemistry;
    Subject english;

    @BeforeEach
    void setUp() {
        student1 = new Student(1, "John Doe");
        student2 = new Student(2, "Jack Cruse");
        addingStudent = new Student(3, "John Black");
        math = new Subject(1, "Mathematics");
        physics = new Subject(2, "Physics");
        chemistry = new Subject(3, "Chemistry");
        english = new Subject(4, "English");

        studentsEvaluates = new HashMap<>(Map.copyOf(Application.getStudentsEvaluates()));
        studentsEvaluates.put(student1, new HashMap<>(Map.of(math, 5)));
        studentsEvaluates.put(student2, new HashMap<>(Map.of(physics, 4)));

        subjectsAndStudents = new HashMap<>(Map.copyOf(Application.getSubjectsAndStudents()));
        subjectsAndStudents.put(math, new ArrayList<>(List.of(student1)));
        subjectsAndStudents.put(physics, new ArrayList<>(List.of(student2)));

        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    void addStudent() {
        var givenSubject = new Subject(1, "Mathematics");
        int givenGrade = 5;

        Application.addStudent(addingStudent, givenSubject, givenGrade, studentsEvaluates);

        assertThat(studentsEvaluates).containsKey(addingStudent);
        assertThat(studentsEvaluates).hasSize(3);
    }

    @Test
    void addStudentShouldHasThreeSubjects() {
        Application.addSubjectAndGradeForStudent(addingStudent, physics, 5, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(addingStudent, math, 4, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(addingStudent, english, 4, studentsEvaluates, subjectsAndStudents);

        assertThat(studentsEvaluates).containsKey(addingStudent);
        assertThat(studentsEvaluates).hasSize(3);
        assertThat(studentsEvaluates.get(addingStudent)).hasSize(3);
    }

    @Test
    void everySubjectShouldHasThreeStudents() {
        Application.addSubjectAndGradeForStudent(addingStudent, physics, 5, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(addingStudent, math, 4, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(addingStudent, english, 4, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(student1, physics, 4, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(student1, english, 4, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(student2, math, 4, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(student2, english, 4, studentsEvaluates, subjectsAndStudents);

        assertThat(subjectsAndStudents).containsKey(physics).containsKey(math).containsKey(english);
        assertThat(subjectsAndStudents).hasSize(3);
        assertThat(subjectsAndStudents.get(physics)).hasSize(3);
        assertThat(subjectsAndStudents.get(english)).hasSize(3);
        assertThat(subjectsAndStudents.get(math)).hasSize(3);
    }

    @Test
    void deleteStudent() {
        Application.deleteStudentAndHisGrades(student1, studentsEvaluates, subjectsAndStudents);

        assertThat(studentsEvaluates).doesNotContainKey(student1);
        assertThat(studentsEvaluates).hasSize(1);
    }

    @Test
    void subjectsShouldNotHaveAddingStudent() {
        subjectsAndStudents.put(math, new ArrayList<>(List.of(student1)));
        subjectsAndStudents.put(english, new ArrayList<>(List.of(student2)));

        Application.deleteStudentAndHisGrades(student1, studentsEvaluates, subjectsAndStudents);
        Application.deleteStudentAndHisGrades(student2, studentsEvaluates, subjectsAndStudents);
        assertThat(subjectsAndStudents.get(math)).doesNotContain(student1);
        assertThat(subjectsAndStudents.get(english)).doesNotContain(student2);
        assertThat(subjectsAndStudents).hasSize(3);
        assertThat(subjectsAndStudents.get(math)).hasSize(0);
        assertThat(subjectsAndStudents.get(english)).hasSize(0);
    }

    @Test
    void printStudentsTheirAndSubjects() {
        String expectedOutput = """
                Subjects of student: John Doe
                Mathematics: 5
                Subjects of student: Jack Cruse
                Physics: 4
                """;
        Application.printStudentsTheirAndSubjects(studentsEvaluates);
        assertThat(normalize(outputStreamCaptor.toString())).isEqualTo(normalize(expectedOutput));
    }

    @Test
    void printSubjectsAndStudentsOneStudentShouldHasThreeSubjects() {
        var givenStudent = new Student(3, "John Black");
        int givenGrade = 5;
        String expectedOut = """
                Subjects of student: John Doe
                Mathematics: 5
                Subjects of student: John Black
                English: 3
                Physics: 5
                Mathematics: 4
                Subjects of student: Jack Cruse
                Physics: 4
                """;

        Application.addSubjectAndGradeForStudent(givenStudent, physics, givenGrade, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(givenStudent, math, 4, studentsEvaluates, subjectsAndStudents);
        Application.addSubjectAndGradeForStudent(givenStudent, english, 3, studentsEvaluates, subjectsAndStudents);
        Application.printStudentsTheirAndSubjects(studentsEvaluates);

        assertThat(normalize(outputStreamCaptor.toString())).isEqualTo(normalize(expectedOut));
    }

    @Test
    void deleteStudentFromSubject() {
        Application.deleteStudentFromSubject(math, student1, subjectsAndStudents);
        assertThat(subjectsAndStudents.get(math)).doesNotContain(student1);
        assertThat(subjectsAndStudents.get(math)).isEmpty();
    }

    @Test
    void printSubjectsAndStudents() {
        subjectsAndStudents.computeIfAbsent(math, k -> new ArrayList<>()).add(addingStudent);
        String expectedOutput = """
                Subject Mathematics has next students:
                John Doe
                John Black
                Subject Physics has next students:
                Jack Cruse
                """;
        Application.printSubjectsAndStudents(subjectsAndStudents);
        assertThat(normalize(outputStreamCaptor.toString())).isEqualTo(normalize(expectedOutput));
    }

    private String normalize(String input) {
        return input.strip().replaceAll("\\s+", " ");
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}