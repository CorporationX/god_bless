package school.faang.doublecachecache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.doublecachecache.StudentService.findStudentByName;

public class SubjectService {
    public static void addNewSubject(String subjectName, Student student, Map<Subject, List<Student>> groupedSubAndStud, Set<Subject> subjects) {
        if (student == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        Subject subject = findSubjectByName(subjectName, subjects);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        List<Student> studentsInSubject = groupedSubAndStud.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!studentsInSubject.contains(student)) {
            studentsInSubject.add(student);
        }
    }

    public static void addStudentForExistSubject(String subjectName, Student student, Map<Subject, List<Student>> groupedSubAndStud, Set<Subject> subjects) {
        if (student == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        Subject subject = findSubjectByName(subjectName, subjects);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        if (groupedSubAndStud.get(subject).contains(student)) {
            System.out.println("Student is already added for this subject!");
            return;
        }
        groupedSubAndStud.computeIfAbsent(subject, sub -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(String studentName, Map<Student, Map<Subject, Integer>> students, Map<Subject, List<Student>> groupedSubAndStud) {
        Student studentForRemove = findStudentByName(studentName, students);
        if (studentForRemove == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        for (List<Student> studentsInSubject : groupedSubAndStud.values()) {
            studentsInSubject.remove(studentForRemove);
        }
    }

    public static void printInfoAboutSubjectsAndStudents(Map<Subject, List<Student>> groupedSubAndStud) {
        for (var entry : groupedSubAndStud.entrySet()) {
            System.out.println("Subject name: " + entry.getKey().getName());
            System.out.println("Students studying this subject: ");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }

    public static Subject findSubjectByName(String subjectName, Set<Subject> subjects) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                return subject;
            }
        }
        return null;
    }
}
