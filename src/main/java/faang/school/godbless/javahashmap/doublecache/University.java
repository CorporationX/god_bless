package faang.school.godbless.javahashmap.doublecache;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class University {

    private final Map<Student, Map<Subject, Integer>> studentMarks = new HashMap<>();
    private final Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> marks) {
        studentMarks.put(student, marks);

        for (Map.Entry<Subject, Integer> entry : marks.entrySet()) {
            studentsBySubject.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Subject subject, Student student, int mark) {
        Map<Subject, Integer> marks = studentMarks.computeIfAbsent(student, k -> new HashMap<>());
        marks.put(subject, mark);

        studentsBySubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        studentMarks.remove(student);

        for (List<Student> students : studentsBySubject.values()) {
            students.remove(student);
        }

        studentsBySubject.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

    public void printStudentMarks() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentMarks.entrySet()) {
            System.out.println("Student: " + entry.getKey());
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                System.out.println("    Subject: " + subjectEntry.getKey() + ", Mark: " + subjectEntry.getValue());
            }
        }
    }
}
