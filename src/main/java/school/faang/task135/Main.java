package school.faang.task135;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENTS_GRADE = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENT_GROUP_LIST = new HashMap<>();

    public void addNewStudent(Student student, Map<Subject, Integer> subject) {
        STUDENTS_GRADE.put(student, subject);
    }

}
