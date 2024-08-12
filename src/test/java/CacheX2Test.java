import faang.school.godbless.cachex2.Main;
import faang.school.godbless.cachex2.Student;
import faang.school.godbless.cachex2.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class CacheX2Test {
    private Main main;
    @BeforeEach
    public void setUp() {
        main = new Main();
    }
    //positive
    @Test
    public void testAllMethods() {
        Student student = new Student(1, "1");
        Map<Subject, Integer> scores = new HashMap<>(Map.of(
                new Subject(1, "1"), 2,
                new Subject(2, "2"), 3,
                new Subject(3, "3"), 4
        ));
        main.addStudentScores(student, scores);

        Assertions.assertEquals(main.getScores().get(student), scores);

    }

}
