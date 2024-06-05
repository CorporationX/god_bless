package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class ServiceStudent {

    public Map<Student, Map<Subject, Integer>>  createSubjectByStudent(
            Student student, Map<Subject, Integer> subjectsWithGrade) {
        if(student == null || subjectsWithGrade.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Map<Student, Map<Subject, Integer>> subjectByStudent = new HashMap<>();
        subjectByStudent.put(student, subjectsWithGrade);
        return subjectByStudent;
    }

    public Map<Student, Map<Subject, Integer>> addNewSubjectsToStudent(
            Map<Student, Map<Subject, Integer>> subjectByStudent, Student student,
            Subject subject, int grade) {
        if(student == null || subjectByStudent.isEmpty()) {
            throw new IllegalArgumentException();
        }
        subjectByStudent.get(student).put(subject, grade);
        return subjectByStudent;
    }

    public Map<Student, Map<Subject, Integer>> removeStudent(
            Map<Student, Map<Subject, Integer>> subjectByStudent, Student student) {
        if(student == null || subjectByStudent.isEmpty()) {
            throw new IllegalArgumentException();
        }
        subjectByStudent.remove(student);
        return subjectByStudent;
    }

    public void printAllStudents(Map<Student, Map<Subject, Integer>> subjectWithEstimatesByStudent) {
        if(subjectWithEstimatesByStudent.isEmpty()) {
            throw new IllegalArgumentException();
        }
        subjectWithEstimatesByStudent.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
