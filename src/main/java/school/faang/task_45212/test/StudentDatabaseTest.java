package school.faang.task_45212.test;


import school.faang.task_45212.Student;
import school.faang.task_45212.StudentDatabase;
import school.faang.task_45212.Subject;

import java.util.*;


public class StudentDatabaseTest {
    private final StudentDatabase studentDatabase = new StudentDatabase();
    private final Student alexey = new Student(1, "Алексей");
    private final Student sergey = new Student(2, "Сергей");
    private final Subject math = new Subject(1, "Математика");
    private final Subject physics = new Subject(2, "Физика");
    private final Subject chemistry = new Subject(3, "Химия");


    @Test
    public void testAddStudent() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(math, 5);
        grades.put(physics, 4);
        studentDatabase.addStudent(alexey, grades);
        Map<Subject, Integer> result = studentDatabase.getStudentGrades().get(alexey);
        assertEquals(grades, result);
    }

    @Test
    public void testAddSubjectForStudent() {
        studentDatabase.addStudent(alexey, new HashMap<>());
        studentDatabase.addSubjectForStudent(alexey, math, 5);
        Map<Subject, Integer> grades = studentDatabase.getStudentGrades().get(alexey);
        assertNotNull(grades);
        assertEquals(1, grades.size());
        assertEquals(Integer.valueOf(5), grades.get(math));
    }

    @Test
    public void testRemoveStudent() {
        studentDatabase.addStudent(alexey, new HashMap<>());
        studentDatabase.removeStudent(alexey);
        assertFalse(studentDatabase.getStudentGrades().containsKey(alexey));
    }

    @Test
    public void testPrintAllStudentsAndGrades() {
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 5);
        grades1.put(physics, 4);
        studentDatabase.addStudent(alexey, grades1);
        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(math, 3);
        grades2.put(physics, 5);
        studentDatabase.addStudent(sergey, grades2);
        studentDatabase.printAllStudents();
    }

    @Test
    public void testAddSubjectWithStudents() {
        List<Student> students = Arrays.asList(alexey, sergey);
        studentDatabase.addSubject(chemistry, students);
        List<Student> result = studentDatabase.getSubjectStudents().get(chemistry);
        assertEquals(students.size(), result.size());
        assertTrue(result.containsAll(students));
    }

    @Test
    public void testAddStudentToSubject() {
        studentDatabase.addSubject(chemistry, new ArrayList<>());
        studentDatabase.addStudentToSubject(alexey, chemistry);
        List<Student> result = studentDatabase.getSubjectStudents().get(chemistry);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(alexey));
    }

    @Test
    public void testRemoveStudentFromSubject() {
        List<Student> students = new ArrayList<>();
        students.add(alexey);
        studentDatabase.addSubject(chemistry, students);
        studentDatabase.removeStudentFromSubject(alexey, chemistry);
        List<Student> result = studentDatabase.getSubjectStudents().get(chemistry);
        assertNotNull(result);
        assertFalse(result.contains(alexey));
    }

    @Test
    public void testPrintAllSubjectsAndStudents() {
        List<Student> students = Arrays.asList(alexey, sergey);
        studentDatabase.addSubject(chemistry, students);
        studentDatabase.printAllSubjects();
    }
}
