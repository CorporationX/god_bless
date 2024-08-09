package faang.school.godbless.doublecache;

import java.util.Map;

public class UserService {
    public void addStudentWithSubject(Map<Student, Map<Subject, Integer>> studentMap, Student student, Map<Subject, Integer> subjectsGrades) {
        studentMap.put(student, subjectsGrades);
    }

    public void addSubjectForStudent(Map<Student, Map<Subject, Integer>> studentMap, Student student, Subject subject, Integer grade) {
        studentNullCheck(studentMap, student);
        studentMap.get(student).put(subject, grade);
    }

    public void removeStudentWithSubjects(Map<Student, Map<Subject, Integer>> studentMap, Student student) {
        studentNullCheck(studentMap, student);
        studentMap.remove(student);
    }

    public void showStudentsInfo(Map<Student, Map<Subject, Integer>> studentMap) {
        studentMap.forEach((student, subjectsAndGrades) -> {
            System.out.println(student.getName() + ": ");
            subjectsAndGrades.forEach(this::printSubjectAndGrade);
        });
    }

    private void studentNullCheck(Map<Student, Map<Subject, Integer>> studentMap, Student student) {
        if (!studentMap.containsKey(student)) {
            throw new IllegalArgumentException("The student doesn't not exist in the map");
        }
    }

    private void printSubjectAndGrade(Subject subject, Integer grade) {
        System.out.println(" Subject: " + subject.getName() +
                ", Grade: " + grade);
    }
}
