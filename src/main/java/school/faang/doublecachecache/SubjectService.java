package school.faang.doublecachecache;

import java.util.ArrayList;
import java.util.List;

import static school.faang.doublecachecache.Main.GROUPED_SUB_AND_STUD;
import static school.faang.doublecachecache.Main.SUBJECTS;
import static school.faang.doublecachecache.StudentService.findStudentByName;

public class SubjectService {
    public static void addNewSubject(String subjectName, Student student) {
        if (student == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        Subject subject = findSubjectByName(subjectName);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        List<Student> studentsInSubject = GROUPED_SUB_AND_STUD.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!studentsInSubject.contains(student)) {
            studentsInSubject.add(student);
        }
    }

    public static void addStudentForExistSubject(String subjectName, Student student) {
        if (student == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        Subject subject = findSubjectByName(subjectName);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        if (GROUPED_SUB_AND_STUD.get(subject).contains(student)) {
            System.out.println("Student is already added for this subject!");
            return;
        }
        GROUPED_SUB_AND_STUD.computeIfAbsent(subject, sub -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(String studentName) {
        Student studentForRemove = findStudentByName(studentName);
        if (studentForRemove == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        for (List<Student> studentsInSubject : GROUPED_SUB_AND_STUD.values()) {
            studentsInSubject.remove(studentForRemove);
        }
    }

    public static void printInfoAboutSubjectsAndStudents() {
        for (var entry : GROUPED_SUB_AND_STUD.entrySet()) {
            System.out.println("Subject name: " + entry.getKey().getName());
            System.out.println("Students studying this subject: ");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }

    public static Subject findSubjectByName(String subjectName) {
        for (Subject subject : SUBJECTS) {
            if (subject.getName().equals(subjectName)) {
                return subject;
            }
        }
        return null;
    }
}
