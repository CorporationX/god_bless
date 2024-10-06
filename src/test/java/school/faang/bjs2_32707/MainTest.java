package school.faang.bjs2_32707;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.bjs2_32707.Main.GROUPED_STUDENTS;
import static school.faang.bjs2_32707.Main.addStudent;
import static school.faang.bjs2_32707.Main.deleteStudent;
import static school.faang.bjs2_32707.Main.findStudentsByFacultyAndYear;
import static school.faang.bjs2_32707.Main.groupStudents;
import static school.faang.bjs2_32707.Main.printAllGroupedStudents;
import static school.faang.bjs2_32707.Main.students;

class MainTest {

    @BeforeEach
    void setUp() {
        students.clear();
        GROUPED_STUDENTS.clear();
    }

    @Test
    void testGroupStudentsAndAddStudent() {
        Student mary = new Student("Mary", "Math", 3);
        Student john = new Student("John", "Sport", 3);
        Student helen = new Student("Helen", "Math", 3);

        assertTrue(GROUPED_STUDENTS.isEmpty());
        students.addAll(List.of(mary, john, helen));
        addStudent("Bob", "Birds", 1);

        for (Student student : students) {
            String facultyYearKey = student.getFaculty() + " " + student.getYear();
            assertTrue(GROUPED_STUDENTS.get(facultyYearKey).contains(student));
        }
    }

    @Test
    void testFindAndDeleteStudent() {
        String name = "Larry";
        String faculty = "Sport";
        int year = 3;
        Student larry = new Student(name, faculty, year);
        String larryKey = faculty + " " + year;
        addStudent(name, faculty, year);
        assertTrue(findStudentsByFacultyAndYear(faculty, year).contains(larry));

        deleteStudent(larry.getName(), larry.getFaculty(), larry.getYear());
        assertFalse(students.contains(larry));
        assertFalse(GROUPED_STUDENTS.get(larryKey).contains(larry));
    }

    @Test
    void testPrintAllGroupedStudents() {
        Student mary = new Student("Mary", "Math", 3);
        Student john = new Student("John", "Sport", 3);
        Student helen = new Student("Helen", "Math", 3);
        students.addAll(List.of(mary, john, helen));
        groupStudents();
        printAllGroupedStudents();
    }
}