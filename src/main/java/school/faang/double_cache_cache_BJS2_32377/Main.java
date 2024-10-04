package school.faang.double_cache_cache_BJS2_32377;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Main {
    private Map<Student, Map<Subject, Integer>> studentsListWithSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectsListWithStudents = new HashMap<>();

    public void addNewStudent(Student student, Map<Subject, Integer> subjectsAndGrades,
                              Map<Student, Map<Subject, Integer>> targetMap) {
        targetMap.put(student, subjectsAndGrades);
    }

    public void addNewSubjectForExistingStudent(Subject subject, int grade, Student student,
                                                Map<Student, Map<Subject, Integer>> targetMap) {
        targetMap.get(student).put(subject, grade);
    }

    public void deleteStudentWithGrades(Student student, Map<Student, Map<Subject, Integer>> targetMap) {
        targetMap.remove(student);
    }

    public void printAllStudentsWithSubjectsGrades(Map<Student, Map<Subject, Integer>> mapForPrint) {
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

    public void addNewSubjectAndStudyingStudents(Subject subject, List<Student> students, Map<Subject, List<Student>> targetMap) {
        targetMap.put(subject, students);
    }

    public void addNewStudentToExistingSubject(Student student, Subject subject, Map<Subject, List<Student>> targetMap) {
        targetMap.get(subject).add(student);
    }

    public void deleteStudentFromSubject(Student student, Subject subject, Map<Subject, List<Student>> targetMap) {
        targetMap.get(subject).remove(student);
    }

    public void printAllSubjectsAndStudyingStudents(Map<Subject, List<Student>> targetMap) {
        for (Map.Entry<Subject, List<Student>> entry : targetMap.entrySet()) {
            String subjectName = entry.getKey().getName();
            System.out.printf("\nSubject : %s. Students learning subject : ", subjectName);

            for (Student student : entry.getValue()) {
                System.out.printf("%s, ", student.getName());
            }
        }
    }

}


