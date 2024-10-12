package Java_HashMap.BJS2_32512.Manager;

import Java_HashMap.BJS2_32512.Student;
import Java_HashMap.BJS2_32512.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubjectManager {

    public static void addNewSubjectAndStudents(Map<Subject, List<Student>> subjectStudents, Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>(students));
    }

    public static void addStudentToSubject(Map<Subject, List<Student>> subjectStudents, Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudentFromSubject(Map<Subject, List<Student>> subjectStudents, Subject subject, Student student) {
        List<Student> students = subjectStudents.get(subject);

        if (students != null && students.remove(student)) {
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
    }

    public static void printAllSubjects(Map<Subject, List<Student>> subjectStudents) {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();
            System.out.println("Предмет: " + subject.getName());
            for (Student student : students) {
                System.out.println("  Студент: " + student.getName());
            }
            System.out.println();
        }
    }
}
