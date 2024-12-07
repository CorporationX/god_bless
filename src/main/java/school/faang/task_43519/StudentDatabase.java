package school.faang.task_43519;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> gradeBooks;
    private Map<Subject, Set<Student>> subjectParticipants;

    public StudentDatabase() {
        gradeBooks = new HashMap<>();
        subjectParticipants = new HashMap<>();
    }

    public void addNewStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        gradeBooks.put(student, grades);
    }

    public void addGradeForExistStudent(Student student, Subject subject, int grade) {
        gradeBooks.get(student).put(subject, grade);
    }

    public void removeStudent(Student student) {
        gradeBooks.remove(student);
    }

    public void printStudentsGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> gradeBook : gradeBooks.entrySet()) {
            System.out.println(gradeBook.getKey().getName() + ":");
            for (Map.Entry<Subject, Integer> subjectGrade : gradeBook.getValue().entrySet()) {
                System.out.println("\t" + subjectGrade.getKey().getName() + ": " + subjectGrade.getValue());
            }
        }
        System.out.println();
    }

    public void addNewSubject(Subject subject, Set<Student> students) {
        subjectParticipants.put(subject, students);
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectParticipants.get(subject).add(student);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        subjectParticipants.get(subject).remove(student);
    }

    public void printAllSubjects() {
        for (Map.Entry<Subject, Set<Student>> subject : subjectParticipants.entrySet()) {
            System.out.println(subject.getKey().getName() + ":");
            for (Student student : subject.getValue()) {
                System.out.println("\t" + student.getName());
            }
        }
        System.out.println();
    }
}
