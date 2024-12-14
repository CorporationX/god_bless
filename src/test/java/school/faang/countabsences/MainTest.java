package school.faang.countabsences;

import org.junit.jupiter.api.Test;
import school.faang.countabsences.students.Group;
import school.faang.countabsences.students.Student;
import school.faang.countabsences.students.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest {

    @Test
    public void testStudentsGrouping() {
        Student s1 = new Student("name_1", "faculty_1", 1);
        Student s2 = new Student("name_2", "faculty_2", 3);
        Student s3 = new Student("name_3", "faculty_1", 3);
        Student s4 = new Student("name_4", "faculty_3", 2);
        Student s5 = new Student("name_4", "faculty_1", 1);

        List<Student> students = new ArrayList<>(
                List.of(s1, s2, s3, s4, s5)
        );

        Map<Group, List<Student>> groupedStudents = StudentService.getGroupedStudents(students);
        assertEquals(groupedStudents.get(new Group("faculty_1", 1)), List.of(s1, s5));
        assertEquals(groupedStudents.get(new Group("faculty_2", 3)), List.of(s2));
        assertEquals(groupedStudents.get(new Group("faculty_1", 3)), List.of(s3));
        assertEquals(groupedStudents.get(new Group("faculty_3", 2)), List.of(s4));

        assertNull(groupedStudents.get(new Group("faculty_4", 2)));
        assertNull(groupedStudents.get(new Group("faculty_1", 2)));
    }
}
