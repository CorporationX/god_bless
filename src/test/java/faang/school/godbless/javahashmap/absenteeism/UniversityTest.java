package faang.school.godbless.javahashmap.absenteeism;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniversityTest {

    private static final String COMPUTER_SCIENCE_FACULTY = "Computer Science";
    private static final String MATHEMATICS_FACULTY = "Mathematics";
    private static final Student STUDENT_1 = new Student("John Doe", COMPUTER_SCIENCE_FACULTY, 2022);
    private static final Student STUDENT_2 = new Student("Jane Smith", MATHEMATICS_FACULTY, 2022);
    private static final Student STUDENT_3 = new Student("Bob Johnson", COMPUTER_SCIENCE_FACULTY, 2022);
    private static final Student STUDENT_4 = new Student("Alice Brown", COMPUTER_SCIENCE_FACULTY, 2020);

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final String ALL_STUDENTS_GROUPED_INFO = """
            Faculty: Computer Science, Year: 2020\r
               Student(name=Alice Brown, faculty=Computer Science, year=2020)\r
            Faculty: Computer Science, Year: 2022\r
               Student(name=John Doe, faculty=Computer Science, year=2022)\r
               Student(name=Bob Johnson, faculty=Computer Science, year=2022)\r
            Faculty: Mathematics, Year: 2022\r
               Student(name=Jane Smith, faculty=Mathematics, year=2022)\r
            """;

    @Test
    void testAddStudent() {
        University university = new University();
        university.addStudent(STUDENT_1);
        university.addStudent(STUDENT_2);

        List<Student> students = university.getStudents();
        assertEquals(2, students.size());
        assertEquals(STUDENT_1, students.get(0));
        assertEquals(STUDENT_2, students.get(1));
    }

    @Test
    void testRemoveStudent() {
        University university = new University();
        university.addStudent(STUDENT_1);
        university.addStudent(STUDENT_2);
        university.addStudent(STUDENT_3);

        university.removeStudent(STUDENT_2.getName(), STUDENT_2.getFaculty(), STUDENT_2.getYear());

        List<Student> students = university.getStudents();
        assertEquals(2, students.size());
        assertEquals(STUDENT_1, students.get(0));
        assertEquals(STUDENT_3, students.get(1));
    }

    @Test
    void testGetStudentsByFacultyAndYear() {
        University university = new University();
        university.addStudent(STUDENT_1);
        university.addStudent(STUDENT_2);
        university.addStudent(STUDENT_3);
        university.addStudent(STUDENT_4);

        List<Student> students = university.getStudentsByFacultyAndYear(COMPUTER_SCIENCE_FACULTY, 2022);
        assertEquals(2, students.size());
        assertEquals(STUDENT_1, students.get(0));
        assertEquals(STUDENT_3, students.get(1));
    }

    @Test
    void testPrintAllStudentsGroupedByFacultyAndYear() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        University university = new University();
        university.addStudent(STUDENT_1);
        university.addStudent(STUDENT_2);
        university.addStudent(STUDENT_3);
        university.addStudent(STUDENT_4);

        university.printAllStudentsGroupedByFacultyAndYear();

        assertEquals(ALL_STUDENTS_GROUPED_INFO, outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    void testGetAllStudentsByFacultyAndYear() {
        University university = new University();
        university.addStudent(STUDENT_1);
        university.addStudent(STUDENT_2);
        university.addStudent(STUDENT_3);
        university.addStudent(STUDENT_4);

        List<Student> students = university.getStudents();
        HashMap<Pair<String, Integer>, List<Student>> studentsByFacultyAndYear = university.getAllStudentsByFacultyAndYear(students);

        assertEquals(3, studentsByFacultyAndYear.size());
        assertEquals(List.of(STUDENT_4) , studentsByFacultyAndYear.get(new Pair<>(COMPUTER_SCIENCE_FACULTY, 2020)));
        assertEquals(List.of(STUDENT_1, STUDENT_3) , studentsByFacultyAndYear.get(new Pair<>(COMPUTER_SCIENCE_FACULTY, 2022)));
        assertEquals(List.of(STUDENT_2) , studentsByFacultyAndYear.get(new Pair<>(MATHEMATICS_FACULTY, 2022)));
    }
}