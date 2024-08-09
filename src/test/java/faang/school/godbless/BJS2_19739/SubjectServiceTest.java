package faang.school.godbless.BJS2_19739;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubjectServiceTest {

    private SubjectService subjectService;

    @BeforeEach
    public void setUp() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Salazar"));
        students.add(new Student(2, "Godrik"));
        students.add(new Student(3, "Rovena"));
        students.add(new Student(4, "Helga"));

        Map<Subject, List<Student>> subjects = new HashMap<>();
        subjects.put(new Subject(1, "Charms"), students);

        subjectService = new SubjectService(subjects);
        subjectService.printSubjects();
    }

    @Test
    public void testAddingSubjectAndStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(5, "Albus"));
        students.add(new Student(6, "Sirius"));
        subjectService.addSubject(new Subject(2, "Herbology"),students);

        assertEquals(2, subjectService.getSubjects().size());
        assertEquals(2, subjectService.getSubjects().get(new Subject(2, "Herbology")).size());

        subjectService.addSubject(new Subject(2, "Herbology"), List.of(new Student(5, "Albus"),
                new Student(6, "Sirius"),
                new Student(7, "Rimus")));

        assertEquals(3, subjectService.getSubjects().get(new Subject(2, "Herbology")).size());
    }

    @Test
    public void testAddingStudentToSubject(){
        subjectService.addStudent(new Subject(1, "Charms"), new Student(5, "Albus"));

        assertEquals(5, subjectService.getSubjects().get(new Subject(1, "Charms")).size());
    }

    @Test
    public void testRemoveStudentFromSubject(){
        subjectService.removeStudent(new Subject(1, "Charms"), new Student(4, "Helga"));

        assertEquals(3, subjectService.getSubjects().get(new Subject(1, "Charms")).size());
    }

    @Test
    public void testAbsentSubjectToAddOrRemove(){
        assertThrows(IllegalArgumentException.class, () -> subjectService.addStudent(new Subject(2, "Herbology"), new Student(5, "Albus")));
        assertThrows(IllegalArgumentException.class, () -> subjectService.removeStudent(new Subject(2, "Herbology"), new Student(5, "Albus")));
    }

}
