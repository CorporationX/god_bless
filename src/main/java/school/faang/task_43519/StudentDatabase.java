package school.faang.task_43519;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> gradeBooks = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectParticipants = new HashMap<>();

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
        gradeBooks.forEach((student, subjectGrade) -> {
            System.out.println(student.name() + ":");
            subjectGrade.forEach((subject, grade) ->
                    System.out.println("\t" + subject.name() + ": " + grade));
        });
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
        subjectParticipants.forEach((subject, students) -> {
            System.out.println(subject.name() + ":");
            students.forEach(student -> System.out.println("\t" + student.name()));
        });
        System.out.println();
    }
}
