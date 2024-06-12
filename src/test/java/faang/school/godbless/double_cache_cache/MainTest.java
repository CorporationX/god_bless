package faang.school.godbless.double_cache_cache;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    void DoubleWhiteSpace() {
        System.out.println();
        System.out.println();
    }

    @Test
    public void testStatistics() {
        System.out.println("-------------Statistics-------------");
        Main main = new Main();
        Student student1 = new Student("George", 218944123);

        Subject course1 = new Subject("EECS3101: Design and Analysis of Algorithms", 3101);
        Subject course2 = new Subject("EECS3421: Introduction to Database Systems", 3421);
        Subject course3 = new Subject("EECS4412: Data Mining", 4412);
        main.addStudent(student1, Map.of(course1, 75, course2, 64, course3, 79));
        main.statistics();
        DoubleWhiteSpace();
    }

    @Test
    public void testAddStudents() {
        System.out.println("-------------Add Students-------------");
        Main main = new Main();
        Student student1 = new Student("George", 218944123);
        Student student2 = new Student("Dmitrii", 218942223);

        Subject course1 = new Subject("EECS3101: Design and Analysis of Algorithms", 3101);
        Subject course2 = new Subject("EECS3421: Introduction to Database Systems", 3421);
        Subject course3 = new Subject("EECS4412: Data Mining", 4412);
        main.addStudent(student2, Map.of(course1, 69, course3, 75));
        main.addStudent(student1, Map.of(course1, 75, course2, 64, course3, 79));
        main.statistics();
        DoubleWhiteSpace();
    }

    @Test
    public void testEnroll() {
        System.out.println("-------------Enroll Student-------------");
        Main main = new Main();
        Student student1 = new Student("George", 218944123);

        Subject course1 = new Subject("EECS3101: Design and Analysis of Algorithms", 3101);
        Subject course2 = new Subject("EECS3421: Introduction to Database Systems", 3421);
        Subject course3 = new Subject("EECS4412: Data Mining", 4412);
        main.addStudent(student1, new HashMap<>(Map.of(course1, 75, course2, 64)));
        main.statistics();
        main.enrollStudent(student1,  course3, 79);
        System.out.println("Enrolled: " + student1);
        main.statistics();
        DoubleWhiteSpace();
    }

    @Test
    public void testGraduate() {
        System.out.println("-------------Graduate-------------");
        Main main = new Main();
        Student student1 = new Student("George", 218944123);
        Student student2 = new Student("Dmitrii", 218942223);

        Subject course1 = new Subject("EECS3101: Design and Analysis of Algorithms", 3101);
        Subject course2 = new Subject("EECS3421: Introduction to Database Systems", 3421);
        Subject course3 = new Subject("EECS4412: Data Mining", 4412);
        main.addStudent(student2, Map.of(course1, 69, course3, 75));
        main.addStudent(student1, Map.of(course1, 75, course2, 64, course3, 79));
        main.statistics();
        main.graduateStudent(student1);
        System.out.println("Graduated: " + student1);
        main.statistics();
        DoubleWhiteSpace();
    }
}