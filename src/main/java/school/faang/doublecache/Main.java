package school.faang.doublecache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> subjectGradesOfStudent =
            new HashMap<>();
    private static final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Ivan");
        Student student2 = new Student(2, "Masha");
        Subject math = new Subject(3, "Math");
        Subject physics = new Subject(4, "physics");
        Subject it = new Subject(5, "IT");

        addNewStudent(student1, math, 5);
        System.out.println("studentWithSubjects after adding new student: " + subjectGradesOfStudent);
        System.out.println("----------------");
        addNewStudent(student1, physics, 4);
        System.out.println("studentWithSubjects after adding existing student with new subject: " + subjectGradesOfStudent);
        System.out.println("----------------");
        addNewStudent(student2, math, 3);
        addNewStudent(student2, physics, 5);
        System.out.println("studentWithSubjects after adding new student with multiple subjects: " + subjectGradesOfStudent);
        System.out.println("----------------");
        addNewSubjectForStudent(student1, it, 6);
        System.out.println("studentWithSubjects after adding new subject for existing student: " + subjectGradesOfStudent);
        System.out.println("----------------");
        printAllStudents();
        System.out.println("----------------");
        removeStudent(student1);
        System.out.println("studentWithSubjects after removing student: " + subjectGradesOfStudent);
        System.out.println("----------------");
        printAllStudents();
        System.out.println("----------------");
        addSubjectWithStudents(math, List.of(student1, student2));
        System.out.println("studentWithThisSubject after adding subject with students: " + subjectStudents);
        System.out.println("----------------");
        addStudentToSubject(student1, physics);
        System.out.println("studentWithThisSubject after adding student to subject: " + subjectStudents);
        System.out.println("----------------");
        removeStudentFromSubject(student1, math);
        System.out.println("studentWithThisSubject after removing student from subject: " + subjectStudents);
        System.out.println("----------------");
        printAllSubjects();
    }

    public static void addNewStudent(Student student,
                                     Subject subject,
                                     Integer grade) {
        subjectGradesOfStudent.computeIfAbsent(student, v -> new HashMap<>())
                .put(subject, grade);
        subjectStudents.computeIfAbsent(subject, v -> new HashSet<>())
                .add(student);
    }

    public static void addNewSubjectForStudent(Student student,
                                               Subject subject,
                                               Integer grade) {
        subjectGradesOfStudent.computeIfPresent(student, (k, v) -> {
            v.put(subject, grade);
            subjectStudents
                    .computeIfAbsent(subject, s -> new HashSet<>()).add(student);
            return v;
        });
    }

    public static void removeStudent(Student student) {
        subjectGradesOfStudent.remove(student);
        subjectStudents.values().forEach(students -> students.remove(student));
    }

    public static void printAllStudents() {
        subjectGradesOfStudent.forEach((student, subjects) ->
                System.out.println(student + " " + subjects));
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> students) {
        students.forEach(student -> addNewStudent(student, subject, 5));
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        addNewStudent(student, subject, 4);
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        subjectGradesOfStudent.computeIfPresent(student, (k, v) -> {
            v.remove(subject);
            return v;
        });
        subjectStudents.get(subject).remove(student);
    }

    public static void printAllSubjects() {
        subjectStudents.forEach((subject, students) ->
                System.out.println(subject + " " + students));
    }
}