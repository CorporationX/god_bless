package faang.school.godbless.absences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private List<Student> studentsList;

    @BeforeEach
    void setUp() {
        studentsList = new ArrayList<>();

        Student student1 = new Student("Alice Johnson", "Computer Science", 2);
        Student student2 = new Student("Bob Smith", "Electrical Engineering", 3);
        Student student3 = new Student("Carol White", "Mechanical Engineering", 4);
        Student student4 = new Student("David Brown", "Civil Engineering", 2);
        Student student5 = new Student("Eve Davis", "Computer Science", 1);
        Student student6 = new Student("Frank Wilson", "Electrical Engineering", 3);
        Student student7 = new Student("Grace Moore", "Mechanical Engineering", 2);
        Student student8 = new Student("Hank Taylor", "Civil Engineering", 4);
        Student student9 = new Student("Ivy Anderson", "Computer Science", 2);
        Student student10 = new Student("Jack Thomas", "Electrical Engineering", 4);

        Collections.addAll(studentsList, student1, student2, student3, student4, student5, student6, student7, student8, student9, student10);
    }

    @Test
    void studentAdditionTest() {
        Student newStudent = new Student("Larry Dickinson", "Computer Science", 2);
        Main.addStudent(studentsList, newStudent);

        assertEquals(11, studentsList.size());
    }

    @Test
    void failedStudentAdditionTest() {
        Student newStudent = new Student("David Brown", "Civil Engineering", 2);

        assertThrows(IllegalArgumentException.class, () -> {
            Main.addStudent(studentsList, newStudent);
        });
    }

    @Test
    void studentDeletionTest() {
        Main.deleteStudent(studentsList, "Alice Johnson", "Computer Science", 2);

        assertEquals(9, studentsList.size());
    }

    @Test
    void failedStudentDeletionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.deleteStudent(studentsList, "Elon Musk", "Rocket Science", 4);
        });
    }
    @Test
    void groupStudentsTest(){
        System.out.println(Main.groupStudents(studentsList));
    }

}
