package faang.school.godbless.doublecache;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SubjectService {
    public void addSubjectWithStudents(Map<Subject, List<Student>> subjectMap, Subject subject, List<Student> students) {
        subjectMap.put(subject, students);
    }

    public void addStudentToSubject(Map<Subject, List<Student>> subjectMap, Subject subject, Student student) {
        subjectNullCheck(subjectMap, subject);
        subjectMap.get(subject).add(student);
    }

    public void removeStudentFromSubject(Map<Subject, List<Student>> subjectMap, Subject subject, Student student) {
        subjectNullCheck(subjectMap, subject);
        Objects.requireNonNull(subjectMap.computeIfPresent(subject, (key, value) -> value)).remove(student);
    }

    public void showSubjectsInfo(Map<Subject, List<Student>> subjectMap) {
        subjectMap.forEach((subject, value) -> {
            System.out.println("Subject name: " + subject.getName());
            value.forEach(student -> System.out.println(" " + student.getName()));
        });
    }

    private static void subjectNullCheck(Map<Subject, List<Student>> subjectMap, Subject subject) {
        if (!subjectMap.containsKey(subject)) {
            throw new IllegalArgumentException("The subject doesn't not exist in the map");
        }
    }
}
