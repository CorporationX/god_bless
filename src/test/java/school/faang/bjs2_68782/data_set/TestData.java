package school.faang.bjs2_68782.data_set;

import school.faang.bjs2_68782.Student;
import school.faang.bjs2_68782.Subject;

import java.util.List;
import java.util.Map;

public class TestData {
    public static final Student STUDENT1 = new Student("Student 1");
    public static final Student STUDENT2 = new Student("Student 2");
    public static final Student STUDENT3 = new Student("Student 3");
    public static final Student STUDENT4 = new Student("Student 4");
    public static final Subject MATHEMATICS = new Subject("Математика");
    public static final Subject SPORT = new Subject("Физра");
    public static final Subject MUSIC = new Subject("Музыка");
    public static final Subject LAW = new Subject("Право");
    public static final Map<Subject, Integer> ALL_SUBJECTS_WITH_GRADES =
            Map.of(MATHEMATICS, 4,
                    SPORT, 4,
                    MUSIC, 5,
                    LAW, 5);
    public static final Map<Subject, Integer> SOME_SUBJECTS_WITH_CHANGED_GRADES =
            Map.of(MATHEMATICS, 5,
                    SPORT, 3,
                    LAW, 5);
    public static final Map<Subject, Integer> ADDED_SUBJECTS_WITH_GRADES =
            Map.of(MATHEMATICS, 5,
                    SPORT, 3,
                    MUSIC, 5,
                    LAW, 5);
    public static final List<Student> STUDENTS = List.of(
            STUDENT1, STUDENT2, STUDENT3
    );
}
