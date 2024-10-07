package school.faang.BJS229010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_GRADES_BY_SUBJECT = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_TO_STUDENT_LIST = new HashMap<>();

    public static void addStudentAndMarks(Student student, Map<Subject, Integer> studentGraduate) {
        STUDENT_GRADES_BY_SUBJECT.put(student, studentGraduate);
    }

    public void addNewSubjectForExistsStudent(Student student, Subject subject, int score) {
        STUDENT_GRADES_BY_SUBJECT.computeIfAbsent(student, key -> new HashMap<>()).put(subject, score);
    }

    public void deleteStudent(Student student, Subject subject, int score) {
        STUDENT_GRADES_BY_SUBJECT.forEach((st, map) -> {
            if (st.equals(student) && map.containsKey(subject) && map.containsValue(score)) {
                STUDENT_GRADES_BY_SUBJECT.remove(st, map);
            }
        });
    }

    public static void printAllStudentWithScore() {
        STUDENT_GRADES_BY_SUBJECT.forEach((student, map) ->
        {
            System.out.println(student);
            map.forEach((key, value) -> System.out.println(key + " " + value));
        });
    }

    public void addNewStudentAndSubject(Subject subject, List<Student> student) {
        SUBJECT_TO_STUDENT_LIST.put(subject, student);
    }

    public void addStudentToSubject(Subject subject, List<Student> student) {
        SUBJECT_TO_STUDENT_LIST.computeIfAbsent(subject, key -> new ArrayList<>()).addAll(student);
    }

    public void deleteStudentFromSubject(Subject subject, List<Student> student) {
        List<Student> students = SUBJECT_TO_STUDENT_LIST.get(subject);

        if (student != null) {
            students.removeAll(student);
        }

        if (students.isEmpty()) {
            SUBJECT_TO_STUDENT_LIST.remove(subject);
        }
    }

    public void printAllSubjectsAndStudents() {
        SUBJECT_TO_STUDENT_LIST.forEach((subject, students) -> System.out.println(subject + ":" + students));
    }
}





