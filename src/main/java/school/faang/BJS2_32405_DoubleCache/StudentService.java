package school.faang.BJS2_32405_DoubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private final Map<Student, Map<Subject, Integer>> STUDENT_TO_SCORES;
    private final Map<Subject, List<Student>> SUBJECT_TO_STUDENTS;

    public StudentService() {
        STUDENT_TO_SCORES = new HashMap<>();
        SUBJECT_TO_STUDENTS = new HashMap<>();
    }

    public void addStudentSubjectsScores(Student student, Map<Subject, Integer> subjectsScores) {
        if (student == null || subjectsScores == null)
            throw new IllegalArgumentException("Student or subjectsScores can't be null.");
        STUDENT_TO_SCORES.put(student, subjectsScores);
        subjectsScores.keySet().forEach(subject -> SUBJECT_TO_STUDENTS.computeIfAbsent(subject, key -> new ArrayList<>()).add(student));
    }

    public void addStudentSubjectScore(Student student, Subject subject, int score) {
        if (student == null || subject == null)
            throw new IllegalArgumentException("Student or subject can't be null");
        STUDENT_TO_SCORES.computeIfAbsent(student, key -> new HashMap<>()).put(subject, score);
        SUBJECT_TO_STUDENTS.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student can't be null.");
        Map<Subject, Integer> subjectsScores = STUDENT_TO_SCORES.remove(student);
        if (subjectsScores != null) {
            for (Subject subject : subjectsScores.keySet()) {
                List<Student> students = SUBJECT_TO_STUDENTS.get(subject);
                students.remove(student);
                if (students.isEmpty())
                    SUBJECT_TO_STUDENTS.remove(subject);
            }
        } else
            System.out.println("There is no such student in DB.");
    }

    public void printAllSubjectsAndStudents() {
        for (var entry: SUBJECT_TO_STUDENTS.entrySet()) {
            System.out.println();
            String studentNames = entry.getValue().stream()
                    .map(Student::getName)
                    .collect(Collectors.joining(", "));
            System.out.println(entry.getKey().getName() + ": " + studentNames);
        }
    }

    public void printAllStudentsScores() {
        for (var studentInfo: STUDENT_TO_SCORES.entrySet()) {
            System.out.println("Scores of student " + studentInfo.getKey() + ":");
            for (var subjectScore: STUDENT_TO_SCORES.get(studentInfo.getKey()).entrySet()) {
                System.out.printf("\t%s: %d\n", subjectScore.getKey(), subjectScore.getValue());
            }
        }
    }

    public int getStudentsCount() {
        return STUDENT_TO_SCORES.size();
    }

    public int getSubjectsCount() {
        return SUBJECT_TO_STUDENTS.size();
    }
}
