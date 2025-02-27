package school.faang.double_cache_system.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.double_cache_system.Student;
import school.faang.double_cache_system.StudentDatabase;
import school.faang.double_cache_system.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentDatabaseTest {

    //test data
    private Student student1;
    private Student student2;
    private Subject math;
    private Subject physics;
    private Map<Subject, Integer> subjectsWithMarks;

    @BeforeEach
    void setUp() {
        student1 = new Student("Alice");
        student2 = new Student("Bob");
        math = new Subject("Math");
        physics = new Subject("Physics");

        subjectsWithMarks = new HashMap<>();
        subjectsWithMarks.put(math, 90);
        subjectsWithMarks.put(physics, 85);
    }

    //positive
    @Test
    //displayname
    void testAddNewStudentWithHisSubjectsWithMarks() {
        //act
        StudentDatabase.addNewStudentWithHisSubjectsWithMarks(student1, subjectsWithMarks);
        assertTrue(StudentDatabase.studentSubjects.containsKey(student1));
        //assert
        assertEquals(2, StudentDatabase.studentSubjects.get(student1).size());
        assertEquals(90, StudentDatabase.studentSubjects.get(student1).get(math));
    }

    @Test
    void testAddNewSubjectToTheExistingStudent() {
        Subject chemistry = new Subject("Chemistry");
        StudentDatabase.addNewSubjectToTheExistingStudent(student1, chemistry);

        assertTrue(StudentDatabase.studentSubjects.get(student1).containsKey(chemistry));
        assertEquals(0, StudentDatabase.studentSubjects.get(student1).get(chemistry));
    }

    @Test
    void testRemoveStudentWithHisSubjects() {
        StudentDatabase.removeStudentWithHisSubjects(student1);

        assertFalse(StudentDatabase.studentSubjects.containsKey(student1));
        assertFalse(StudentDatabase.subjectsStudents.get(math).contains(student1));
    }

    @Test
    void testAddSubjectWithStudents() {
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2));
        StudentDatabase.addSubjectWithStudents(math, students);

        assertTrue(StudentDatabase.subjectsStudents.containsKey(math));
        assertEquals(2, StudentDatabase.subjectsStudents.get(math).size());
    }

    @Test
    void testAddStudentToTheExistingSubject() {
        StudentDatabase.addStudentToTheExistingSubject(student2, math);

        assertTrue(StudentDatabase.subjectsStudents.get(math).contains(student2));
    }

    @Test
    void testRemoveStudentFromSubject() {
        StudentDatabase.removeStudentFromSubject(student1, math);

        assertFalse(StudentDatabase.studentSubjects.get(student1).containsKey(math));
        assertFalse(StudentDatabase.subjectsStudents.get(math).contains(student1));
    }

    //negative

}
