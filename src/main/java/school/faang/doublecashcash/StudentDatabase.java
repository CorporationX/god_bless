package school.faang.doublecashcash;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class StudentDatabase {
    private static final String PRINT_NAME_STUDENT_FORMAT = "Student %s:";
    private static final String PRINT_NAME_SUBJECT_FORMAT = "Subject - %s: ";
    private static final String PRINT_SCORE_FORMAT = "score - %d";
    private static final String TAB_LINE_FORMAT = "  ";
    private static final Integer ABSENCE_OF_SCORE = 0;

    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(String studentName, Map<Subject, Integer> subjects) {
        if (!subjects.isEmpty()) {
            subjects.forEach((subject, score) ->
                    addSubjectForStudent(studentName, subject.getName(), score));
        } else {
            throw new NullPointerException("Map subject is empty");
        }
    }

    public void addSubjectForStudent(String studentName, String subjectName, Integer score) {
        Student student = new Student(studentName);
        Subject subject = new Subject(subjectName);

        addForStudent(student, subject, score);
        addForSubject(subject, student);
    }

    private void addForSubject(Subject subject, Student student) {
        if (subjectStudents.containsKey(subject)) {
            if (!subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).add(student);
            }
        } else {
            subjectStudents.computeIfAbsent(subject, key ->
                    new ArrayList<>()).add(student);
        }
    }

    public void deleteStudentAndHisSubjects(String studentName) {
        Student student = new Student(studentName);

        if (studentSubjects.containsKey(student)) {
            studentSubjects.remove(student);
            deleteFromSubjects(student);
        } else {
            System.out.println("Student " + studentName + " does not exist.");
        }
    }

    private void deleteFromSubjects(Student student) {
        subjectStudents.forEach((subject, students) ->
                subjectStudents.get(subject).remove(student));
    }

    public void printAllStudentSubjects() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.printf(PRINT_NAME_STUDENT_FORMAT + "\n", student.getName());
            subjects.forEach((subject, score) -> {
                System.out.printf(TAB_LINE_FORMAT + PRINT_NAME_SUBJECT_FORMAT, subject.getName());
                System.out.printf(PRINT_SCORE_FORMAT + "\n", score);
            });
        });
        System.out.println();
    }

    public void addSubject(String subjectName, List<Student> students) {
        if (!students.isEmpty()) {
            students.forEach((student) ->
                    addStudentForSubject(subjectName, student.getName()));
        } else {
            throw new NullPointerException("List of students is empty.");
        }
    }

    public void addStudentForSubject(String subjectName, String studentName) {
        Subject subject = new Subject(subjectName);
        Student student = new Student(studentName);

        addForSubject(subject, student);
        addForStudent(student, subject, ABSENCE_OF_SCORE);
    }

    private void addForStudent(Student student, Subject subject, Integer score) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).put(subject, score);
        } else {
            studentSubjects.computeIfAbsent(student, key ->
                    new HashMap<>()).put(subject, score);
        }
    }

    public void deleteStudentFromSubjects(String subjectName, String studentName) {
        Subject subject = new Subject(subjectName);
        Student student = new Student(studentName);

        if (studentSubjects.containsKey(student)) {
            if (subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).remove(student);
                deleteFromStudents(student, subject);
            } else {
                System.out.println("Subject " + subjectName + " does not exist.");
            }
        } else {
            System.out.println("Student " + studentName + " does not exist.");
        }
    }

    private void deleteFromStudents(Student student, Subject subject) {
        studentSubjects.get(student).remove(subject);
    }

    public void printAllSubjectStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.printf(PRINT_NAME_SUBJECT_FORMAT + "\n", subject.getName());
            students.forEach(student ->
                    System.out.println(TAB_LINE_FORMAT + student.getName()));
        });
        System.out.println();
    }
}
