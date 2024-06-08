package faang.school.godbless.university;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceSubject {

    public Map<Subject, List<Student>> createStudentBySubject(Subject subject, List<Student> students) {
        if (students == null || students.isEmpty() || subject == null) {
            throw new IllegalArgumentException();
        }
        Map<Subject, List<Student>> studentsBySubject = new HashMap<>();
        studentsBySubject.put(subject, students);
        return studentsBySubject;
    }

    public void addNewStudentToSubject(Map<Subject, List<Student>> studentsBySubject, Subject subject, Student student) {
        if (studentsBySubject.isEmpty() || subject == null || student == null) {
            throw new IllegalArgumentException();
        }
        studentsBySubject.get(subject).add(student);
    }

    public void removeSubject(Map<Subject, List<Student>> studentsBySubject, Subject subject, Student student) {
        if (studentsBySubject.isEmpty() || subject == null || student == null) {
            throw new IllegalArgumentException();
        }
        studentsBySubject.get(subject).remove(student);
    }

    public void printAllSubject(Map<Subject, List<Student>> studentsBySubject) {
        if (studentsBySubject.isEmpty()) {
            System.out.println("The passed data structure is empty");
        }
        studentsBySubject.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
