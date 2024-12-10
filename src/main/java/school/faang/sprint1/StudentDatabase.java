package school.faang.sprint1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    private HashMap<Student, Map<Subject, Integer>> studentBySubjectAndEstimation;
    private HashMap<Subject, List<Student>> studentsBySubject;

    public void addGradeByStudents(Student student, Map<Subject, Integer> subjectAndEstimation) {
        studentBySubjectAndEstimation.put(student, subjectAndEstimation);
        for (Map.Entry<Subject, Integer> entry : subjectAndEstimation.entrySet()) {
           if (studentsBySubject.containsKey(entry.getKey())) {
               addStudentToExistingSubject(student, entry.getKey());
           }
           else {
               addStudentsBySubject(entry.getKey(), List.of(student));
           }
        }
    }

    public void addStudentAndGradeBySubject(Subject subject, Student student, int grade) {
        studentBySubjectAndEstimation.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        addStudentsBySubject(subject, List.of(student));
    }

    public void removeStudentAndSubjects(Student student) {
        Map<Subject, Integer> subjectAndEstimations = studentBySubjectAndEstimation.remove(student);
        for (Map.Entry<Subject, Integer> entry : subjectAndEstimations.entrySet()) {
            removeStudentFromSubject(entry.getKey(), student);
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentBySubjectAndEstimation.entrySet()) {
            for (Map.Entry<Subject, Integer> innerEntry: entry.getValue().entrySet()) {
                Subject subject = innerEntry.getKey();
                int estimation = innerEntry.getValue();
                System.out.println("student: " + entry.getKey() + "subject: " + subject + "estimation: " + estimation);
                System.out.println();
            }
        }
    }

    public void addStudentsBySubject(Subject subject, List<Student> students) {
        studentsBySubject.put(subject, students);
    }

    public void addStudentToExistingSubject(Student student, Subject subject) {
        if (studentsBySubject.containsKey(subject)) {
            studentsBySubject.get(subject).add(student);
        }
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        List<Student> students = studentsBySubject.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }
    public void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : studentsBySubject.entrySet()) {
            System.out.println(
                    "Subject: " + entry.getKey() + ", Students: "
            );
            for (Student student : entry.getValue()) {
                System.out.print("\t");
                System.out.print(student);
            }
        }
    }
}
