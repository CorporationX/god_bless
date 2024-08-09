package faang.school.godbless.javahashmap.doublecache;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    private static final Student STUDENT_1 = new Student(1, "John Doe");
    private static final Student STUDENT_2 = new Student(2, "Alex Smith");
    private static final Subject MATH = new Subject(1, "Math");
    private static final Subject SCIENCE = new Subject(2, "Science");
    private static final Subject ENGLISH = new Subject(3, "English");
    private static final String ALL_STUDENTS_INFO = """
            Student: Student(id=2, name=Alex Smith)\r
                Subject: Subject(id=1, name=Math), Mark: 4\r
            Student: Student(id=1, name=John Doe)\r
                Subject: Subject(id=1, name=Math), Mark: 5\r
                Subject: Subject(id=2, name=Science), Mark: 3\r
            """;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @Test
    void testAddStudent() {
        University university = new University();
        Map<Subject, Integer> marks = new HashMap<>();
        marks.put(MATH, 5);
        marks.put(SCIENCE, 3);

        university.addStudent(STUDENT_1, marks);

        Map<Student, Map<Subject, Integer>> studentMarks = university.getStudentMarks();
        assertEquals(1, studentMarks.size());
        assertTrue(studentMarks.containsKey(STUDENT_1));
        Map<Subject, Integer> subjectIntegerMap = studentMarks.get(STUDENT_1);
        assertEquals(5, subjectIntegerMap.get(MATH));
        assertEquals(3, subjectIntegerMap.get(SCIENCE));

        Map<Subject, List<Student>> studentsBySubject = university.getStudentsBySubject();
        assertEquals(2, studentsBySubject.size());
        assertTrue(studentsBySubject.containsKey(MATH));
        assertTrue(studentsBySubject.containsKey(SCIENCE));
        List<Student> studentsMath = studentsBySubject.get(MATH);
        assertEquals(1, studentsMath.size());
        assertTrue(studentsMath.contains(STUDENT_1));
        List<Student> studentsScience = studentsBySubject.get(SCIENCE);
        assertEquals(1, studentsScience.size());
        assertTrue(studentsScience.contains(STUDENT_1));
    }

    @Test
    void testAddSubjectForStudent() {
        University university = new University();

        university.addSubjectForStudent(ENGLISH, STUDENT_1, 4);
        university.addSubjectForStudent(MATH, STUDENT_1, 5);
        university.addSubjectForStudent(SCIENCE, STUDENT_2, 3);
        university.addSubjectForStudent(MATH, STUDENT_2, 4);

        Map<Student, Map<Subject, Integer>> studentMarks = university.getStudentMarks();
        assertEquals(2, studentMarks.size());
        assertTrue(studentMarks.containsKey(STUDENT_1));
        assertTrue(studentMarks.containsKey(STUDENT_2));
        Map<Subject, Integer> subjectIntegerStudent1 = studentMarks.get(STUDENT_1);
        assertEquals(2, subjectIntegerStudent1.size());
        assertEquals(5, subjectIntegerStudent1.get(MATH));
        assertEquals(4, subjectIntegerStudent1.get(ENGLISH));
        Map<Subject, Integer> subjectIntegerStudent2 = studentMarks.get(STUDENT_2);
        assertEquals(2, subjectIntegerStudent2.size());
        assertEquals(3, subjectIntegerStudent2.get(SCIENCE));
        assertEquals(4, subjectIntegerStudent2.get(MATH));

        Map<Subject, List<Student>> studentsBySubject = university.getStudentsBySubject();
        assertEquals(3, studentsBySubject.size());
        assertTrue(studentsBySubject.containsKey(MATH));
        assertTrue(studentsBySubject.containsKey(SCIENCE));
        assertTrue(studentsBySubject.containsKey(ENGLISH));
        List<Student> studentsMath = studentsBySubject.get(MATH);
        assertEquals(2, studentsMath.size());
        assertTrue(studentsMath.contains(STUDENT_1));
        assertTrue(studentsMath.contains(STUDENT_2));
        List<Student> studentsScience = studentsBySubject.get(SCIENCE);
        assertEquals(1, studentsScience.size());
        assertTrue(studentsScience.contains(STUDENT_2));
        List<Student> studentsEnglish = studentsBySubject.get(ENGLISH);
        assertEquals(1, studentsEnglish.size());
        assertTrue(studentsEnglish.contains(STUDENT_1));
    }

    @Test
    void testRemoveStudent() {
        University university = new University();
        Map<Subject, Integer> marks = new HashMap<>();
        marks.put(MATH, 5);
        marks.put(SCIENCE, 3);
        university.addStudent(STUDENT_1, marks);
        university.addSubjectForStudent(MATH, STUDENT_2, 4);

        university.removeStudent(STUDENT_1);

        Map<Student, Map<Subject, Integer>> studentMarks = university.getStudentMarks();
        assertEquals(1, studentMarks.size());
        assertTrue(studentMarks.containsKey(STUDENT_2));
        Map<Subject, Integer> subjectMarkMap = studentMarks.get(STUDENT_2);
        assertEquals(1, subjectMarkMap.size());
        assertEquals(4, subjectMarkMap.get(MATH));

        Map<Subject, List<Student>> studentsBySubject = university.getStudentsBySubject();
        assertEquals(1, studentsBySubject.size());
        assertTrue(studentsBySubject.containsKey(MATH));
        List<Student> studentsMath = studentsBySubject.get(MATH);
        assertEquals(1, studentsMath.size());
        assertTrue(studentsMath.contains(STUDENT_2));
    }

    @Test
    void testPrintStudentMarks() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        University university = new University();
        Map<Subject, Integer> marks = new HashMap<>();
        marks.put(MATH, 5);
        marks.put(SCIENCE, 3);
        university.addStudent(STUDENT_1, marks);
        university.addSubjectForStudent(MATH, STUDENT_2, 4);

        university.printStudentMarks();

        assertEquals(ALL_STUDENTS_INFO, outContent.toString());
        System.setOut(originalOut);
    }
}