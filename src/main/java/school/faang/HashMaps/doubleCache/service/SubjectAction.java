package school.faang.HashMaps.doubleCache.service;

import school.faang.HashMaps.doubleCache.Student;
import school.faang.HashMaps.doubleCache.Subject;

import java.util.ArrayList;
import java.util.List;

import static school.faang.HashMaps.doubleCache.Main.STUDENT_MAP;
import static school.faang.HashMaps.doubleCache.Main.SUBJECT_MAP;

public class SubjectAction {
    public static void addSubject(Subject subject, List<Student> students) {
        SUBJECT_MAP.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if (STUDENT_MAP.containsKey(student)) {
            SUBJECT_MAP.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
        } else {
            System.out.println(student + " not found");
        }
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        SUBJECT_MAP.computeIfAbsent(subject, s -> new ArrayList<>()).remove(student);
    }

    public static void printSubjects() {
        SUBJECT_MAP.forEach((subject, list) -> {
            System.out.println("Subject: " + subject + " Students: ");
            list.forEach(System.out::println);
        });
    }
}
