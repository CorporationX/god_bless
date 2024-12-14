package faang.school.godbless.counting_absences;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {
        Main main = new Main();
        Student student1 = new Student("George", "EECS", 2021);
        Student student2 = new Student("Dmitrii", "EECS", 2021);
        Student student3 = new Student("Huseyn", "EECS", 2019);
        Student student4 = new Student("Andrew", "FINE", 2021);
        Student student5 = new Student("Amy", "NURS", 2018);

        Map<Tuple<String,Integer>, List<Student>> listOfStudents = Main.generate(List.of(student1, student3, student4, student5));
        System.out.println(listOfStudents);
        main.setUniversity(listOfStudents);
        main.getFacultyAndYear("EECS", 2021);
        main.enrollStudent(student2);
        main.getFacultyAndYear("EECS", 2021);
        main.expelStudent(student4);
        main.printAll();
    }
}