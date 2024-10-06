package school.faang.doublecache;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversityDB {
    public static final int MIN_MARK = 1;
    public static final int MAX_MARK = 5;

    private final Map<Student, Map<Subject, Integer>> studentToSubject = new HashMap<>();
    private final Map<Subject, List<Student>> subjectToStudent = new HashMap<>();

    public void addStudent(@NonNull Student student, @NonNull Map<Subject, Integer> subjectToMark) {
        studentToSubject.put(student, subjectToMark);
        for (Subject subject : subjectToMark.keySet()) {
            updateStudentList(student, subject);
        }
    }

    public void addSubject(@NonNull Subject subject, @NonNull Map<Student, Integer> studentToMark) {
        List<Student> students = new ArrayList<>(studentToMark.keySet());
        subjectToStudent.put(subject, students);
        for (Student student : students) {
            validateMark(studentToMark.get(student));
            updateSubjectToMark(student, subject, studentToMark.get(student));
        }
    }

    private void updateSubjectToMark(Student student, Subject subject, int studentToMark) {
        Map<Subject, Integer> subjectToMark = studentToSubject.getOrDefault(student, new HashMap<>());
        subjectToMark.put(subject, studentToMark);
        studentToSubject.put(student, subjectToMark);
    }

    public void addSubjectToStudent(@NonNull Student student, @NonNull Subject subject, int mark) {
        validateMark(mark);
        if (!studentToSubject.containsKey(student)) {
            throw new IllegalArgumentException("Student " + student + " does not exist");
        }
        Map<Subject, Integer> subjectToMark = studentToSubject.get(student);
        subjectToMark.put(subject, mark);
        updateStudentList(student, subject);
    }

    public void addStudentToSubject(@NonNull Student student, @NonNull Subject subject, int mark) {
        validateMark(mark);
        updateStudentList(student, subject);
        updateSubjectToMark(student, subject, mark);
    }

    public void removeStudent(Student student) {
        if (!studentToSubject.containsKey(student)) {
            return;
        }
        Map<Subject, Integer> subjectToMark = studentToSubject.remove(student);

        for (Subject subject : subjectToMark.keySet()) {
            List<Student> students = subjectToStudent.getOrDefault(subject, new ArrayList<>());
            students.remove(student);
            if (!students.isEmpty()) {
                subjectToStudent.remove(subject);
                continue;
            }
            subjectToStudent.put(subject, students);
        }
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (!subjectToStudent.containsKey(subject)) {
            return;
        }
        List<Student> students = subjectToStudent.get(subject);
        if (students == null) {
            return;
        }

        students.remove(student);
        if (students.isEmpty()) {
            subjectToStudent.remove(subject);
        } else {
            subjectToStudent.put(subject, students);
        }

        Map<Subject, Integer> subjectToMark = studentToSubject.getOrDefault(student, new HashMap<>());
        subjectToMark.remove(subject);
        if (subjectToMark.isEmpty()) {
            studentToSubject.remove(student);
        }
    }

    public void printMarksByStudent() {
        studentToSubject.forEach((student, subjects) -> System.out.println(student + ": " + subjects.values()));
        System.out.println();
    }

    public void printStudentsBySubject() {
        subjectToStudent.forEach((subject, students) -> System.out.println(subject + ": " + students));
        System.out.println();
    }

    private void validateMark(int mark) {
        if (mark < MIN_MARK || mark > MAX_MARK) {
            throw new IllegalArgumentException("У нас пятибальная шкала");
        }
    }

    private void updateStudentList(Student student, Subject subject) {
        List<Student> students = subjectToStudent.getOrDefault(subject, new ArrayList<>());
        students.add(student);
        subjectToStudent.put(subject, students);
    }
}
