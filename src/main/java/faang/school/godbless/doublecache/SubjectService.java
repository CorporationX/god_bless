package faang.school.godbless.doublecache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class SubjectService {
    public void addSubjectWithStudents(Map<Subject, List<Student>> subjectMap, Subject subject, List<Student> students) {
        subjectMap.put(subject, students);
    }

    public void addStudentToSubject(Map<Subject, List<Student>> subjectMap, Subject subject, Student student) {
        subjectMap.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Map<Subject, List<Student>> subjectMap, Subject subject, Student student) {
        subjectAndStudentNullCheck(subject, student);

        requireNonNull(subjectMap.computeIfPresent(subject, (key, value) -> value)).remove(student);
    }

    public void showSubjectsInfo(Map<Subject, List<Student>> subjectMap) {
        subjectMap.forEach((subject, value) -> {
            System.out.println("Subject name: " + subject.getName());
            value.forEach(student -> System.out.println(" " + student.getName()));
        });
    }

    public void checkAndAddToStudentsBySubjectMap(Map<Subject, List<Student>> subjectMap, Student student, Subject subject) {
        if (!subjectMap.containsKey(subject)) {
            subjectMap.put(subject, new ArrayList<>());
        }
        if (!subjectMap.get(subject).contains(student)) {
            subjectMap.get(subject).add(student);
        }
    }

    private static void subjectAndStudentNullCheck(Subject subject, Student student) {
        if (subject == null || student == null) {
            System.out.println("Subject and student cannot be null");
        }
    }
}
