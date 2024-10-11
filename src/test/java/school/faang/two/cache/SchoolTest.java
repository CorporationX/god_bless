package school.faang.two.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    private School school;

    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;
    private Subject subject3;
    private Map<Subject, Integer> progress1;
    private Map<Subject, Integer> progress2;

    @BeforeEach
    public void setUp() {
        student1 = new Student(1, "Student 1");
        student2 = new Student(2, "Student 2");

        subject1 = new Subject(1, "Subject 1");
        subject2 = new Subject(2, "Subject 2");
        subject3 = new Subject(3, "Subject 3");

        progress1 = new HashMap<>();
        progress1.put(subject1, 5);
        progress1.put(subject2, 4);

        progress2 = new HashMap<>();
        progress2.put(subject1, 3);
        progress2.put(subject3, 5);

        school = new School();
        school.addStudentWithSubjects(student1, progress1);
        school.addStudentWithSubjects(student2, progress2);
    }

    @Test
    public void addStudentWithSubjectsTest() {
        int initialStudentCount = school.getJournal().size();
        Student student3 = new Student(3, "Student 3");
        Map<Subject, Integer> student3progress = new HashMap<>();
        student3progress.put(new Subject(4, "Subject 4"), 5);
        student3progress.put(new Subject(5, "Subject 5"), 4);
        school.addStudentWithSubjects(student3, student3progress);

        Map<Subject, Integer> progress = school.getJournal().get(student3);

        assertEquals(initialStudentCount + 1, school.getJournal().size());
        assertEquals(2, progress.size());
        assertEquals(5, progress.get(new Subject(4, "Subject 4")));
        assertEquals(4, progress.get(new Subject(5, "Subject 5")));
    }

    @Test
    public void addNewSubjectForStudentTest() {
        int initialSubjectCount = school.getJournal().get(student1).size();
        Subject newSubject = new Subject(6, "Subject 6");

        school.addNewSubjectForStudent(student1, newSubject, 5);

        Map<Subject, Integer> updatedProgress = school.getJournal().get(student1);
        assertEquals(initialSubjectCount + 1, updatedProgress.size());
        assertEquals(5, updatedProgress.get(newSubject));
    }

    @Test
    public void deleteStudentWithSubjectTest() {
        school.deleteStudentWithSubject(student1);
        Map<Subject, Integer> updatedProgress = school.getJournal().get(student1);
        assertNull(updatedProgress);
    }

    @Test
    public void printAllStudentsWithSubjectsTest() {
        school.printAllStudentsWithSubjects();
    }

    @Test
    public void addSubjectAndStudentsTest() {
        int initialSubjectCount = school.getSubjectsWithStudents().keySet().size();
        school.addSubjectAndStudents(new Subject(4, "Subject 4"), Collections.singletonList(new Student(4, "Student 4")));

        Set<Subject> subjects = school.getSubjectsWithStudents().keySet();

        assertEquals(initialSubjectCount + 1, subjects.size());
    }

    @Test
    public void addStudentToSubjectTest() {
        Subject subject1 = new Subject(1, "Subject 1");
        int initialSubjectStudentsCount = school.getSubjectsWithStudents().get(subject1).size();

        school.addStudentToSubject(subject1, new Student(4, "Student 4"));

        List<Student> students = school.getSubjectsWithStudents().get(subject1);
        assertEquals(initialSubjectStudentsCount + 1, students.size());
    }

    @Test
    public void removeStudentFromSubjectTest() {
        Subject subject1 = new Subject(1, "Subject 1");
        int initialSubjectStudentsCount = school.getSubjectsWithStudents().get(subject1).size();

        school.removeStudentFromSubject(subject1, new Student(1, "Student 1"));

        List<Student> students = school.getSubjectsWithStudents().get(new Subject(1, "Subject 1"));
        assertEquals(initialSubjectStudentsCount - 1, students.size());
    }

    @Test
    public void printAllSubjectsWithStudentsTest() {
        school.printAllSubjectsWithStudents();
    }
}
