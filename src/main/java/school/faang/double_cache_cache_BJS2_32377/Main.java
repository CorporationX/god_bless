package school.faang.double_cache_cache_BJS2_32377;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Main {
    private Map<Student, Map<Subject, Integer>> studentsWithSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectsWithStudents = new HashMap<>();

    public static void main(String[] args) {

    }

    public void addStudent(Student student, Map<Subject, Integer> subjectsAndGrades,
                           Map<Student, Map<Subject, Integer>> students, Map<Subject, List<Student>> subjects) {
        students.put(student, subjectsAndGrades);
        for (Map.Entry<Subject, Integer> entry : subjectsAndGrades.entrySet()) {
            subjects.computeIfAbsent(entry.getKey(), key -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Subject subject, int grade, Student student,
                                     Map<Student, Map<Subject, Integer>> targetMap) {
        targetMap.get(student).put(subject, grade);
    }

    public void deleteStudentWithGrades(Student student, Map<Student, Map<Subject, Integer>> targetMap) {
        targetMap.remove(student);
    }

    public void printStudentsWithSubjectsGrades(Map<Student, Map<Subject, Integer>> mapForPrint) {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : mapForPrint.entrySet()) {
            String studentName = entry.getKey().getName();
            System.out.printf("\nStudent : %s, Subjects : ", studentName);

            for (Map.Entry<Subject, Integer> internalEntry : entry.getValue().entrySet()) {
                String subjectName = internalEntry.getKey().getName();
                int grade = internalEntry.getValue();
                System.out.printf("%s grade = %s, ", subjectName, grade);
            }
        }
    }

    public void addSubjectAndStudyingStudents(Subject subject, List<Student> students, Map<Subject, List<Student>> targetMap) {
        targetMap.put(subject, students);
    }

    public void addStudentToSubject(Student student, Subject subject, Map<Subject, List<Student>> targetMap) {
        targetMap.get(subject).add(student);
    }

    public void deleteStudentFromSubject(Student student, Subject subject, Map<Subject, List<Student>> targetMap) {
        targetMap.get(subject).remove(student);
    }

    public void printSubjectsAndStudyingStudents(Map<Subject, List<Student>> targetMap) {
        for (Map.Entry<Subject, List<Student>> entry : targetMap.entrySet()) {
            String subjectName = entry.getKey().getName();
            System.out.printf("\nSubject : %s. Students learning subject : ", subjectName);

            for (Student student : entry.getValue()) {
                System.out.printf("%s, ", student.getName());
            }
        }
    }

}


