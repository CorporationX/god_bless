package school.faang.bjs2_32476_DoubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> studentToSubjectMap = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectToStudentMap = new HashMap<>();

    public static void main(String[] args) {

    }

    private static void updateStudent(Student student, HashMap<Subject, Integer> scores) {
        studentToSubjectMap.computeIfAbsent(student, k -> scores).putAll(scores);
    }

    private static void removeStudent(Student student) {
        studentToSubjectMap.remove(student);
    }

    private static void displayStudents() {
        for (var entry : studentToSubjectMap.entrySet()) {
            Student student = entry.getKey();
            System.out.printf("Student %s (id #%d). ", student.getName(), student.getId());
            var scores = entry.getValue();
            for (var subjectScore : scores.entrySet()) {
                Subject subject = subjectScore.getKey();
                int score = subjectScore.getValue();
                System.out.printf("%s, score: %d; ", subject.getName(), score);
            }
            System.out.println();
        }
    }

    private static void updateSubject(Subject subject, List<Student> studentList) {
        subjectToStudentMap.computeIfAbsent(subject, k -> new ArrayList<>()).addAll(studentList);
    }

    private static void removeStudentFromSubject(Subject subject, Student student) {
        subjectToStudentMap.get(subject).remove(student);
    }

    private static void displaySubjects() {
        for (var entry : subjectToStudentMap.entrySet()) {
            Subject subject = entry.getKey();
            System.out.printf("%s (id #%d). Students: ", subject.getName(), subject.getId());
            List<Student> studentList = entry.getValue();
            for (Student student : studentList) {
                System.out.printf("%s (id #%d), ", student.getName(), student.getId());
            }
            System.out.println();
        }
    }
}
