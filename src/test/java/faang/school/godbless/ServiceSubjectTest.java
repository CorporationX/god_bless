package faang.school.godbless;

import faang.school.godbless.university.ServiceSubject;
import faang.school.godbless.university.Student;
import faang.school.godbless.university.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ServiceSubjectTest {
    private ServiceSubject service = new ServiceSubject();

    @BeforeEach
    void setUp() {
        service = new ServiceSubject();
    }

    @Test
    void testCreateStudentBySubject_Positive() {
        var subject = new Subject(1, "su1");
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "st1"));
        students.add(new Student(2, "st2"));

        Map<Subject, List<Student>> expected = Map.of(subject, students);
    }
}