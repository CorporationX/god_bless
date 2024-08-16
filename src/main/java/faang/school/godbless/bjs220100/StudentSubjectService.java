package faang.school.godbless.bjs220100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSubjectService {
    public void addStudentsGrade(Map<Student, Map<Subject, Integer>> subjectsAndGradesByStudent,
                                 Student student, Subject subject, int grade) {
        subjectsAndGradesByStudent.computeIfAbsent(student, s -> new HashMap<>()).put(subject, grade);
    }

    public void deleteStudent(Map<Student, Map<Subject, Integer>> subjectsAndGradesByStudent, Student student) {
        subjectsAndGradesByStudent.remove(student);
    }

    public void printStudentsGrades(Map<Student, Map<Subject, Integer>> subjectsAndGradesByStudent) {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : subjectsAndGradesByStudent.entrySet()) {
            System.out.println("Student: " + entry.getKey().getName());
            for (Map.Entry<Subject, Integer> e : entry.getValue().entrySet()) {
                System.out.println(e.getKey().getName() + ": " + e.getValue());
            }
        }
    }

    public void addSubjectAndStudent(Map<Subject, List<Student>> studentsBySubject, Subject subject, Student student) {
        studentsBySubject
                .computeIfAbsent(subject, s -> new ArrayList<>())
                .add(student);
    }

    public void deleteStudentFromSubject(Map<Subject, List<Student>> studentsBySubject, Subject subject, Student student) {
        studentsBySubject
                .get(subject)
                .remove(student);
    }

    public void printSubjectsAndStudents(Map<Subject, List<Student>> studentsBySubject) {
        for(Map.Entry<Subject, List<Student>> entry : studentsBySubject.entrySet()) {
            System.out.println("Subject: " + entry.getKey().getName());
            entry
                    .getValue()
                    .forEach(student -> System.out.println(student.getName()));
        }
    }


}
