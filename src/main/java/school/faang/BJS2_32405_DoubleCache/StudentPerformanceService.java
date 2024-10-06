package school.faang.BJS2_32405_DoubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentPerformanceService {
    Map<Student, Map<Subject, Integer>> studentToScores;
    Map<Subject, List<Student>> subjectToStudents;

    public StudentPerformanceService() {
        studentToScores = new HashMap<>();
        subjectToStudents = new HashMap<>();
    }

    public void addStudentSubjectsScores(Student student, Map<Subject, Integer> subjectsScores) {
        if (student == null || subjectsScores == null)
            throw new IllegalArgumentException("Student or subjectsScores can't be null.");
        studentToScores.put(student, subjectsScores);
        subjectsScores.keySet().forEach(subject -> subjectToStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student));
    }

    public void addStudentSubjectScore(Student student, Subject subject, int score) {
        if (student == null || subject == null)
            throw new IllegalArgumentException("Student or subject can't be null");
        studentToScores.computeIfAbsent(student, key -> new HashMap<>()).put(subject, score);
        subjectToStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student can't be null.");
        Map<Subject, Integer> subjectsScores = studentToScores.remove(student);
        if (subjectsScores != null) {
            for (Subject subject : subjectsScores.keySet()) {
                List<Student> students = subjectToStudents.get(subject);
                students.remove(student);
                if (students.isEmpty())
                    subjectToStudents.remove(subject);
            }
        } else
            System.out.println("There is no such student in DB.");
    }

    public void printAllStudentsScores() {
        for (var studentInfo: studentToScores.entrySet()) {
            System.out.println("Scores of student " + studentInfo.getKey() + ":");
            for (var subjectScore: studentToScores.get(studentInfo.getKey()).entrySet()) {
                System.out.printf("\t%s: %d\n", subjectScore.getKey(), subjectScore.getValue());
            }
        }
    }

    public int getStudentsCount() {
        return studentToScores.size();
    }

    public int getSubjectsCount() {
        return subjectToStudents.size();
    }
}
