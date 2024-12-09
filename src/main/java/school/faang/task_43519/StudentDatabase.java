package school.faang.task_43519;

import java.util.*;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> gradeBooks = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectParticipants = new HashMap<>();

    public void addNewStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        gradeBooks.put(student, grades);
    }

    public void addGradeForExistStudent(Student student, Subject subject, int grade) {
        gradeBooks.computeIfAbsent(student, key -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudent(Student student) {
        Optional.ofNullable(gradeBooks.remove(student)).
                orElseThrow(() -> new NoSuchElementException("Такого студента нет"));
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
        subjectParticipants.computeIfAbsent(subject, key -> new HashSet<>()).add(student);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        Optional.ofNullable(subjectParticipants.get(subject))
                .ifPresentOrElse(students -> students.remove(student),
                        () -> System.out.println("Такого предмета нет"));
    }

    public void printAllSubjects() {
        subjectParticipants.forEach((subject, students) -> {
            System.out.println(subject.name() + ":");
            students.forEach(student -> System.out.println("\t" + student.name()));
        });
        System.out.println();
    }
}
