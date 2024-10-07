package school.faang.BJS229010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_GRADES_BY_SUBJECT = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_TO_STUDENT_LIST = new HashMap<>();

    public static void main(String[] args) {
        Student student = new Student(1, "Ivan");
        Student student2 = new Student(1, "Ivan2");

        addStudentAndMark(student, new Subject(1, "Math"), 90);
        addStudentAndMark(student2, new Subject(1, "Math"), 90);

        System.out.println(STUDENT_GRADES_BY_SUBJECT);
        System.out.println(SUBJECT_TO_STUDENT_LIST);

        System.out.println();
        System.out.println();

        Map<Subject, Integer> mapOfStudentsGrade = new HashMap<>();
        addNewSubjectForExistsStudent(student2, mapOfStudentsGrade);
        System.out.println(STUDENT_GRADES_BY_SUBJECT);
        System.out.println(SUBJECT_TO_STUDENT_LIST);

        System.out.println();

        System.out.println(STUDENT_GRADES_BY_SUBJECT);
        System.out.println(SUBJECT_TO_STUDENT_LIST);
        printAllStudentWithScore();

    }

    public static void addStudentAndMark(Student student, Subject subject, int mark) {
        STUDENT_GRADES_BY_SUBJECT.computeIfAbsent(student, value -> new HashMap<>()).put(subject, mark);
        SUBJECT_TO_STUDENT_LIST.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
    }

    public static void addNewSubjectForExistsStudent(Student student, Map<Subject, Integer> subjectGradeMap) {
        if (STUDENT_GRADES_BY_SUBJECT.containsKey(student)) {
            STUDENT_GRADES_BY_SUBJECT.put(student, subjectGradeMap);
        } else {
            throw new IllegalArgumentException("404 student not found " + student);
        }
    }

    public static void deleteStudent(Student student, Subject subject, int score) {
        Map<Subject, Integer> subjectsAndScores = STUDENT_GRADES_BY_SUBJECT.get(student);
        if (subjectsAndScores != null) {
            if (subjectsAndScores.containsKey(subject) && subjectsAndScores.get(subject).equals(score)) {
                subjectsAndScores.remove(subject);
                if (subjectsAndScores.isEmpty()) {
                    STUDENT_GRADES_BY_SUBJECT.remove(student);
                }
            }
        }
    }

    public static void printAllStudentWithScore() {
        STUDENT_GRADES_BY_SUBJECT.forEach((student, map) -> {
            System.out.println(student);
            map.forEach((key, value) -> System.out.println(key + ":" + value));
        });
    }

    public static void deleteStudentFromSubject(Subject subject, List<Student> student) {
        List<Student> studentToRemove = SUBJECT_TO_STUDENT_LIST.get(subject);

        if (student != null) {
            studentToRemove.removeAll(student);
        }

        if (studentToRemove.isEmpty()) {
            SUBJECT_TO_STUDENT_LIST.remove(subject);
        }
    }

    public static void printAllSubjectsAndStudents() {
        SUBJECT_TO_STUDENT_LIST.forEach((subject, students) -> System.out.println(subject + ":" + students));
    }
}





