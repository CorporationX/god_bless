package school.faang.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS_GRADES = new HashMap<>();
    private  static final Map<Subject, List<Student>> STUDENTS_STUDYING_SUBJECT = new HashMap<>();

    public static void main(String[] args) {

    }

    public static void addStudentAndSubjects(Student student, Map<Subject, Integer> subjects) {
        if (student == null || subjects == null) {
            throw new IllegalArgumentException("В методе addStudentAndSubjects: Аргументы не должны быть null!")
        }
        STUDENT_SUBJECTS_GRADES.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            STUDENTS_STUDYING_SUBJECT.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }
}
