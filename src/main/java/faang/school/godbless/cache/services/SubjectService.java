package faang.school.godbless.cache.services;

import faang.school.godbless.cache.models.Student;
import faang.school.godbless.cache.models.Subject;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.cache.Main.subjectsWithStudents;

public class SubjectService {

    public static void addNewSubjectAndStudentListInSubjectMap(Subject subject, List<Student> students) {
        subjectsWithStudents.putIfAbsent(subject, students);
    }

    public static void addNewStudentToSubjectInSubjectMap(Subject subject, Student student) {
        List<Student> students = new ArrayList<>();

        if (subjectsWithStudents.containsKey(subject)) {
            students = subjectsWithStudents.get(subject);
        }

        students.add(student);

        if (!subjectsWithStudents.containsKey(subject)) {
            subjectsWithStudents.put(subject, students);
        }
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        if (subjectsWithStudents.containsKey(subject)) {
            subjectsWithStudents.get(subject).remove(student);
        }
    }

    public static void printSubjectAndStudents() {
        subjectsWithStudents.forEach((subject, students) -> {
            if (students != null) {
                System.out.println(subject + " studied next students:");
                students.forEach(student -> System.out.println("   " + student));
            }
        });
    }
}
