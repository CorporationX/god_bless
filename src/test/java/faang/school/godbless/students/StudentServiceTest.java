package faang.school.godbless.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentServiceTest {
    @Test
    void testGroupBy() {
        var st1 = new Student("name1", "f1", 1);
        var st2 = new Student("name2", "f1", 1);
        var st3 = new Student("name3", "f1", 2);
        var st4 = new Student("name3", "f2", 1);

        var groups = StudentService.groupStudents(List.of(st1, st2, st3, st4));

        Assertions.assertAll(
                () -> Assertions.assertEquals(2, groups.get(new FacultyYearTuple("f1", 1)).size()),
                () -> Assertions.assertEquals(1, groups.get(new FacultyYearTuple("f1", 2)).size()),
                () -> Assertions.assertEquals(1, groups.get(new FacultyYearTuple("f2", 1)).size()),
                () -> Assertions.assertTrue(groups.get(new FacultyYearTuple("f1", 1)).containsAll(List.of(st1, st2))),
                () -> Assertions.assertTrue(groups.get(new FacultyYearTuple("f1", 2)).contains(st3)),
                () -> Assertions.assertTrue(groups.get(new FacultyYearTuple("f2", 1)).contains(st4))
        );
    }

    @Test
    void testFindBy() {
        var service = new StudentService();

        var st1 = new Student("name1", "f1", 1);
        var st2 = new Student("name2", "f1", 1);
        var st3 = new Student("name3", "f1", 2);
        var st4 = new Student("name3", "f2", 1);
        service.addStudent(st1);
        service.addStudent(st2);
        service.addStudent(st3);
        service.addStudent(st4);

        var searchResult = service.findBy("f1", 1);

        Assertions.assertAll(
                () -> Assertions.assertEquals(2, searchResult.size()),
                () -> Assertions.assertTrue(searchResult.containsAll(List.of(st1, st2)))
        );
    }

    @Test
    void testAddStudent() {
        var service = new StudentService();
        Assertions.assertTrue(service.findBy("f1", 1).isEmpty());

        var student = new Student("name1", "f1", 1);
        service.addStudent(student);

        var searchResult = service.findBy("f1", 1);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, searchResult.size()),
                () -> Assertions.assertEquals(student, searchResult.get(0))
        );
    }

    @Test
    void testRemoveStudent() {
        var service = new StudentService();

        var st1 = new Student("name1", "f1", 1);
        var st2 = new Student("name2", "f1", 1);
        var st3 = new Student("name3", "f1", 2);
        var st4 = new Student("name3", "f2", 1);
        service.addStudent(st1);
        service.addStudent(st2);
        service.addStudent(st3);
        service.addStudent(st4);
       Assertions.assertEquals(2, service.findBy("f1", 1).size());

        service.removeStudent("name1", "f1", 1);

        Assertions.assertFalse(service.findBy("f1", 1).contains(st1));

    }

}
