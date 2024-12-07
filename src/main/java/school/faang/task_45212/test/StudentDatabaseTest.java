package school.faang.task_45212.test;

import org.junit.jupiter.api.BeforeEach;
import school.faang.task_45212.Student;
import school.faang.task_45212.StudentDatabase;
import school.faang.task_45212.Subject;

public class StudentDatabaseTest {
    private final StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeEach
    public void setUp() {
        var alexey = new Student(1, "Алексей");
        var sergey = new Student(2, "Сергей");
        var math = new Subject(1, "Математика");
        var physics = new Subject(2, "Физика");
        var chemistry = new Subject(3, "Химия");
    }

    @Test
    public void testAddStudent() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subject1, 5);
        grades.put(subject2, 4);
        studentDatabase.addStudent(student1, grades);
        Map<Subject, Integer> result = studentDatabase.getStudentGrades().get(student1);
        assertEquals(grades, result);
    }

    @Test
    public void testAddSubjectForStudent() {
        studentDatabase.addStudent(student1, new HashMap<>());
        studentDatabase.addSubjectForStudent(student1, subject1, 5);
        Map<Subject, Integer> grades = studentDatabase.getStudentGrades().get(student1);
        assertNotNull(grades);
        assertEquals(1, grades.size());
        assertEquals(Integer.valueOf(5), grades.get(subject1));
    }

    @Test
    public void testRemoveStudent() {
        studentDatabase.addStudent(student1, new HashMap<>());
        studentDatabase.removeStudent(student1);
        assertFalse(studentDatabase.getStudentGrades().containsKey(student1));
    }

    @Test
    public void testPrintAllStudentsAndGrades() {
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(subject1, 5);
        grades1.put(subject2, 4);
        studentDatabase.addStudent(student1, grades1);
        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(subject1, 3);
        grades2.put(subject2, 5);
        studentDatabase.addStudent(student2, grades2);
        studentDatabase.printAllStudentsAndGrades();
    }

    @Test
    public void testAddSubjectWithStudents() {
        List<Student> students = Arrays.asList(student1, student2);
        studentDatabase.addSubjectWithStudents(subject3, students);
        List<Student> result = studentDatabase.getSubjectStudents().get(subject3);
        assertEquals(students.size(), result.size());
        assertTrue(result.containsAll(students));
    }

    @Test
    public void testAddStudentToSubject() {
        studentDatabase.addSubjectWithStudents(subject3, new ArrayList<>());
        studentDatabase.addStudentToSubject(student1, subject3);
        List<Student> result = studentDatabase.getSubjectStudents().get(subject3);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(student1));
    }

    @Test
    public void testRemoveStudentFromSubject() {
        List<Student> students = new ArrayList<>();
        students.add(student1);
        studentDatabase.addSubjectWithStudents(subject3, students);
        studentDatabase.removeStudentFromSubject(student1, subject3);
        List<Student> result = studentDatabase.getSubjectStudents().get(subject3);
        assertNotNull(result);
        assertFalse(result.contains(student1));
    }

    @Test
    public void testPrintAllSubjectsAndStudents() {
        List<Student> students = Arrays.asList(student1, student2);
        studentDatabase.addSubjectWithStudents(subject3, students);
        studentDatabase.printAllSubjectsAndStudents();
    }
}
