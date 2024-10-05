package school.faang.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.university.Main.addStudent;
import static school.faang.university.Main.groupStudentsByFacultyAndYear;
import static school.faang.university.Main.removeStudent;

public class StudentTest {

    @Test
    public void testAddStudent() {
        List<Student> students = new ArrayList<>();
        Student student = new Student("Student1", "Faculty 1", 2023);
        addStudent(students, student);

        assertEquals(1, students.size());
        assertEquals("Student1", students.get(0).getName());
        assertTrue(students.contains(student));
    }

    @Test
    public void testRemoveStudent() {
        Student student = new Student("Student1", "Faculty 1", 2023);
        List<Student> students = new ArrayList<>();
        students.add(student);

        removeStudent(students, "Student1", "Faculty 1", 2023);

        assertEquals(0, students.size());
        assertFalse(students.contains(student));
    }

    @Test
    public void testGroupStudentsByFacultyAndYear() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Student1", "Faculty 1", 2023);
        Student student2 = new Student("Student11", "Faculty 1", 2023);
        addStudent(students, student1);
        addStudent(students, student2);
        addStudent(students, new Student("Student2", "Faculty 2", 2023));
        addStudent(students, new Student("Student31", "Faculty 1", 2024));
        addStudent(students, new Student("Student32", "Faculty 1", 2024));

        Map<FacultyYearDistribution, List<Student>> facultyYearDistributionListMap = groupStudentsByFacultyAndYear(students);

        assertEquals(3, facultyYearDistributionListMap.size());
        assertEquals(2, facultyYearDistributionListMap.get(new FacultyYearDistribution("Faculty 1", 2023)).size());
        assertTrue(facultyYearDistributionListMap.get(new FacultyYearDistribution("Faculty 1", 2023)).containsAll(List.of(student1, student2)));
    }
}
