package school.faang.HashMaps.doubleCache.service;

import school.faang.HashMaps.doubleCache.Student;
import school.faang.HashMaps.doubleCache.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static school.faang.HashMaps.doubleCache.Main.STUDENT_MAP;
import static school.faang.HashMaps.doubleCache.Main.SUBJECT_MAP;
import static school.faang.HashMaps.doubleCache.service.SubjectAction.addStudentToSubject;
import static school.faang.HashMaps.doubleCache.service.SubjectAction.removeStudentFromSubject;

public class StudentAction {
    public static void addStudentWithSubject(Student student, Map<Subject, Integer> subject) {
        STUDENT_MAP.put(student, subject);
        subject.forEach((sub, grade) -> addStudentToSubject(sub, student));
    }

    public static void addSubjectForStudent(Subject subject, Student student, Integer grade) {
        SUBJECT_MAP.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        STUDENT_MAP.computeIfAbsent(student, s -> new HashMap<>()).put(subject, grade);
    }

    public static void removeStudent(Student student) {
        STUDENT_MAP.get(student).forEach((sub, grade) -> removeStudentFromSubject(sub, student));
        STUDENT_MAP.remove(student);
    }

    public static void printStudents() {
        STUDENT_MAP.forEach((student, map) -> {
            System.out.println(student + " {");
            map.forEach((subject, grade) -> System.out.println(subject + " Grade: " + grade));
            System.out.println("}");
        });
    }
}
