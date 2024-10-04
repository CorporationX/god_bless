package counting_absenteeism;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void addStudent() {
        Student student = new Student("Jane", "Theatre", 3);
        Main.addStudent(student);

        assertEquals(2, Main.getStudents().size());

        Main.removeStudent(student);
    }

    @Test
    void removeStudent() {
        Student student = new Student("Jane", "Theatre", 3);
        Main.addStudent(student);

        assertEquals(1, Main.getStudents().size());

        Main.removeStudent(student);

        assertEquals(0, Main.getStudents().size());
    }

    @Test
    void getStudents() {
        Student student = new Student("Jane", "Theatre", 3);
        Main.addStudent(student);
        Map<Course, List<Student>> courseByStudent = Main.getCourseByStudents(Main.getStudents());
        assertEquals(1, Main.getStudents(new Course("Theatre", 3), courseByStudent).size());

        Main.removeStudent(student);
    }

    @Test
    void printAllInfo() {
        Student student = new Student("Jane", "Theatre", 3);
        Main.addStudent(student);
        Map<Course, List<Student>> courseByStudent = Main.getCourseByStudents(Main.getStudents());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.printAllInfo(courseByStudent);
        System.out.println(courseByStudent);

        assertEquals(
                "Course: Course(faculty=Theatre, year=3)\n" +
                        "Students: [Student(name=Jane, faculty=Theatre, year=3)]\n" +
                        "{Course(faculty=Theatre, year=3)=[Student(name=Jane, faculty=Theatre, year=3)]}\n",
                outContent.toString()
        );

        System.setOut(originalOut);

        Main.removeStudent(student);
    }

    @Test
    void getCourseByStudents() {
        Main.addStudent(new Student("John", "Computer Science", 3));
        
        assertEquals(1, Main.getCourseByStudents(Main.getStudents()).size());
        assertEquals(1, Main.getCourseByStudents(Main.getStudents()).get(new Course("Computer Science", 3)).size());
        assertEquals("{Course(faculty=Computer Science, year=3)=[Student(name=John, faculty=Computer Science, year=3)]}", Main.getCourseByStudents(Main.getStudents()).toString());
    }
}