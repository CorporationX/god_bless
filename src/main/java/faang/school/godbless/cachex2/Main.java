package faang.school.godbless.cachex2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @Getter
    private Map<Student, Map<Subject, Integer>> scores;
    @Getter
    private Map<Subject, List<Student>> studentsSubjects;

    public Main() {
        scores = new HashMap<>();
        studentsSubjects = new HashMap<>();
    }

    public void addStudentScores(Student student, Map<Subject, Integer> studentScores) {
        scores.put(student, studentScores);
    }

    public void addSubjectScore(Student student, Subject subject, Integer score) {
        scores.computeIfAbsent(student, k -> new HashMap<>()).put(subject, score);
    }

    public void deleteStudentScores(Student student) {
        scores.remove(student);
    }

    public void printStudentsScores() {
        for (Map.Entry<Student, Map<Subject, Integer>> pair : scores.entrySet()) {
            System.out.printf("* " + pair.getKey() + ": ");
            for (Map.Entry<Subject, Integer> subject : pair.getValue().entrySet()) {
                System.out.printf("\t" + subject.getKey() + " - " + subject.getValue());
            }
        }
    }


    public void addSubjectStudents(Subject subject, List<Student> students) {
        studentsSubjects.put(subject, students);
    }

    public void addStudentToSubject(Student student, Subject subject) {
        studentsSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        if (studentsSubjects.get(subject) != null) {
            studentsSubjects.get(subject).remove(student);
        }
    }

    public void printStudentsOnSubjects(){
        for (Map.Entry<Subject, List<Student>> pair : studentsSubjects.entrySet()) {
            System.out.println("* " + pair.getKey());
            for (Student student : pair.getValue()) {
                System.out.println("\t" + student);
            }
        }
    }
}
