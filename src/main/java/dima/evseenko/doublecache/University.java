package dima.evseenko.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private final Map<Student, Map<Subject, Integer>> studentMarks = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentMark(Student student, Subject subject, int mark) {
        validateStudent(student);
        validateSubject(subject);
        validateMark(mark);

        studentMarks.computeIfAbsent(student, k -> new HashMap<>()).put(subject, mark);
    }

    public void addStudentMarks(Student student, Map<Subject, Integer> marks) {
        validateStudent(student);
        validateMarks(marks);

        marks.forEach((subject, mark) -> addStudentMark(student, subject, mark));
    }

    public void deleteStudentFromMarks(Student student) {
        validateStudent(student);

        studentMarks.remove(student);
    }

    public void deleteSubjectFromMarks(Student student, Subject subject) {
        validateStudent(student);
        validateSubject(subject);

        if(studentMarks.containsKey(student)) {
            studentMarks.get(student).remove(subject);
        }
    }

    public void addSubjectStudent(Subject subject, Student student) {
        validateSubject(subject);
        validateStudent(student);

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void addSubjectStudents(Subject subject, List<Student> students) {
        validateSubject(subject);
        validateStudents(students);

        students.forEach(s -> addSubjectStudent(subject, s));
    }

    public void deleteStudentFromSubject(Subject subject, Student student) {
        validateSubject(subject);
        validateStudent(student);

        if(subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
        }
    }

    public Map<Subject, Integer> getStudentMarks(Student student) {
        validateStudent(student);

        return studentMarks.get(student);
    }

    public List<Student> getSubjectStudents(Subject subject) {
        validateSubject(subject);

        return subjectStudents.get(subject);
    }

    private void validateStudent(Student student) {
        if(student == null)
            throw new IllegalArgumentException("Student is null");
        if(student.getId() == null)
            throw new IllegalArgumentException("Student id is null");
        if(student.getName() == null)
            throw new IllegalArgumentException("Student name is null");
    }

    private void validateSubject(Subject subject) {
        if(subject == null)
            throw new IllegalArgumentException("Subject is null");
        if(subject.getId() == null)
            throw new IllegalArgumentException("Subject id is null");
        if(subject.getName() == null)
            throw new IllegalArgumentException("Subject name is null");
    }

    private void validateStudents(List<Student> students) {
        if(students == null)
            throw new IllegalArgumentException("Students is null");
        students.forEach(this::validateStudent);
    }

    private void validateMark(int mark) {
        if(mark <= 0)
            throw new IllegalArgumentException("Mark must be greater than 0");
    }

    private void validateMarks(Map<Subject, Integer> marks) {
        if(marks == null)
            throw new IllegalArgumentException("Marks is null");
        marks.forEach((subject, integer) -> {
            validateSubject(subject);
            validateMark(integer);
        });
    }

    public void printStudentMarks() {
        studentMarks.forEach((student, marks) -> System.out.println(student+" "+marks));
    }

    public void printSubjectStudents() {
        subjectStudents.forEach((subject, students) -> System.out.println(subject+" "+students));
    }
}
