package faang.school.godbless.hash.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {

    private final Map<Student, Map<Subject, Integer>> studentGradesMap = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudentsMap = new HashMap<>();

    private void addStudentWithGrades(Student student, Map<Subject, Integer> subjectGradeMap) {
        studentGradesMap.put(student, subjectGradeMap);

        subjectGradeMap.keySet().forEach(subject -> {
            List<Student> students = subjectStudentsMap.computeIfAbsent(subject, k -> new ArrayList<>());
            if (!students.contains(student)) {
                students.add(student);
            }
        });
    }

    private void addSubjectWithGrade(Student student, Subject subject, Integer grade) {
        Map<Subject, Integer> subjectGradeMap = new HashMap<>();
        subjectGradeMap.put(subject, grade);
        addStudentWithGrades(student, subjectGradeMap);
    }

    private void removeStudent(Student student) {
        Map<Subject, Integer> subjectGradeMap = studentGradesMap.get(student);
        if (subjectGradeMap != null) {
            for (Subject subject : subjectGradeMap.keySet()) {
                subjectStudentsMap.get(subject).remove(student);
            }
        }
        studentGradesMap.remove(student);
    }

    private void printAllStudentWithGrades() {
        studentGradesMap.forEach(((student, subjectGradeMap) -> {
            System.out.println(student);
            subjectGradeMap.forEach((subject, grade) ->
                    System.out.printf("\t%s: %s", subject.getName(), Objects.toString(grade, "null")));
        }));
    }

    private void addSubjectWithStudents(Subject subject, List<Student> students) {
        List<Student> currentStudents = subjectStudentsMap.computeIfAbsent(subject, k -> new ArrayList<>());
        for (Student student : students) {
            if (!currentStudents.contains(student)) {
                currentStudents.add(student);
            }

            studentGradesMap.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    private void addStudentForSubject(Student student, Subject subject) {
        addSubjectWithGrade(student, subject, null);
    }

    private void printAllSubjectsAndStudents() {
        subjectStudentsMap.forEach((subject, students) -> {
            System.out.println(subject);
            students.forEach(System.out::println);
        });
    }

}
