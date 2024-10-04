package dima.evseenko.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentService {
    private final Map<Student, Map<Subject, Integer>> studentMarks = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentMark(Student student, Subject subject, int mark) {
        if(Objects.nonNull(student) && mark > 0 && Objects.nonNull(subject)) {
            studentMarks.computeIfAbsent(student, k -> new HashMap<>()).put(subject, mark);
        }
    }

    public void addStudentMarks(Student student, Map<Subject, Integer> marks) {
        if(Objects.nonNull(student) && Objects.nonNull(marks)) {
            marks.forEach((subject, mark) -> addStudentMark(student, subject, mark));
        }
    }

    public void deleteStudentFromMarks(Student student) {
        studentMarks.remove(student);
    }

    public void deleteSubjectFromMarks(Student student, Subject subject) {
        if(studentMarks.containsKey(student)) {
            studentMarks.get(student).remove(subject);
        }
    }

    public void addSubjectStudent(Subject subject, Student student) {
        if(Objects.nonNull(subject) && Objects.nonNull(student)) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectStudents(Subject subject, List<Student> students) {
        if(Objects.nonNull(subject) && Objects.nonNull(students)) {
            students.forEach(s -> addSubjectStudent(subject, s));
        }
    }

    public void deleteStudentFromSubject(Subject subject, Student student) {
        if(subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
        }
    }

    public Map<Subject, Integer> getStudentMarks(Student student) {
        return studentMarks.get(student);
    }

    public List<Student> getSubjectStudents(Subject subject) {
        return subjectStudents.get(subject);
    }

    public void printStudentMarks() {
        studentMarks.forEach((student, marks) -> System.out.println(student+" "+marks));
    }

    public void printSubjectStudents() {
        subjectStudents.forEach((subject, students) -> System.out.println(subject + " " + students));
    }
}
