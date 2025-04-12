import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.cache.Student;
import school.faang.cache.StudentDatabase;
import school.faang.cache.Subject;

import java.util.HashMap;
import java.util.Map;

public class StudentDatabaseTest {
    private StudentDatabase studentDatabase;

    @BeforeEach
    public void setUp () {
        studentDatabase = new StudentDatabase();

        Subject math = new Subject("Математика");
        Subject fiz = new Subject("Физика");
        Subject russia = new Subject("Русский");
        Subject biology = new Subject("Биологи");

        Student oleg = new Student("Олег");
        Student alex = new Student("Алексей");
        Student egor = new Student("Егор");

        Map<Subject, Integer> subjectAndBallForOleg = new HashMap<>();
        Map<Subject, Integer> subjectAndBallForAlex = new HashMap<>();
        Map<Subject, Integer> subjectAndBallForEgor = new HashMap<>();

        subjectAndBallForOleg.put(math, 3);
        subjectAndBallForOleg.put(russia, 5);
        subjectAndBallForEgor.put(biology, 4);
        subjectAndBallForAlex.put(math, 5);
        subjectAndBallForAlex.put(biology, 5);
        subjectAndBallForAlex.put(fiz, 4);
        subjectAndBallForAlex.put(russia, 5);
    }

//    @Test
//    public void testAddNewStudentAndSubjectAWithBall () {
//        studentDatabase.addNewStudentAndSubjectAWithBall(oleg, subjectAndBallForOleg);
//        studentDatabase.addNewStudentAndSubjectAWithBall(alex, subjectAndBallForAlex);
//        studentDatabase.addNewStudentAndSubjectAWithBall(egor, subjectAndBallForEgor);
//
//    }

}
