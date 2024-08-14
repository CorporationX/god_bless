package faang.school.godbless.BJS2_19739;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(new Subject(1, "Chemistry"), 5);
        subjects.put(new Subject(2, "Mathematics"), 5);
        subjects.put(new Subject(3, "Physics"), 5);
        Map<Student, Map<Subject, Integer>> students = new HashMap<>();
        students.put(new Student(1, "Kyle"), subjects);

        studentService = new StudentService(students);
        studentService.printStudents();
    }

    @Test
    public void testAddingStudent() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(new Subject(4, "Biology"), 5);
        subjects.put(new Subject(5, "English"), 4);
        subjects.put(new Subject(2, "Mathematics"), 5);

        studentService.addStudent(new Student(2, "Richard"), subjects);

        assertEquals(2, studentService.getStudents().size());

        studentService.addStudent(new Student(1, "Kyle"), subjects);

        assertEquals(5, studentService.getStudents().get(new Student(1, "Kyle")).size());
    }

    @Test
    public void testAddingSubject(){
        studentService.addSubject(new Student(1, "Kyle"), new Subject(6, "Geography"), 5);

        assertEquals(4, studentService.getStudents().get(new Student(1, "Kyle")).size());
    }

    @Test
    public void testRemoveStudent(){
        studentService.removeStudent(new Student(1, "Kyle"));

        assertEquals(0, studentService.getStudents().size());
    }

    @Test
    public void testAddingSubjectWithAbsentStudent(){
        assertThrows(IllegalArgumentException.class, () -> studentService.addSubject(new Student(3, "Roman"), new Subject(4, "Geography"), 5));
    }
}
