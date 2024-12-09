package faang.school.godbless.sprint_1.task_45274;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConstants {
    public static final Student STUDENT_1 = new Student(1, "Olga");
    public static final Student STUDENT_2 = new Student(2, "Nikolay");
    public static final Student STUDENT_3 = new Student(3, "Irina");
    public static final Student STUDENT_4 = new Student(4, "Sergey");
    public static final Student STUDENT_5 = new Student(5, "Konstantin");

    public static final Subject SUBJECT_1 = new Subject(1, "English");
    public static final Subject SUBJECT_2 = new Subject(2, "Physics");
    public static final Subject SUBJECT_3 = new Subject(3, "Literature");
    public static final Subject SUBJECT_4 = new Subject(4, "Chemistry");
    public static final Subject SUBJECT_5 = new Subject(5, "Mathematics");
    public static final Subject SUBJECT_6 = new Subject(5, "Philosophy");

    public static final Map<Student, Map<Subject, Integer>> STUDENTS_MAP = new HashMap<>() {{
            put(STUDENT_1, new HashMap<>() {{
                    put(SUBJECT_1, 3);
                    }
            });
            put(STUDENT_2, new HashMap<>() {{
                    put(SUBJECT_3, 5);
                    }
            });
            }};

    public static final Map<Subject, List<Student>> SUBJECTS_MAP = new HashMap<>() {{
            put(SUBJECT_1, new ArrayList<>() {{
                    add(STUDENT_1);
                    }
            });
            put(SUBJECT_3, new ArrayList<>() {{
                    add(STUDENT_2);
                    }
            });
            }};
}
