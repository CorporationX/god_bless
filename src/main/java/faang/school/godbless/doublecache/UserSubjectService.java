package faang.school.godbless.doublecache;

import java.util.HashMap;
import java.util.Map;

public class UserSubjectService {
    public void addStudentWithSubject(Map<Student, Map<Subject, Integer>> studentMap, Student student, Map<Subject, Integer> subjectsGrades) {
        studentMap.put(student, subjectsGrades);
    }

    public void addSubjectForStudent(Map<Student, Map<Subject, Integer>> studentMap, Student student, Subject subject, Integer grade) {
        studentMap.computeIfAbsent(student, value -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudentWithSubjects(Map<Student, Map<Subject, Integer>> studentMap, Student student) {
        var subjectGradeMap = studentMap.remove(student);
        subjectGradeNullCheck(subjectGradeMap);
    }

    public void showStudentsInfo(Map<Student, Map<Subject, Integer>> studentMap) {
        studentMap.forEach((student, subjectsAndGrades) -> {
            System.out.println(student.getName() + ": ");
            subjectsAndGrades.forEach(this::printSubjectAndGrade);
        });
    }

    private void subjectGradeNullCheck(Map<Subject, Integer> subjectGradeMap) {
        if (subjectGradeMap == null) {
            System.out.println("Subject and grade for this student don't exist");
        }
    }

    private void printSubjectAndGrade(Subject subject, Integer grade) {
        System.out.println(" Subject: " + subject.getName() +
                ", Grade: " + grade);
    }
}
